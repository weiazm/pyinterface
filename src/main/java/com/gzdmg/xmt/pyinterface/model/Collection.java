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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_collection")
public class Collection implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//合集名称
	@Column(name = "name", length = 128)
	private String name;
	
	/**
	 * 合集类型（专题、活动或一般图文合集等）
	 * 1：图文合集
	 * 2：专题
	 * 3：活动
	 */
	@Column(name = "type")
	private int type;

	@Column(name = "created_date", updatable = false)
	private Date createdDate = new Date();

	@Column(name = "updated_date")
	private Date updatedDate;
	
	@ManyToMany(mappedBy="collections")
	private List<TextItem> textItems;
	
	@ManyToMany(mappedBy="collections")
	private List<VideoItem> videoItems;
	
	@OneToMany(mappedBy="collection")
	@JsonIgnore
	private List<TemplateItem> templateItem;

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public List<TextItem> getTextItems() {
		return textItems;
	}

	public void setTextItems(List<TextItem> textItems) {
		this.textItems = textItems;
	}

	public List<VideoItem> getVideoItems() {
		return videoItems;
	}

	public void setVideoItems(List<VideoItem> videoItems) {
		this.videoItems = videoItems;
	}

	public List<TemplateItem> getTemplateItem() {
		return templateItem;
	}

	public void setTemplateItem(List<TemplateItem> templateItem) {
		this.templateItem = templateItem;
	}

	
	
}
