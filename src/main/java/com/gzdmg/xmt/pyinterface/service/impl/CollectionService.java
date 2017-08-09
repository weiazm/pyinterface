package com.gzdmg.xmt.pyinterface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gzdmg.xmt.pyinterface.dao.ICollectionDao;
import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.Collection;
import com.gzdmg.xmt.pyinterface.service.ICollectionService;
import com.gzdmg.xmt.pyinterface.service.common.AbstractService;

@Service("collectionService")
public class CollectionService extends AbstractService<Collection> implements ICollectionService {

	@Resource(name="collectionDao")
	private ICollectionDao dao;
	
	@Override
	protected IOperations<Collection> getDao() {
		return this.dao;
	}

}
