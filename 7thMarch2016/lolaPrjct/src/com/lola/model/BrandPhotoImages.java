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
@Table(name = "tbl_photoimages")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="brandPhotoImages", include="all")
public class BrandPhotoImages {

				private static final long serialVersionUID = 1L;
					
				@Id
				@GeneratedValue
				@Column(name = "photoid")
				private int photoid;
				
				@Column(name = "brandid")
				private int brandId;  	
				
				@Column(name = "categoryid")
				private int categoryId;
				
				@Column(name="affinitycategories")
				private String affinityCategories;
				
				@Column(name="descphotoparent")
				private String descPhotoParent;
				
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
				
				
					public int getPhotoid() {
					return photoid;
				}
				
				public void setPhotoid(int photoid) {
					this.photoid = photoid;
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
				
				public String getAffinityCategories() {
					return affinityCategories;
				}

				public void setAffinityCategories(String affinityCategories) {
					this.affinityCategories = affinityCategories;
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
				
					
	
}
