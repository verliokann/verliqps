package ru.verlioka.cmf.appservices.libraryfund.services.concrete;


import ru.verlioka.cmf.appservices.libraryfund.models.Author;
import ru.verlioka.cmf.appservices.libraryfund.models.BookSeries;
import ru.verlioka.cmf.appservices.libraryfund.models.Books;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface LibraryService extends IGenericService<Books, Long> {

    List<Books> getAllBooks();
    Books getBook(Long bookId);

    List<BookSeries> getAllBookSeries();
    BookSeries getBookSeries(Long bookId);

    void addBooks(List<Books> books);

    void addAuthor(Author author);

    List getBookSeriesByBookQuery(Long bookId);

    List getBookSeriesByBookCriteria(Long bookId);

    List getAllBooksQuery();
    List getAllBooksCriteria();

}
