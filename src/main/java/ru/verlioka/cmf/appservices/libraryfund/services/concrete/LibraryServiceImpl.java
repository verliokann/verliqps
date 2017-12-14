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
public class LibraryServiceImpl extends GenericServiceImpl<Books, Long>
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
        return super.getAll();
    }

    @Override
    public Books getBook(Long bookId) {
        return super.find(bookId);
    }

    @Override
    public List<BookSeries> getAllBookSeries() {
        return bookSeriesDao.getAll();
    }

    @Override
    public BookSeries getBookSeries(Long bookId) {
        return find(bookId).getBookSeries();
    }

    @Override
    public void addBooks(List<Books> books) {
        for (Books book : books) {
            if (book.getBookSeries() == null) {
                BookSeries bookSeries = getBookSeries(book.getId());
                if (bookSeries == null) {
                    BookSeries emptyBookSeries = new BookSeries();
                    emptyBookSeries.setAuthor(book.getAuthor());
                    emptyBookSeries.setBatchNumber(0l);
                    emptyBookSeries.setReceiptDate(null);
                    emptyBookSeries.setSeriesNum(0l);
                    emptyBookSeries.setSeriesName("No series");
                    book.setBookSeries(emptyBookSeries);
                    bookSeriesDao.insert(emptyBookSeries);
                }
            }
            Author author = book.getAuthor();
            if (author != null) {
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

    public List getBookSeriesByBookQuery(Long bookId) {
        return booksDao.getBookSeriesByBookQuery(bookId);
    }

    @Override
    public List getBookSeriesByBookCriteria(Long bookId) {
        return booksDao.getBookSeriesByBookCriteria(bookId);
    }

    @Override
    public List getAllBooksQuery() {
        return booksDao.getAllBooksQuery();
    }

    @Override
    public List getAllBooksCriteria() {
        return booksDao.getAllBooksCriteria();
    }
}
