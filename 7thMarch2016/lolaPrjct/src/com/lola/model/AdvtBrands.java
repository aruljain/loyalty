package com.lola.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tbl_adbrands")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="advtBrands", include="all")
public class AdvtBrands implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "adbrandid")
	private int adbrandid;  
	
	@Column(name="brandname")
	private String brandName;
	
	@Column(name="brandid")
	private int brandid;
	
	@Column(name="imagepath")
	private String imagepath;
	
	@Column(name="priority")
	private int priority;
	
	@Column(name="createdby")
	private int createdby;
	
	@Column(name="updatedby")
	private int updatedby;

	
	@Column(name="createdon")
	private Date createdon;
	
	@Column(name="updatedon")
	private Date updatedon;

	
	public int getAdbrandid() {
		return adbrandid;
	}

	public void setAdbrandid(int adbrandid) {
		this.adbrandid = adbrandid;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public int getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public Date getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(Date updatedon) {
		this.updatedon = updatedon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
