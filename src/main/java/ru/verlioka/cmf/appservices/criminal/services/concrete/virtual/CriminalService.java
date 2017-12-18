package ru.verlioka.cmf.appservices.criminal.services.concrete.virtual;

import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

import ru.verlioka.cmf.appservices.criminal.models.Criminal;

public interface CriminalService extends IGenericService<Criminal, Long> {
	
	public List getNotProccessed();	
}