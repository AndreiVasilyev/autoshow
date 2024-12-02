package by.clevertec.autoshow.service;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.Client;
import by.clevertec.autoshow.exception.ServiceException;

public interface ClientService {

    void addClient(Client client) throws ServiceException;

    void buyCar(Client client, Car car) throws ServiceException;
}
