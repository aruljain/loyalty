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
@Table(name="tbl_userbrand_loyaltyprogram_points")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="userBrandloyalityPoints", include="all")
public class UserBrandloyalityPoints implements Serializable{
	
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		@Column(name = "loyaltyprogramid")
		private int loyaltyprogramid;

		private int createdby;

		@Temporal(TemporalType.DATE)
		private Date createdon;

		private int earnedpoints;

		private String earnedrefno;

		private int expiringpoint;

		@Temporal(TemporalType.DATE)
		private Date expirydate;

		private int redeemdpoint;

		private String redeemdrefno;

		@Temporal(TemporalType.TIMESTAMP)
		private Date transactiondate;

		private int updatedby;

		@Temporal(TemporalType.DATE)
		private Date updatedon;

		public int getLoyaltyprogramid() {
			return loyaltyprogramid;
		}

		public void setLoyaltyprogramid(int loyaltyprogramid) {
			this.loyaltyprogramid = loyaltyprogramid;
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

		public int getEarnedpoints() {
			return earnedpoints;
		}

		public void setEarnedpoints(int earnedpoints) {
			this.earnedpoints = earnedpoints;
		}

		public String getEarnedrefno() {
			return earnedrefno;
		}

		public void setEarnedrefno(String earnedrefno) {
			this.earnedrefno = earnedrefno;
		}

		public int getExpiringpoint() {
			return expiringpoint;
		}

		public void setExpiringpoint(int expiringpoint) {
			this.expiringpoint = expiringpoint;
		}

		public Date getExpirydate() {
			return expirydate;
		}

		public void setExpirydate(Date expirydate) {
			this.expirydate = expirydate;
		}

		public int getRedeemdpoint() {
			return redeemdpoint;
		}

		public void setRedeemdpoint(int redeemdpoint) {
			this.redeemdpoint = redeemdpoint;
		}

		public String getRedeemdrefno() {
			return redeemdrefno;
		}

		public void setRedeemdrefno(String redeemdrefno) {
			this.redeemdrefno = redeemdrefno;
		}

		public Date getTransactiondate() {
			return transactiondate;
		}

		public void setTransactiondate(Date transactiondate) {
			this.transactiondate = transactiondate;
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

	
}

