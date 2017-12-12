package ru.verlioka.cmf.appservices.libraryfund.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.libraryfund.models.Author;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("authorDaoImpl")
public class AuthorDaoImpl extends GenericDaoImpl<Author, Integer> implements AuthorDao {
}
