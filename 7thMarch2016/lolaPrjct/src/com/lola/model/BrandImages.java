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
@Table(name = "tbl_brandproductimages")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="brandImages", include="all")
public class BrandImages implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "brandimageid")
	private int brandimageid; 
	
	@Column(name="brandid")
	private int brandid;
	
	@Column(name="categoryid")
	private int categoryId;
	
	@Column(name="imagepath")
	private String imagepath;
	
	@Column(name="desc")
	private String desc;
	

	@Column(name="createdby")
	private int createdby;
	
	@Column(name="createdon")
	private Date createdon;
	
	@Column(name="updatedby")
	private int updatedby;
	
	@Column(name="updatedon")
	private Date updatedon;
    
	@Column(name="isactive")
	private boolean isactive;


	
	public int getBrandimageid() {
		return brandimageid;
	}

	public void setBrandimageid(int brandimageid) {
		this.brandimageid = brandimageid;
	}

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryid(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public int getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(Date updatedon) {
		this.updatedon = updatedon;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	

}
