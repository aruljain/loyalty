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
@Table(name = "tbl_brandimage")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="brandImageData", include="all")
public class BrandImageData {

	
				private static final long serialVersionUID = 1L;
				
				@Id
				@GeneratedValue
				@Column(name = "brandimageid")
				private int brandimageId;  	
				
				@Column(name = "brandid")
				private int brandId;  
				
				@Column(name="brandname")
				private String brandName;
				
				@Column(name="categoryid")
				private int categoryid;
				
				@Column(name="brandimage")
				private String brandimage;
				
				@Column(name="branddesc")
				private String brandDesc;				

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
				
				
				public String getBrandDesc() {
					return brandDesc;
				}

				public void setBrandDesc(String brandDesc) {
					this.brandDesc = brandDesc;
				}
					
					public int getBrandimageId() {
					return brandimageId;
				}
				
				public void setBrandimageId(int brandimageId) {
					this.brandimageId = brandimageId;
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
				
				public String getBrandimage() {
					return brandimage;
				}
				
				public void setBrandimage(String brandimage) {
					this.brandimage = brandimage;
				}
				
				
				
				public String getColortheme() {
					return colortheme;
				}
				
				public void setColortheme(String colortheme) {
					this.colortheme = colortheme;
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

				public int getBrandId() {
					return brandId;
				}

				public void setBrandId(int brandId) {
					this.brandId = brandId;
				}

	
	
}
