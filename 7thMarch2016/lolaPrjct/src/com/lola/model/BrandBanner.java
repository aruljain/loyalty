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
@Table(name = "tbl_banner")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="brandBanner", include="all")
public class BrandBanner {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "bannerid")
	private int bannerId;  
	
	@Column(name = "brandid")
	private int brandid;  	
	
	@Column(name="bannername")
	private String bannerName;
	
	@Column(name="bannerimagepath")
	private String bannerimagePath;
	
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
	
	public int getBannerId() {
		return bannerId;
	}

	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}

	public int getBrandId() {
		return brandid;
	}

	public void setBrandId(int brandId) {
		this.brandid = brandId;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getBannerImagePath() {
		return bannerimagePath;
	}

	public void setBannerImagePath(String bannerImagePath) {
		this.bannerimagePath = bannerImagePath;
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

	
	
	
}
