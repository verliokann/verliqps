package ru.verlioka.cmf.appservices.libraryfund.dao.concrete;

import ru.verlioka.cmf.appservices.libraryfund.controllers.response.BookResponse;
import ru.verlioka.cmf.appservices.libraryfund.models.Books;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;

import java.util.List;


public interface BooksDao extends IGenericDao<Books, Long> {

    List getBookSeriesByBookQuery(Long bookId);
    List getBookSeriesByBookCriteria(Long bookId);

    BookResponse getBookByIdQuery(Long bookId);
    List getBookByIdCriteria(Long bookId);
    List getAllBooksQuery();
    List getAllBooksCriteria();
}
