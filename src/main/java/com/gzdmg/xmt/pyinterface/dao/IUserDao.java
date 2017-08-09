package com.gzdmg.xmt.pyinterface.dao;

import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.User;

public interface IUserDao extends IOperations<User>  {

	public User getUserByUsername(String username) throws DAOException;
}
