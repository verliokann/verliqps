package ru.verlioka.cmf.appservices.libraryfund.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.libraryfund.models.Books;
import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository("booksDaoImpl")
public class BooksDaoImpl extends GenericDaoImpl<Books, Integer>
        implements BooksDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createBooksWithSeries() {
        
    }
}
