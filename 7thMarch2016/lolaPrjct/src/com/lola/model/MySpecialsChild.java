package com.lola.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tbl_myspecialchild")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "mySpecialsChild", include = "all")
public class MySpecialsChild {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "myspecialchildid")
	private int myspecialchildId;

	@Column(name = "brandspecialid")
	private int brandspecialid;

	@Column(name = "brandid")
	private int brandId;

	
	
	@Column(name = "specialdesc")
	private String specialDesc;	

	@Column(name = "childimagepath")
	private String childimagepath;

	@Column(name = "content")
	private String content;

	@Column(name = "createdby")
	private int createdby;

	@Column(name = "createdon")
	private Date createdon;

	@Column(name = "updatedby")
	private int updatedby;

	@Column(name = "updatedon")
	private Date updatedon;

	@Column(name = "isactive")
	private boolean isactive;
	
	
	@Column(name = "available")
	private boolean available;
	
	@Column(name = "bookable")
	private boolean bookable;
	
	@Column(name = "brandshopid")
	private int brandshopid;
	
	public String getSpecialDesc() {
		return specialDesc;
	}

	public void setSpecialDesc(String specialDesc) {
		this.specialDesc = specialDesc;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getMyspecialchildId() {
		return myspecialchildId;
	}

	public void setMyspecialchildId(int myspecialchildId) {
		this.myspecialchildId = myspecialchildId;
	}

	public int getBrandspecialid() {
		return brandspecialid;
	}

	public void setBrandspecialid(int brandspecialid) {
		this.brandspecialid = brandspecialid;
	}

	public String getChildimagepath() {
		return childimagepath;
	}

	public void setChildimagepath(String childimagepath) {
		this.childimagepath = childimagepath;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isBookable() {
		return bookable;
	}

	public void setBookable(boolean bookable) {
		this.bookable = bookable;
	}

	public int getBrandshopid() {
		return brandshopid;
	}

	public void setBrandshopid(int brandshopid) {
		this.brandshopid = brandshopid;
	}



}
