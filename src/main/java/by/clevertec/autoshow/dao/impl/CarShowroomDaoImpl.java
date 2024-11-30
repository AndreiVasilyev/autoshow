package by.clevertec.autoshow.dao.impl;

import by.clevertec.autoshow.dao.CarShowroomDao;
import by.clevertec.autoshow.entity.CarShowroom;
import by.clevertec.autoshow.exception.DaoException;
import by.clevertec.autoshow.util.HibernateUtil;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarShowroomDaoImpl implements CarShowroomDao {

    @Getter
    private static final CarShowroomDao instance = new CarShowroomDaoImpl();

    @Override
    public List<CarShowroom> findAll() throws DaoException {
        try (Session session = HibernateUtil.getSession();
             EntityManager entityManager = session.getEntityManagerFactory().createEntityManager()) {
            Transaction transaction = session.beginTransaction();
            EntityGraph<?> entityGraph = entityManager.getEntityGraph("showroomWithCars");
            List<CarShowroom> carShowrooms = session
                    .createQuery("FROM CarShowroom", CarShowroom.class)
                    .setHint("javax.persistence.fetchgraph", entityGraph)
                    .getResultList();
            transaction.commit();
            return carShowrooms;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
