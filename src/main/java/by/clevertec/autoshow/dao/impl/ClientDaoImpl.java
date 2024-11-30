package by.clevertec.autoshow.dao.impl;

import by.clevertec.autoshow.dao.ClientDao;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientDaoImpl implements ClientDao {

    @Getter
    private static final ClientDao instance = new ClientDaoImpl();
}
