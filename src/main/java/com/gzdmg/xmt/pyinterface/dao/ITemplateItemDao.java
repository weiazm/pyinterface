package com.gzdmg.xmt.pyinterface.dao;

import java.util.List;

import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.TemplateItem;

public interface ITemplateItemDao extends IOperations<TemplateItem> {

	public List<TemplateItem> getTemplateItemsByTextItemID(long tid) throws DAOException;
}
