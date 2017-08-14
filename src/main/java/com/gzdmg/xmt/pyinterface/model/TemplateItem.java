package com.gzdmg.xmt.pyinterface.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_template_item")
public class TemplateItem implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//图片链接
	@Column(name = "image_link", length = 256)
	private String imageLink;
	
	/**
	 * 类型（图文、视频或合集）
	 * 1：图文
	 * 2：视频
	 * 3：合集
	 */
	@Column(name = "type")
	private int type;
	
	@ManyToOne
	@JoinColumn(name="txid")
	private TextItem textItem;
	
	@ManyToOne
	@JoinColumn(name="vid")
	private VideoItem videoItem;
	
	@ManyToOne
	@JoinColumn(name="cid")
	private Collection collection;

	@Column(name = "created_date", updatable = false)
	private Date createdDate = new Date();

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="tpid")
	private Template template;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public TextItem getTextItem() {
		return textItem;
	}

	public void setTextItem(TextItem textItem) {
		this.textItem = textItem;
	}

	public VideoItem getVideoItem() {
		return videoItem;
	}

	public void setVideoItem(VideoItem videoItem) {
		videoItem = videoItem;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}
	
	
}
