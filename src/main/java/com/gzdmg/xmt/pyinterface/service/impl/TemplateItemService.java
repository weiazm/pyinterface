package com.gzdmg.xmt.pyinterface.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzdmg.xmt.pyinterface.dao.ITemplateItemDao;
import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.ServiceException;
import com.gzdmg.xmt.pyinterface.model.TemplateItem;
import com.gzdmg.xmt.pyinterface.service.ITemplateItemService;
import com.gzdmg.xmt.pyinterface.service.common.AbstractService;

@Service("templateItemService")
public class TemplateItemService extends AbstractService<TemplateItem> implements ITemplateItemService {

	@Resource(name="templateItemDao")
	private ITemplateItemDao dao;
	
	@Override
	protected IOperations<TemplateItem> getDao() {
		return this.dao;
	}

	@Override
	public List<TemplateItem> getTemplateItemsByTextItemID(long tid) throws ServiceException {
		try {
			return dao.getTemplateItemsByTextItemID(tid);
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}
	}

}
