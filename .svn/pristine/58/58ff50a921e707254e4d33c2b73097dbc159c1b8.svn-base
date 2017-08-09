package com.gzdmg.xmt.pyinterface.dao;

import java.util.List;

import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.TextItem;

public interface ITextItemDao extends IOperations<TextItem> {

	public int queryCountBySql(String sql) throws DAOException;
	
	public List queryBySqlByPage(String sql, int offset, int pageSize) throws DAOException;
}
