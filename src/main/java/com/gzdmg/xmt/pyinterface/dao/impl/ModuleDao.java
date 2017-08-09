package com.gzdmg.xmt.pyinterface.dao.impl;

import org.springframework.stereotype.Repository;

import com.gzdmg.xmt.pyinterface.dao.IModuleDao;
import com.gzdmg.xmt.pyinterface.dao.common.AbstractHibernateDao;
import com.gzdmg.xmt.pyinterface.model.Module;

@Repository("moduleDao")
public class ModuleDao extends AbstractHibernateDao<Module> implements IModuleDao {

	public ModuleDao() {
		super();
		setClazz(Module.class);
	}
}
