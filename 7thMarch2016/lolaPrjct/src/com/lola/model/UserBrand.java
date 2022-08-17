package com.lola.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "tbl_userbrand")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="userBrand", include="all")
public class UserBrand implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name = "userbrandid")
	private int userbrandid; 
	
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="brandid")
	private int brandid;
	
	@Column(name="cummulativepoints")
	private int cummulativepoints;
	
	@Column(name="balancepoints")
	private int balancepoints;
	
	

	@Column(name="createdby")
	private int createdby;
	
	@Column(name="createdon")
	private Date createdon;
	
	@Column(name="updatedby")
	private int updatedby;
	
	@Column(name="updatedon")
	private Date updatedon;
	
	@Column(name="loyaltyprogramid")
	private Date loyaltyprogramid;
	
	@Column(name="currentloyaltylevel")
	private Date currentloyaltylevel;
	
	@Column(name="liked")
	private boolean liked;
	
	
	@Column(name="onoffnoti")
	private boolean onoffnoti;
	
	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public int getUserbrandid() {
		return userbrandid;
	}

	public void setUserbrandid(int userbrandid) {
		this.userbrandid = userbrandid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public int getCummulativepoints() {
		return cummulativepoints;
	}

	public void setCummulativepoints(int cummulativepoints) {
		this.cummulativepoints = cummulativepoints;
	}

	public int getBalancepoints() {
		return balancepoints;
	}

	public void setBalancepoints(int balancepoints) {
		this.balancepoints = balancepoints;
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

	public Date getLoyaltyprogramid() {
		return loyaltyprogramid;
	}

	public void setLoyaltyprogramid(Date loyaltyprogramid) {
		this.loyaltyprogramid = loyaltyprogramid;
	}

	public Date getCurrentloyaltylevel() {
		return currentloyaltylevel;
	}

	public void setCurrentloyaltylevel(Date currentloyaltylevel) {
		this.currentloyaltylevel = currentloyaltylevel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isOnoffnoti() {
		return onoffnoti;
	}

	public void setOnoffnoti(boolean onoffnoti) {
		this.onoffnoti = onoffnoti;
	}
	

}
