package by.clevertec.autoshow.dao;

import by.clevertec.autoshow.exception.DaoException;
import by.clevertec.autoshow.util.HibernateUtil;
import jakarta.persistence.QueryHint;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jpa.AvailableHints;

import java.util.List;

public interface CommonDao {

    default <T> List<T> findAll(Class<T> clazz) throws DaoException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = "from " + clazz.getSimpleName();
            List<T> entities = session
                    .createQuery(hql, clazz)
                    .list();
            transaction.commit();
            return entities;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    default <T> T findById(long id, Class<T> clazz) throws DaoException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            T entity = session.find(clazz, id);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    default <T> void save(T entity) throws DaoException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    default <T> void update(T entity) throws DaoException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    default <T> void delete(T entity) throws DaoException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
