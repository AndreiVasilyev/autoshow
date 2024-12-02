package by.clevertec.autoshow.dao.impl;

import by.clevertec.autoshow.dao.ReviewDao;
import by.clevertec.autoshow.entity.Review;
import by.clevertec.autoshow.exception.DaoException;
import by.clevertec.autoshow.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;


import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewDaoImpl implements ReviewDao {

    @Getter
    private static final ReviewDao instance = new ReviewDaoImpl();


    @Override
    public List<Review> findByText(String keyword) throws DaoException {
        try (Session session = HibernateUtil.getSession();
             EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
             ) {
            SearchSession searchSession = Search.session( entityManager );
            MassIndexer indexer = searchSession.massIndexer( Review.class )
                    .threadsToLoadObjects( 5 );
            indexer.startAndWait();
            Transaction transaction = session.beginTransaction();
            SearchResult<Review> result = searchSession.search( Review.class )
                    .where( f -> f.match()
                            .fields( "text" )
                            .matching( keyword ) )
                    .fetch( 5 );
            transaction.commit();
            return result.hits();
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Review> findByRate(int rate) throws DaoException {
        try (Session session = HibernateUtil.getSession();
             EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        ) {
            SearchSession searchSession = Search.session( entityManager );
            MassIndexer indexer = searchSession.massIndexer( Review.class )
                    .threadsToLoadObjects( 5 );
            indexer.startAndWait();
            Transaction transaction = session.beginTransaction();
            SearchResult<Review> result = searchSession.search( Review.class )
                    .where( f -> f.match()
                            .fields( "rate" )
                            .matching( rate ) )
                    .fetch( 5 );
            transaction.commit();
            return result.hits();
        } catch (InterruptedException e) {
            throw new DaoException(e);
        }
    }
}
