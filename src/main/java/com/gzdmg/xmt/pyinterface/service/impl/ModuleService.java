package com.gzdmg.xmt.pyinterface.service.impl;

import javax.annotation.Resource;

import com.gzdmg.xmt.pyinterface.dto.ModuleDto;
import org.springframework.stereotype.Service;

import com.gzdmg.xmt.pyinterface.dao.IModuleDao;
import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.Module;
import com.gzdmg.xmt.pyinterface.service.IModuleService;
import com.gzdmg.xmt.pyinterface.service.common.AbstractService;

import java.util.List;

@Service("moduleService")
public class ModuleService extends AbstractService<Module> implements IModuleService {

	@Resource(name="moduleDao")
	private IModuleDao dao;
	
	@Override
	protected IOperations<Module> getDao() {
		return this.dao;
	}
	
}
