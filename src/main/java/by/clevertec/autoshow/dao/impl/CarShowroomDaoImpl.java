package by.clevertec.autoshow.dao.impl;

import by.clevertec.autoshow.dao.CarShowroomDao;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarShowroomDaoImpl implements CarShowroomDao {

    @Getter
    private static final CarShowroomDao instance = new CarShowroomDaoImpl();
}
