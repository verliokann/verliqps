package ru.verlioka.cmf.appservices.TextStucture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.TextStucture.Models.TextType;
import ru.verlioka.cmf.appservices.TextStucture.dao.TypeDao;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("TypeServiceImpl")
public class TypeServiceImpl extends GenericServiceImpl<TextType, Long>
    implements TypeService{

    public TypeServiceImpl() {}

    @Autowired
    public TypeServiceImpl(TypeDao genericDao) {super (genericDao);}
}
