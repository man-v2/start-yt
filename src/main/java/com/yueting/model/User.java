package com.yueting.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="yt_user")
public class User /*implements Serializable*/{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="password")
	@NotBlank
	private String password;

	/**
	 * 微信openId
	 */
	@Column(name="open_id")
	@NotBlank
	private String openId;
	
	@Column(name="mobile")
	@NotBlank
	private String mobile;
	
	/**
	 * 会员类型；0：游客，1：1元7天试用，3：59半年会员，4:88一年会员
	 */
	@Column(name="vip")
	private Integer vip;

	/**
	 * 0：正常状态，1：已到期，2：黑名单用户
	 */
	@Column(name="status")
	private Integer status;
	
	/**
	 * 创建时间
	 */
	@Column(name="start_time")
	private Date startTime = new Date();
	
	/**
	 * 到期时间
	 */
	@Column(name="due_time")
	private Date dueTime;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="country")
	private String country;
	
	@Column(name="province")
	private String province;
	
	@Column(name="city")
	private String city;
	
	/**
	 * 被推广的编码-取微信号后6位值
	 */
	@Column(name="extention_code")
	private String extentionCode;
	
	/**
	 * 是否续订用户
	 */
	@Column(name="renew_subsription")
	private Integer renewSubsription;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getDueTime() {
		return dueTime;
	}

	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getExtentionCode() {
		return extentionCode;
	}

	public void setExtentionCode(String extentionCode) {
		this.extentionCode = extentionCode;
	}

	public Integer getRenewSubsription() {
		return renewSubsription;
	}

	public void setRenewSubsription(Integer renewSubsription) {
		this.renewSubsription = renewSubsription;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", openId=" + openId + ", mobile="
				+ mobile + ", vip=" + vip + ", status=" + status + ", startTime=" + startTime + ", dueTime=" + dueTime
				+ ", gender=" + gender + ", country=" + country + ", province=" + province + ", city=" + city
				+ ", extentionCode=" + extentionCode + ", renewSubsription=" + renewSubsription + "]";
	}
	
}
