package com.gzdmg.xmt.pyinterface.dao.impl;

import org.springframework.stereotype.Repository;

import com.gzdmg.xmt.pyinterface.dao.ICollectionDao;
import com.gzdmg.xmt.pyinterface.dao.common.AbstractHibernateDao;
import com.gzdmg.xmt.pyinterface.model.Collection;

@Repository("collectionDao")
public class CollectionDao extends AbstractHibernateDao<Collection> implements ICollectionDao {

	public CollectionDao() {
		super();
		setClazz(Collection.class);
	}
}
