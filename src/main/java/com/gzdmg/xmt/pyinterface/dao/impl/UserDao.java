package com.gzdmg.xmt.pyinterface.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gzdmg.xmt.pyinterface.dao.IUserDao;
import com.gzdmg.xmt.pyinterface.dao.common.AbstractHibernateDao;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.User;

@Repository("userDao")
public class UserDao extends AbstractHibernateDao<User> implements IUserDao  {


	public UserDao() {
		super();
		setClazz(User.class);
	}

	public User getUserByUsername(String username) throws DAOException {
		try {
			List users = getCurrentSession().createQuery("from User where username=?").setParameter(0, username).list();

			if (users == null || users.isEmpty()) {
				return null;
			} else {
				return (User) users.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	
}
