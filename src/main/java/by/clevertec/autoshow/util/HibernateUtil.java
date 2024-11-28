package by.clevertec.autoshow.util;


import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.CarShowroom;
import by.clevertec.autoshow.entity.Category;
import by.clevertec.autoshow.entity.Client;
import by.clevertec.autoshow.entity.Review;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@UtilityClass
public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Car.class)
                    .addAnnotatedClass(CarShowroom.class)
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Review.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession() {
        getSessionFactory().close();
    }

}
