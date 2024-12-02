package by.clevertec.autoshow.dao;

import by.clevertec.autoshow.entity.Client;
import by.clevertec.autoshow.exception.DaoException;

import java.util.List;

public interface ClientDao extends CommonDao {

    default List<Client> findAll() throws DaoException {
        return findAll(Client.class);
    }

    default Client findById(long id) throws DaoException {
        return findById(id, Client.class);
    }
}
