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
@Table(name = "tbl_ratereview")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rateandReview", include="all")
public class RateandReview {

				private static final long serialVersionUID = 1L;
				
				@Id
				@GeneratedValue
				@Column(name = "ratereviewid")
				private int ratereviewid;
				
				@Column(name = "userid")
				private int userId; 
				
				@Column(name = "brandid")
				private int brandId;  	
				
				@Column(name = "productid")
				private int productId;
				
				@Column(name="rate")
				private String rate;
				
				@Column(name="review")
				private String review;
				
				@Column(name="lolacontact")
				private String lolaContact;
				
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
				
				@Column(name="feedback")
				private String feedback;
				
				@Column(name="brandnothere")
				private String brandnothere;				
			

				@Column(name="categorynothere")
				private String categorynothere;
					
					public String getFeedback() {
					return feedback;
				}

				public void setFeedback(String feedback) {
					this.feedback = feedback;
				}

					public int getRatereviewid() {
					return ratereviewid;
				}
				
				public void setRatereviewid(int ratereviewid) {
					this.ratereviewid = ratereviewid;
				}
				
				public int getUserId() {
					return userId;
				}
				
				public void setUserId(int userId) {
					this.userId = userId;
				}
				
				public int getBrandId() {
					return brandId;
				}
				
				public void setBrandId(int brandId) {
					this.brandId = brandId;
				}
				
				public int getProductId() {
					return productId;
				}
				
				public void setProductId(int productId) {
					this.productId = productId;
				}
				
				public String getRate() {
					return rate;
				}
				
				public void setRate(String rate) {
					this.rate = rate;
				}
				
				public String getReview() {
					return review;
				}
				
				public void setReview(String review) {
					this.review = review;
				}
				
				public String getLolaContact() {
					return lolaContact;
				}
				
				public void setLolaContact(String lolaContact) {
					this.lolaContact = lolaContact;
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
				
				public String getBrandnothere() {
					return brandnothere;
				}

				public void setBrandnothere(String brandnothere) {
					this.brandnothere = brandnothere;
				}

				public String getCategorynothere() {
					return categorynothere;
				}

				public void setCategorynothere(String categorynothere) {
					this.categorynothere = categorynothere;
				}	
	
	
}
