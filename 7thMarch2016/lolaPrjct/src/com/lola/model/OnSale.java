package com.lola.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_onsale")
public class OnSale implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "onsaleid")
	private int onsaleId;
	
	
	@Column(name = "brandid")
	private int brandId;  	
	
	@Column(name="onsalemsg")
	private String onsalemsg;
	
	@Column(name="onsaledesc")
	private String onsaledesc;
	
	@Column(name="onsaleimage")
	private String onsaleimage;
	
	@Column(name="content")
	private String content;
	

	@Column(name="categoryid")
	private int categoryid;
	
	@Column(name="effectivedate")
	 private Date effectivedate;
	
	@Column(name="expirydate")
	 private Date expirydate;
	
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

	@Column(name="available")
	private boolean available;
	
	@Column(name="brandshopid")
	private int brandshopid;
	
	@Column(name="bookable")
	private boolean bookable;

	

	public int getOnsaleId() {
		return onsaleId;
	}

	public void setOnsaleId(int onsaleId) {
		this.onsaleId = onsaleId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getOnsalemsg() {
		return onsalemsg;
	}

	public void setOnsalemsg(String onsalemsg) {
		this.onsalemsg = onsalemsg;
	}

	public String getOnsaledesc() {
		return onsaledesc;
	}

	public void setOnsaledesc(String onsaledesc) {
		this.onsaledesc = onsaledesc;
	}

	public String getOnsaleimage() {
		return onsaleimage;
	}

	public void setOnsaleimage(String onsaleimage) {
		this.onsaleimage = onsaleimage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getBrandshopid() {
		return brandshopid;
	}

	public void setBrandshopid(int brandshopid) {
		this.brandshopid = brandshopid;
	}

	public boolean isBookable() {
		return bookable;
	}

	public void setBookable(boolean bookable) {
		this.bookable = bookable;
	}
}
