package ru.verlioka.cmf.appservices.decay.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.decay.model.peopleEntity;

import java.util.List;

@Repository("peopleDaoImpl")
public class peopleDaoImpl
        implements peopleDao {
    @Override
    public peopleEntity insert(peopleEntity entity) {
        return null;
    }

    @Override
    public peopleEntity update(peopleEntity entity) {
        return null;
    }

    @Override
    public void delete(peopleEntity entity) {

    }

    @Override
    public peopleEntity find(Long key) {
        return null;
    }

    @Override
    public <E> List<E> getAll() {
        return null;
    }

    @Override
    public List getEntityStructure() {
        return null;
    }
}