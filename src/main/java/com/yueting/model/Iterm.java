package com.yueting.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
* @ClassName: Iterm 
* @Description: 一对多，多对多参考：https://liuyanzhao.com/7913.html
* @author WX: skyone5
* @date 2018年6月25日 下午5:52:02 
*
 */
@Entity
@Table(name = "yt_iterm")
public class Iterm {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id ;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cover_img")
	private String coverImg;
	
	//级联保存、更新、删除、刷新;延迟加载。
	//当删除Iterm，会级联删除 对应的radios
    //拥有mappedBy注解的实体类为关系被维护端
     //mappedBy="iterm"中的iterm是Radios中的iterm属性
	@OneToMany(mappedBy="iterm", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<Radios> radioList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}

	@Override
	public String toString() {
		return "Iterm [id=" + id + ", name=" + name + ", coverImg=" + coverImg + "]";
	}

	public List<Radios> getRadioList() {
		return radioList;
	}

	public void setRadioList(List<Radios> radioList) {
		this.radioList = radioList;
	}
	
	
}
