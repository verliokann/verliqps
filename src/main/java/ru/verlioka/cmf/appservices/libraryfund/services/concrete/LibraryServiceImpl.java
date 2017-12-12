package ru.verlioka.cmf.appservices.libraryfund.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.libraryfund.dao.concrete.AuthorDao;
import ru.verlioka.cmf.appservices.libraryfund.dao.concrete.BookSeriesDao;
import ru.verlioka.cmf.appservices.libraryfund.dao.concrete.BooksDao;
import ru.verlioka.cmf.appservices.libraryfund.models.Author;
import ru.verlioka.cmf.appservices.libraryfund.models.BookSeries;
import ru.verlioka.cmf.appservices.libraryfund.models.Books;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import java.util.List;

@Service("libraryServiceImpl")
public class LibraryServiceImpl extends GenericServiceImpl<Books, Integer>
        implements LibraryService {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BookSeriesDao bookSeriesDao;

    private BooksDao booksDao;

    public LibraryServiceImpl() {
    }

    @Autowired
    public LibraryServiceImpl(BooksDao genericDao) {
        super(genericDao);
        this.booksDao = genericDao;
    }

    @Override
    public List<Books> getAllBooks() {

        return getAll();
    }

    @Override
    public Books getBook(int bookId) {
        return find(bookId);
    }

    @Override
    public List<BookSeries> getAllBookSeries() {
        return bookSeriesDao.getAll();
    }

    @Override
    public BookSeries getBookSeries(int bookId) {
        return find(bookId).getBookSeries();
    }

    @Override
    public void addBooks(List<Books> books) {
        for(Books book : books){
            if(book.getBookSeries() == null){
                BookSeries bookSeries = getBookSeries(book.getId());
                if(bookSeries == null){
                    BookSeries emptyBookSeries = new BookSeries();
                    emptyBookSeries.setAuthor(book.getAuthor());
                    emptyBookSeries.setBatchNumber(0);
                    emptyBookSeries.setReceiptDate(null);
                    emptyBookSeries.setSeriesNum(0);
                    emptyBookSeries.setSeriesName("No series");
                    book.setBookSeries(emptyBookSeries);
                    bookSeriesDao.insert(emptyBookSeries);
                }
            }
            Author author = book.getAuthor();
            if(author != null){
                authorDao.insert(author);
            }
            bookSeriesDao.insert(book.getBookSeries());
            add(book);
        }
    }

    @Override
    public void addAuthor(Author author) {
        authorDao.insert(author);
    }
}
