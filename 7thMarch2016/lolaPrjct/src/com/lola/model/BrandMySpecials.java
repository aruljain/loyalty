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
@Table(name = "tbl_brandspecials")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="brandMySpecials", include="all")
public class BrandMySpecials {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "brandspecialid")
	private int brandspecialId;
	
	/*@Column(name="dealsandofferid")
	private int dealsandofferId;*/
	
	@Column(name = "brandid")
	private int brandId;  	
	
	@Column(name = "categoryid")
	private int categoryId;
	
	@Column(name="specialmsg")
	private String specialmsg;
	
	@Column(name="specialdesc")
	private String specialdesc;

	@Column(name="image")
	private String image;
	
	@Temporal(TemporalType.DATE)
	 private Date effectivedate;
	
	@Temporal(TemporalType.DATE)
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
	
	public int getBrandspecialId() {
		return brandspecialId;
	}

	public void setBrandspecialId(int brandspecialId) {
		this.brandspecialId = brandspecialId;
	}

	/*public int getDealsandofferId() {
		return dealsandofferId;
	}

	public void setDealsandofferId(int dealsandofferId) {
		this.dealsandofferId = dealsandofferId;
	}*/

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getSpecialmsg() {
		return specialmsg;
	}

	public void setSpecialmsg(String specialmsg) {
		this.specialmsg = specialmsg;
	}

	public String getSpecialdesc() {
		return specialdesc;
	}

	public void setSpecialdesc(String specialdesc) {
		this.specialdesc = specialdesc;
	}

	
}
