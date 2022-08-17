package com.lola.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tbl_newarrivals")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="brandNewArrivals", include="all")
public class BrandNewArrivals {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "newarrivalid")
	private int newarrivalId;
	
	

	@Column(name = "brandid")
	private int brandId;  	
	

	
	@Column(name = "categoryid")
	private int categoryId;
	
	
	@Column(name="newarrivalmsg")
	private String newarrivalmsg;

	@Column(name="newdesc")
	private String newarrivaldesc;

	@Column(name="arrivalimage")
	private String arrivalImage;
	
	@Column(name="content")
	private String content;
	
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
	
	
	
	public int getNewarrivalId() {
		return newarrivalId;
	}

	public void setNewarrivalId(int newarrivalId) {
		this.newarrivalId = newarrivalId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getNewarrivalmsg() {
		return newarrivalmsg;
	}

	public void setNewarrivalmsg(String newarrivalmsg) {
		this.newarrivalmsg = newarrivalmsg;
	}

	public String getNewarrivaldesc() {
		return newarrivaldesc;
	}

	public void setNewarrivaldesc(String newarrivaldesc) {
		this.newarrivaldesc = newarrivaldesc;
	}

	public String getArrivalImage() {
		return arrivalImage;
	}

	public void setArrivalImage(String arrivalImage) {
		this.arrivalImage = arrivalImage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isBookable() {
		return bookable;
	}

	public void setBookable(boolean bookable) {
		this.bookable = bookable;
	}


}
