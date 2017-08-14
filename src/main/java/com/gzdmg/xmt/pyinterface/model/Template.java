package com.gzdmg.xmt.pyinterface.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_template")
public class Template implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", length = 64)
	private String name;

	@Column(name = "created_date", updatable = false)
	private Date createdDate = new Date();

	@Column(name = "updated_date")
	private Date updatedDate;
	
	@OneToMany(mappedBy="template")
	private List<TemplateItem> templateItems;
	
	@JsonIgnore
	@OneToMany(mappedBy="template")
	private List<Module> modules;

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

	public List<TemplateItem> getTemplateItems() {
		return templateItems;
	}

	public void setTemplateItems(List<TemplateItem> templateItems) {
		this.templateItems = templateItems;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	
}
