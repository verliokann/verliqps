package ru.verlioka.cmf.appservices.libraryfund.dao.concrete;

import ru.verlioka.cmf.appservices.libraryfund.models.Books;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;


public interface BooksDao extends IGenericDao<Books, Integer> {

    void createBooksWithSeries();
}
