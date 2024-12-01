package by.clevertec.autoshow.dao.impl;

import by.clevertec.autoshow.dao.CarShowroomDao;
import by.clevertec.autoshow.entity.CarShowroom;
import by.clevertec.autoshow.exception.DaoException;
import by.clevertec.autoshow.util.HibernateUtil;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
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
    public List<CarShowroom> findAllWithEntityGraph() throws DaoException {
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

    @Override
    public List<CarShowroom> findAllWithJoinFetch() throws DaoException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<CarShowroom> criteriaQuery = criteriaBuilder.createQuery(CarShowroom.class);
            Root<CarShowroom> root = criteriaQuery.from(CarShowroom.class);
            Fetch<Object, Object> cars = root.fetch("cars", JoinType.LEFT);
            cars.fetch("category", JoinType.LEFT);
            List<CarShowroom> carShowrooms = session
                    .createQuery(criteriaQuery)
                    .getResultList();
            transaction.commit();
            return carShowrooms;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
