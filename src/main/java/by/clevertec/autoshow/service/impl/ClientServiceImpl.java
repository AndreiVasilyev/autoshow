package by.clevertec.autoshow.service.impl;

import by.clevertec.autoshow.dao.CarDao;
import by.clevertec.autoshow.dao.ClientDao;
import by.clevertec.autoshow.dao.impl.CarDaoImpl;
import by.clevertec.autoshow.dao.impl.ClientDaoImpl;
import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.Client;
import by.clevertec.autoshow.exception.DaoException;
import by.clevertec.autoshow.exception.ServiceException;
import by.clevertec.autoshow.service.ClientService;

public class ClientServiceImpl implements ClientService {
    @Override
    public void addClient(Client client) throws ServiceException {
        try {
            ClientDaoImpl.getInstance().save(client);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void buyCar(Client client, Car car) throws ServiceException {
        ClientDao clientDao = ClientDaoImpl.getInstance();
        client.getCars().add(car);
        try {
            clientDao.update(client);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
