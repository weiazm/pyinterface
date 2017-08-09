package com.gzdmg.xmt.pyinterface.service;

import java.util.List;

import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.ServiceException;
import com.gzdmg.xmt.pyinterface.model.TemplateItem;

public interface ITemplateItemService extends IOperations<TemplateItem> {

	public List<TemplateItem> getTemplateItemsByTextItemID(long tid) throws ServiceException;
}
