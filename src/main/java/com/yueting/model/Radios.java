package com.yueting.model;

import javax.persistence.CascadeType;
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
@Table(name = "yt_radios")
public class Radios {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "iterm_id")
	private Integer itermId;
	
	private String name;
	
	private String url;
	
	private int size ;
	
	private String site;
	
	//可选属性optional=false,表示iterm不能为空。删除radios，不影响iterm
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},
			optional = false)
	//设置在yt_radios表中的关联字段(外键)
	@JoinColumn(name="iterm_id")
	private Iterm iterm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItermId() {
		return itermId;
	}

	public void setItermId(Integer itermId) {
		this.itermId = itermId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Iterm getIterm() {
		return iterm;
	}

	public void setIterm(Iterm iterm) {
		this.iterm = iterm;
	}
}
