package ru.verlioka.cmf.appservices.libraryfund.dao.concrete;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.internal.QueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.libraryfund.controllers.response.BookResponse;
import ru.verlioka.cmf.appservices.libraryfund.controllers.response.SeriesResponse;
import ru.verlioka.cmf.appservices.libraryfund.models.BookSeries;
import ru.verlioka.cmf.appservices.libraryfund.models.Books;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository("booksDaoImpl")
public class BooksDaoImpl extends GenericDaoImpl<Books, Long>
        implements BooksDao {

    private static final String GET_SERIES_QUERY =
            "select series.id, series.seriesName, book.name, book.author, series.bookNum, series.batchNumber, series.receiptDate " +
                    "from BookSeries series, Books book " +
                    "where book.bookSeries = series and book.id = :id";


    @PersistenceContext
    private EntityManager em;

    public List getBookSeriesByBookCriteria(Long bookId) {
        Session session = ((Session) em.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Books.class, "book");
        criteria.createAlias("book.bookSeries", "series");
        criteria.createAlias("book.author", "author");
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("series.id"), "id")
                .add(Projections.property("series.seriesName"), "seriesName")
                .add(Projections.property("book.name"), "bookName")
                .add(Projections.property("author.firstName"), "authorName")
                .add(Projections.property("series.bookNum"), "bookNum")
                .add(Projections.property("series.batchNumber"), "batchNumber")
                .add(Projections.property("series.receiptDate"), "receiptDate")
        );
        criteria.add(Restrictions.eq("book.id", bookId));
        criteria.setResultTransformer(Transformers.aliasToBean(SeriesResponse.class));
        return criteria.list();

    }


    public List getBookSeriesByBookQuery(Long bookId) {
        Query query = em.createQuery(GET_SERIES_QUERY);
        query.setParameter("id", bookId);
        return query.getResultList();
    }

    @Override
    public BookResponse getBookByIdQuery(Long bookId) {
        Query query = em.createQuery("from Books where id = :id", Books.class);
        query.setParameter("id", bookId);
        return (BookResponse) query.getResultList();
    }

    @Override
    public List getAllBooksQuery() {
        Query query = em.createQuery("from Books");
        return query.getResultList();
    }


    @Override
    public List getBookByIdCriteria(Long bookId) {
        Criteria criteria = buildGetAllBooksCriteria();
        criteria.add(Restrictions.eq("book.id", bookId));
        return criteria.list();
    }

    @Override
    public List getAllBooksCriteria() {
        return buildGetAllBooksCriteria().list();
    }

    private Criteria buildGetAllBooksCriteria(){
        Session session = ((Session) em.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Books.class, "book");
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("book.name"), "bookName")
                .add(Projections.property("book.id"), "bookNumber")
                .add(Projections.property("book.author"), "author")
                .add(Projections.property("book.publish_date"), "publishDate")
                .add(Projections.property("book.publisher_name"), "publisher")
        );
        criteria.setResultTransformer(Transformers.aliasToBean(BookResponse.class));
        return criteria;
    }


}
