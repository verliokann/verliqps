package ru.verlioka.cmf.appservices.TextStucture.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.TextStucture.Models.TextType;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("TypeDaoImpl")
public class TypeDaoImpl extends GenericDaoImpl<TextType, Long>
    implements TypeDao
{
}
