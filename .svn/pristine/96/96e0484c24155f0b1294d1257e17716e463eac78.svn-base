package com.gzdmg.xmt.pyinterface.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.net.ssl.SSLEngineResult.Status;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.Service.State;
import com.gzdmg.xmt.pyinterface.dao.ITemplateItemDao;
import com.gzdmg.xmt.pyinterface.dao.ITextItemDao;
import com.gzdmg.xmt.pyinterface.dao.common.IOperations;
import com.gzdmg.xmt.pyinterface.model.DAOException;
import com.gzdmg.xmt.pyinterface.model.SearchFormBean;
import com.gzdmg.xmt.pyinterface.model.ServiceException;
import com.gzdmg.xmt.pyinterface.model.TemplateItem;
import com.gzdmg.xmt.pyinterface.model.TextItem;
import com.gzdmg.xmt.pyinterface.service.ITextItemService;
import com.gzdmg.xmt.pyinterface.service.common.AbstractService;

@Service("textItemService")
public class TextItemService extends AbstractService<TextItem> implements ITextItemService {

	@Resource(name = "textItemDao")
	private ITextItemDao dao;
	
	@Resource(name="templateItemDao")
	private ITemplateItemDao templateItemDao;

	@Override
	protected IOperations<TextItem> getDao() {
		return this.dao;
	}

	@Override
	public int getSearchTextItemCount(SearchFormBean searchBean) throws ServiceException {
		try {
			String sql = makeSearchSqlString(searchBean);
			return dao.queryCountBySql(sql);
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}
	}

	@Override
	public List<TextItem> getSearchTextItemsByPage(SearchFormBean searchBean, int offset, int pageSize)
			throws ServiceException {
		List<TextItem> textItems = new ArrayList<>();
		try {
			String sql = makeSearchSqlString(searchBean);
			List<Object[]> list = dao.queryBySqlByPage(sql, offset, pageSize);

			for (Object[] objects : list) {
				TextItem item = new TextItem();
				item.setId(((BigInteger) objects[0]).longValue());
				item.setTitle((String) objects[1]);
				item.setStatus((int) objects[2]);
				item.setPublishDate((Date) objects[3]);
				item.setCollectionName((String) objects[4]);
				item.setModuleName((String) objects[5]);
				textItems.add(item);
			}
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}
		return textItems;
	}
	
	private String makeSearchSqlString(SearchFormBean searchBean){
		String sql = "SELECT ti.id, ti.title, ti.status, ti.publish_date, c.name as c_name, tm.name as m_name "
				+ "from tb_text_item as ti LEFT JOIN tb_text_collection as tc ON ti.id=tc.tid "
				+ "LEFT JOIN tb_collection as c ON tc.cid=c.id "
				+ "LEFT JOIN tb_template_item as tpi on c.id=tpi.cid or ti.id=tpi.txid "
				+ "LEFT JOIN tb_template as tp ON tpi.tpid=tp.id " + "LEFT JOIN tb_module as tm ON tp.id=tm.tid "
				+ "WHERE 1=1 ";

		if (StringUtils.isNotEmpty(searchBean.getTitle())) {
			sql += " and ti.title LIKE '%" + searchBean.getTitle() + "%' ";
		}
		if (searchBean.getStatus() != -100) {
			sql += " and ti.status=" + searchBean.getStatus() + " ";
		}
		if (!"NONE".equals(searchBean.getScollection())) {
			sql += " and c.name='" + searchBean.getScollection() + "' ";
		}
		if (!"NONE".equals(searchBean.getSmodule())) {
			sql += " and tm.name='" + searchBean.getSmodule() + "' ";
		}
		if (StringUtils.isNotEmpty(searchBean.getFromDate())) {
			sql += " and ti.publish_date>'" + searchBean.getFromDate() + "' ";
		}
		if (StringUtils.isNotEmpty(searchBean.getToDate())) {
			sql += " and ti.publish_date<'" + searchBean.getToDate() + "' ";
		}
		sql += " ORDER BY ti.created_date DESC";
		
		return sql;
	}

	@Override
	public void deleteTextItemByID(long id) throws ServiceException {
		try {
			TextItem item = dao.getOne(id);
			if(item == null)
				throw new Exception("图文为空，id：" + id);
			
//			if(item.getCollections() != null && item.getCollections().size() != 0){
//				item.setCollections(null);
//				dao.update(item);
//			}
			
			List<TemplateItem> templateItems = templateItemDao.getTemplateItemsByTextItemID(id);
			if(templateItems != null && !templateItems.isEmpty()){
				for (TemplateItem templateItem : templateItems) {
					templateItem.setTextItem(null);
					templateItemDao.update(templateItem);
				}
			}
			
			dao.delete(item);
		} catch (Exception e) {
			throw new ServiceException(e.toString());
		}
	}
	
	

}
