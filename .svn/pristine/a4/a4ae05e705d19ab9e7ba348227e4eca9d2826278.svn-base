package com.gzdmg.xmt.pyinterface.service;

import java.util.List;

import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.SearchFormBean;
import com.gzdmg.xmt.pyinterface.model.ServiceException;
import com.gzdmg.xmt.pyinterface.model.TextItem;

public interface ITextItemService extends IOperations<TextItem> {

	public int getSearchTextItemCount(SearchFormBean searchBean) throws ServiceException;
	
	public List<TextItem> getSearchTextItemsByPage(SearchFormBean searchBean, int offset, int pageSize) throws ServiceException;
	
	public void deleteTextItemByID(long id) throws ServiceException;
}
