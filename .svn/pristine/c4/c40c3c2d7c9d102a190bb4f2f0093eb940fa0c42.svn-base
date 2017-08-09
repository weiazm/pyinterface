package com.gzdmg.xmt.pyinterface.dao.common;

import java.io.Serializable;
import java.util.List;

import com.gzdmg.xmt.pyinterface.model.DAOException;

public interface IOperations<T extends Serializable> {

	T getOne(final long id) throws DAOException;
	
	List<T> getAll() throws DAOException;

    void create(final T entity) throws DAOException;

    T update(final T entity) throws DAOException;

    void delete(final T entity) throws DAOException;

    void deleteById(final long entityId) throws DAOException;
}
