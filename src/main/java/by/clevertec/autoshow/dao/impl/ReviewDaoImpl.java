package by.clevertec.autoshow.dao.impl;

import by.clevertec.autoshow.dao.ReviewDao;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewDaoImpl implements ReviewDao {

    @Getter
    private static final ReviewDao instance = new ReviewDaoImpl();

}
