package by.clevertec.autoshow.dao.impl;

import by.clevertec.autoshow.dao.CarDao;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarDaoImpl implements CarDao {

    @Getter
    private static final CarDao instance = new CarDaoImpl();
}
