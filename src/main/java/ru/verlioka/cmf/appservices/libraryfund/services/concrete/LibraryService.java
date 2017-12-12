package ru.verlioka.cmf.appservices.libraryfund.services.concrete;


import ru.verlioka.cmf.appservices.libraryfund.models.Author;
import ru.verlioka.cmf.appservices.libraryfund.models.BookSeries;
import ru.verlioka.cmf.appservices.libraryfund.models.Books;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface LibraryService extends IGenericService<Books, Integer> {

    List<Books> getAllBooks();
    Books getBook(int bookId);

    List<BookSeries> getAllBookSeries();
    BookSeries getBookSeries(int bookId);

    void addBooks(List<Books> books);

    void addAuthor(Author author);

}
