package by.clevertec.autoshow.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class LogBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Class<?>> loggingBeansWithTypeTarget = new HashMap<>();
    private final Map<String, Class<?>> loggingBeansWithMethodTarget = new HashMap<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClassWithTypeTarget = loggingBeansWithTypeTarget.get(beanName);
        if (beanClassWithTypeTarget != null) {
            return Proxy.newProxyInstance(beanClassWithTypeTarget.getClassLoader(), beanClassWithTypeTarget.getInterfaces(),
                    (proxy, method, args) -> logAndInvokeMethod(method, args, bean));
        }
        Class<?> beanClassWithMethodTarget = loggingBeansWithMethodTarget.get(beanName);
        if (beanClassWithMethodTarget != null) {
            return Proxy.newProxyInstance(beanClassWithMethodTarget.getClassLoader(), beanClassWithMethodTarget.getInterfaces(),
                    (proxy, method, args) -> {
                        Method method1 = beanClassWithMethodTarget.getMethod(method.getName(), method.getParameterTypes());
                        if (method1.isAnnotationPresent(InjectParamsLogging.class)) {
                            return logAndInvokeMethod(method, args, bean);
                        }
                        return method.invoke(bean, args);
                    });
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(InjectParamsLogging.class)) {
            loggingBeansWithTypeTarget.put(beanName, bean.getClass());
        }
        Method[] methods = bean.getClass().getMethods();
        List<Method> list = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(InjectParamsLogging.class))
                .toList();
        if (!list.isEmpty()) {
            loggingBeansWithMethodTarget.put(beanName, bean.getClass());
        }
        return bean;
    }

    private Object logAndInvokeMethod(Method method, Object[] args, Object bean) throws InvocationTargetException, IllegalAccessException {
        log.info("called method {} ", method.getName());
        if (args != null && args.length > 0) {
            log.info("with arguments: ");
            Arrays.stream(args).forEach(arg -> log.info("type:{}   value:{}", arg.getClass().getSimpleName(), arg));
        }else {
            log.info("without arguments");
        }
        return method.invoke(bean, args);
    }
}
