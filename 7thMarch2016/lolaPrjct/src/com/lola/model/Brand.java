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
@Table(name = "tbl_brandmaster")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="brand", include="all")
public class Brand implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "brandid")
	private int brandId;  	
	
	

	@Column(name="brandname")
	private String brandName;
	
	@Column(name="categoryid")
	private int categoryid;
	
	@Column(name="logoimage")
	private String logoimage;
	
	@Column(name="imagepath")
	private String imagepath;
	
	@Column(name="descp")
	private String descp;
	
	@Column(name="aboutus")
	private String aboutus;
	
	@Column(name="colortheme")
	private String colortheme;
	
	@Column(name="createdon")
	private Date createdon;
	
	@Column(name="updatedon")
	private Date updatedon;
	
	@Column(name="createdby")
	private int createdby;
	
	@Column(name="updatedby")
	private int updatedby;
	
	@Column(name="isactive")
	private boolean isactive;
	
	

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getLogoimage() {
		return logoimage;
	}

	public void setLogoimage(String logoimage) {
		this.logoimage = logoimage;
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

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public String getAboutus() {
		return aboutus;
	}

	public void setAboutus(String aboutus) {
		this.aboutus = aboutus;
	}

	public String getColortheme() {
		return colortheme;
	}

	public void setColortheme(String colortheme) {
		this.colortheme = colortheme;
	}


	
}
