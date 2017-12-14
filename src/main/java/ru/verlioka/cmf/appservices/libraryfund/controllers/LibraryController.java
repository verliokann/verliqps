package ru.verlioka.cmf.appservices.libraryfund.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.libraryfund.services.concrete.LibraryService;

import java.util.List;

@Controller
@RequestMapping("/kayumov")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    public LibraryController() {
    }

    @RequestMapping(value = "/bookSeriesQuery/{id}", method = RequestMethod.GET)
    public @ResponseBody List getBookSeriesByBookQuery(@PathVariable long id) {
        return libraryService.getBookSeriesByBookQuery(id);
    }


    @RequestMapping(value = "/bookSeriesCriteria/{id}", method = RequestMethod.GET)
    public @ResponseBody List getBookSeriesByBookCriteria(@PathVariable long id) {
        return libraryService.getBookSeriesByBookCriteria(id);
    }



}
