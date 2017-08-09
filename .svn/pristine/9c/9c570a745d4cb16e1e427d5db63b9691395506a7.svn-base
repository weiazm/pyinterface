package com.gzdmg.xmt.pyinterface.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gzdmg.xmt.pyinterface.dao.ITextItemDao;
import com.gzdmg.xmt.pyinterface.dao.common.AbstractHibernateDao;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.TextItem;
import com.gzdmg.xmt.pyinterface.model.User;

@Repository("textItemDao")
public class TextItemDao extends AbstractHibernateDao<TextItem> implements ITextItemDao {

	public TextItemDao() {
		super();
		setClazz(TextItem.class);
	}

	@Override
	public List queryBySqlByPage(String sql, int offset, int pageSize) throws DAOException {
		try {
			List<Object[]> list = getCurrentSession().createSQLQuery(sql).setFirstResult(offset).setMaxResults(pageSize).list();

			return list;
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int queryCountBySql(String sql) throws DAOException {
		try {
			List<Object[]> list = getCurrentSession().createSQLQuery(sql).list();

			return list.size();
			
		} catch (Exception e) {
			throw e;
		}
	}

	
}
