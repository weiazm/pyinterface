package com.gzdmg.xmt.pyinterface.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.gzdmg.xmt.pyinterface.dao.IUserDao;
import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.ServiceException;
import com.gzdmg.xmt.pyinterface.model.User;
import com.gzdmg.xmt.pyinterface.service.IUserService;
import com.gzdmg.xmt.pyinterface.service.common.AbstractService;
import com.gzdmg.xmt.pyinterface.util.EncryptUtil;

@Service("userService")
public class UserService extends AbstractService<User> implements IUserService  {

	@Resource(name = "userDao")
	private IUserDao dao;

	public UserService() {
		super();
	}

	@Override
	protected IOperations<User> getDao() {
		return this.dao;
	}

	public User getUserByUsername(String username) throws ServiceException {
		try {
			return dao.getUserByUsername(username);
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}
	}
	
	@Override
	public int changePasswd(String oldPasswd, String newPasswd) throws ServiceException {
		try {
			User admin = dao.getUserByUsername("admin");
			if(admin == null)
				return -1;
			if(!EncryptUtil.MD5(oldPasswd).equals(admin.getPassword()))
				return -2;
			
			admin.setPassword(EncryptUtil.MD5(newPasswd));
			this.dao.update(admin);
			return 1;
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}
	}

	@Override
	public boolean login(String username, String password) throws ServiceException {
		try {
			User user = dao.getUserByUsername(username);
			if(user == null)
				return false;
			if(EncryptUtil.MD5(password).equals(user.getPassword()))
				return true;
			else
				return false;
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}
	}
}
