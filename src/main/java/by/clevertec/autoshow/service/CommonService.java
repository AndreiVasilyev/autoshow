package by.clevertec.autoshow.service;

import by.clevertec.autoshow.exception.ServiceException;

import java.util.List;

public interface CommonService {

    <T> List<T> findAll(Class<T> clazz) throws ServiceException;

    <T> T findById(long id, Class<T> clazz) throws ServiceException;

    <T> void save(T entity) throws ServiceException;

    <T> void update(T entity) throws ServiceException;

    <T> void delete(T entity) throws ServiceException;
}
