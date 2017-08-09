package com.gzdmg.xmt.pyinterface.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_module")
public class Module implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//模块名称
	@Column(name = "name", length = 64)
	private String name;
	
	//模块排序序号
	@Column(name = "m_order")
	private int mOrder;
	
	//模块上线状态
	@Column(name = "m_status")
	private int mStatus;

	@Column(name = "created_date", updatable = false)
	private Date createdDate = new Date();

	@Column(name = "updated_date")
	private Date updatedDate;
	
	@ManyToOne
	@JoinColumn(name="tid")
	private Template template;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getmOrder() {
		return mOrder;
	}

	public void setmOrder(int mOrder) {
		this.mOrder = mOrder;
	}

	public int getmStatus() {
		return mStatus;
	}

	public void setmStatus(int mStatus) {
		this.mStatus = mStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}
	
	
}
