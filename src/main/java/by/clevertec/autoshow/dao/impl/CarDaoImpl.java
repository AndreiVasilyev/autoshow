package by.clevertec.autoshow.dao.impl;

import by.clevertec.autoshow.dao.CarDao;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.exception.DaoException;
import by.clevertec.autoshow.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarDaoImpl implements CarDao {

    @Getter
    private static final CarDao instance = new CarDaoImpl();

    @Override
    public List<Car> findCarsByFilters(String brand, String category, int year, double minPrice, double maxPrice) throws DaoException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
            Root<Car> root = criteriaQuery.from(Car.class);
            criteriaQuery.select(root);
            List<Predicate> predicates = createPredicates(criteriaBuilder, root, brand, category, year, minPrice, maxPrice);
            criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            Query<Car> query = session.createQuery(criteriaQuery);
            List<Car> cars = query.getResultList();
            transaction.commit();
            return cars;
        }
    }

    @Override
    public List<Car> findAllCarsOrderByPriceAsc() throws DaoException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
            Root<Car> root = criteriaQuery.from(Car.class);
            criteriaQuery.select(root);
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get("price")));
            Query<Car> query = session.createQuery(criteriaQuery);
            List<Car> cars = query.getResultList();
            transaction.commit();
            return cars;
        }
    }

    @Override
    public List<Car> findAllCarsOrderByPriceDesc() throws DaoException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
            Root<Car> root = criteriaQuery.from(Car.class);
            criteriaQuery.select(root);
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("price")));
            Query<Car> query = session.createQuery(criteriaQuery);
            List<Car> cars = query.getResultList();
            transaction.commit();
            return cars;
        }
    }

    private List<Predicate> createPredicates(CriteriaBuilder criteriaBuilder, Root<Car> root,
                                             String brand, String category, int year, double minPrice, double maxPrice) {
        List<Predicate> predicates = new ArrayList<>();
        if (brand != null && !brand.isEmpty()) {
            Predicate predicate = criteriaBuilder.equal(root.get("brand"), brand);
            predicates.add(predicate);
        }
        if (category != null && !category.isEmpty()) {
            Predicate predicate = criteriaBuilder.equal(root.get("category").get("name"), category);
            predicates.add(predicate);
        }
        if (year != 0) {
            Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("year"), year);
            predicates.add(predicate);
        }
        if (minPrice <= maxPrice) {
            Predicate predicate = criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            predicates.add(predicate);
        }
        return predicates;
    }
}
