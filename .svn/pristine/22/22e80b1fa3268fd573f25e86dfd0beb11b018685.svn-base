package com.gzdmg.xmt.pyinterface.dao.common;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.common.base.Preconditions;
import com.gzdmg.xmt.pyinterface.model.DAOException;

public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {

	private Class<T> clazz;

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	protected final void setClazz(final Class<T> clazzToSet) {
		this.clazz = Preconditions.checkNotNull(clazzToSet);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public T getOne(long id) throws DAOException {
		try {
			return (T) getCurrentSession().get(clazz, id);
		} catch (Exception e) {
			throw e;
		}

	}

	public List<T> getAll() throws DAOException {
		try {
			return getCurrentSession().createQuery("from " + clazz.getName()).list();
		} catch (Exception e) {
			throw e;
		}

	}

	public void create(T entity) throws DAOException {
		try {
			Preconditions.checkNotNull(entity);
			getCurrentSession().saveOrUpdate(entity);
		} catch (Exception e) {
			throw e;
		}

	}

	public T update(T entity) throws DAOException {
		try {
			Preconditions.checkNotNull(entity);
			getCurrentSession().update(entity);
			return entity;
		} catch (Exception e) {
			throw e;
		}

	}

	public void delete(T entity) throws DAOException {
		try {
			Preconditions.checkNotNull(entity);
			getCurrentSession().delete(entity);
		} catch (Exception e) {
			throw e;
		}

	}

	public void deleteById(long entityId) throws DAOException {
		try {
			final T entity = getOne(entityId);
			Preconditions.checkState(entity != null);
			getCurrentSession().delete(entity);
		} catch (Exception e) {
			throw e;
		}

	}

}
