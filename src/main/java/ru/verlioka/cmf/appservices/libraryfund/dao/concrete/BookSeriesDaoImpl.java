package ru.verlioka.cmf.appservices.libraryfund.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.libraryfund.models.BookSeries;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("bookSeriesDaoImpl")
public class BookSeriesDaoImpl extends GenericDaoImpl<BookSeries, Integer> implements BookSeriesDao {


}
