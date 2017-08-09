package com.gzdmg.xmt.pyinterface.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.gzdmg.xmt.pyinterface.dao.ITemplateItemDao;
import com.gzdmg.xmt.pyinterface.dao.common.AbstractHibernateDao;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.TemplateItem;

@Repository("templateItemDao")
public class TemplateItemDao extends AbstractHibernateDao<TemplateItem> implements ITemplateItemDao {

	public TemplateItemDao() {
		super();
		setClazz(TemplateItem.class);
	}

	@Override
	public List<TemplateItem> getTemplateItemsByTextItemID(long tid) throws DAOException {
		try {
			List templateItems = getCurrentSession().createQuery("from TemplateItem as ti where ti.textItem.id=?").setParameter(0, tid).list();

			if (templateItems == null || templateItems.isEmpty()) {
				return null;
			} else {
				return templateItems;
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
