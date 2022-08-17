package com.lola.model;

import java.io.Serializable;
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
@Table(name = "tbl_branddealsandoffers")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="brandDealsandOffers", include="all")
public class BrandDealsandOffers implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "dealandofferid")
	private int dealandofferId;
	
	@Column(name = "brandid")
	private int brandId;  	
	
	
	
	@Column(name="dealdesc")
	private String dealDesc;
	
	@Column(name="categoryid")
	private int categoryid;
	
	@Column(name="offermsg")
	private String offermsg;
	
	@Column(name="offerimage")
	private String offerImage;
	
	@Column(name="content")
	private String content;
	
	//@Temporal(TemporalType.DATE)
	 @Column(name="effectivedate")
	 private Date effectivedate;
	
	//@Temporal(TemporalType.DATE)
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
	
	

	@Column(name="bookable")
	private boolean bookable;
	
	@Column(name="brandshopid")
	private int brandshopid;
	
	
	
	
	public int getDealandofferId() {
		return dealandofferId;
	}

	public void setDealandofferId(int dealandofferId) {
		this.dealandofferId = dealandofferId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getDealDesc() {
		return dealDesc;
	}

	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getOfferImage() {
		return offerImage;
	}

	public void setOfferImage(String offerImage) {
		this.offerImage = offerImage;
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

	public String getOffermsg() {
		return offermsg;
	}

	public void setOffermsg(String offermsg) {
		this.offermsg = offermsg;
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
