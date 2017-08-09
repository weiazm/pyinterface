package com.gzdmg.xmt.pyinterface.service.common;

import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.ServiceException;

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

	protected abstract IOperations<T> getDao();

	public T getOne(long id) throws ServiceException {
		try {
			return getDao().getOne(id);
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}

	}

	public List<T> getAll() throws ServiceException {
		try {
			return getDao().getAll();
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}

	}

	public void create(T entity) throws ServiceException {
		try {
			getDao().create(entity);
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}

	}

	public T update(T entity) throws ServiceException {
		try {
			return getDao().update(entity);
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}

	}

	public void delete(T entity) throws ServiceException {
		try {
			getDao().delete(entity);
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}

	}

	public void deleteById(long entityId) throws ServiceException {
		try {
			getDao().deleteById(entityId);
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}

	}

}
