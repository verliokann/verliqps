package ru.verlioka.cmf.appservices.libraryfund.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import ru.verlioka.cmf.appservices.libraryfund.models.Author;
import ru.verlioka.cmf.appservices.libraryfund.models.BookSeries;
import ru.verlioka.cmf.appservices.libraryfund.models.Books;
import ru.verlioka.cmf.appservices.libraryfund.services.concrete.LibraryService;

import java.util.List;

@Controller
@EnableTransactionManagement
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @RequestMapping(value = "/books/create", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity createBooks(@RequestBody List<Books> books) {

        libraryService.addBooks(books);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Books getBooksById(@PathVariable int id) {
        return libraryService.getBook(id);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody
    List<Books> getBooks() {
        return libraryService.getAllBooks();
    }

    @RequestMapping(value = "/books/{id}/series", method = RequestMethod.GET)
    public @ResponseBody
    BookSeries getSeriesByBookId(@PathVariable int id) {
        return libraryService.getBookSeries(id);
    }

    @RequestMapping(value = "/series", method = RequestMethod.GET)
    public @ResponseBody
    List<BookSeries> getAllSeries() {
        return libraryService.getAllBookSeries();
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity createAuthor(@RequestBody Author author) {
        libraryService.addAuthor(author);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
