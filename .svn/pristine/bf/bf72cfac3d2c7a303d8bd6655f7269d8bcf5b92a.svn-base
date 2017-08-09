package com.gzdmg.xmt.pyinterface.service;

import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.ServiceException;
import com.gzdmg.xmt.pyinterface.model.User;

public interface IUserService extends IOperations<User>  {
	public User getUserByUsername(String username) throws ServiceException;
	
	public boolean login(String username, String password) throws ServiceException;
	
	public int changePasswd(String oldPasswd, String newPasswd) throws ServiceException;
}
