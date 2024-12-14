package by.clevertec.autoshow.controller;

import by.clevertec.autoshow.exception.ExceptionObject;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = {NoSuchElementException.class,
            Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionObject response400(@RequestBody Exception exception) {
        return agregate(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionObject response404(@RequestBody Exception exception) {
        return agregate(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ValidationException.class,
            MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ExceptionObject response422(@RequestBody Exception exception) {
        return agregate(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private ExceptionObject agregate(String message, HttpStatus status) {
        return new ExceptionObject(status.value(), String.valueOf(status), message);
    }
}
