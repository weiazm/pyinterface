package com.gzdmg.xmt.pyinterface.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_text_item")
public class TextItem implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//标题
	@NotEmpty
	@Column(name = "title", length = 256)
	private String title;
	
	//显示时间
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@Column(name = "publish_date")	
	private Date publishDate;
	
	//内容（以HTML格式保存）
	@NotEmpty
	@Type(type="text")
	@Column(name="content")
	private String content;
	
	/**
	 * 发布状态
	 * -1：未审核
	 * -2：审核不通过
	 * -3：下线
	 * 1：上线
	 * 2：审核通过
	 * 初始状态为未审核
	 */
	@Column(name="status")
	private int status = -1;

	@Column(name = "created_date", updatable = false)
	private Date createdDate = new Date();

	@Column(name = "updated_date")
	private Date updatedDate = new Date();
	
	@ManyToMany
	@JoinTable(name="tb_text_collection",
	joinColumns={@JoinColumn(name="tid")}, 
	inverseJoinColumns={@JoinColumn(name="cid")})
	@JsonIgnore
	private List<Collection> collections;
	
	@OneToMany(mappedBy="textItem")
	@JsonIgnore
	private List<TemplateItem> templateItem;
	
	//所属集合名称 
	private String collectionName;
	
	//所属板块名称
	private String moduleName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}

	public List<TemplateItem> getTemplateItem() {
		return templateItem;
	}

	public void setTemplateItem(List<TemplateItem> templateItem) {
		this.templateItem = templateItem;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
}
