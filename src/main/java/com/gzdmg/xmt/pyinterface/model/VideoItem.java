package com.gzdmg.xmt.pyinterface.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "tb_video_item")
public class VideoItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//影片ContentID
	@Column(name = "content_id", length = 64)
	private String ContentID;
	
	//影片名称
	@Column(name = "name", length = 256)
	private String name;
	
	//影片海报链接
	@Column(name = "image_link", length = 256)
	private String imageLink;
	
	//播放次数
	@Column(name = "play_count")
	private int playCount;
	
	//影片时长
	@Column(name = "duration")
	private int duration;
	
	//影片介绍
	@Type(type="text")
	@Column(name="intro")
	private String intro;

	@Column(name = "created_date", updatable = false)
	private Date createdDate = new Date();

	@Column(name = "updated_date")
	private Date updatedDate;
	
	@ManyToMany
	@JoinTable(name="tb_video_collection",
	joinColumns={@JoinColumn(name="vid")}, 
	inverseJoinColumns={@JoinColumn(name="cid")})
	@JsonIgnore
	private List<Collection> collections;
	
	@OneToMany(mappedBy="videoItem")
	@JsonIgnore
	private List<TemplateItem> templateItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContentID() {
		return ContentID;
	}

	public void setContentID(String contentID) {
		ContentID = contentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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

	
	
}
