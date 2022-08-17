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
@Table(name = "tbl_specianotification")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="specialNoti", include="all")
public class SpecialNoti {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	
	@Column(name = "specialnotiid")
	private int specialnotiId;
	
	@Column(name = "userid")
	private int userId;  	
	
	@Column(name = "myspecialchildid")
	private int myspecialchildId;
	
	

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

	
	public int getSpecialnotiId() {
		return specialnotiId;
	}

	public void setSpecialnotiId(int specialnotiId) {
		this.specialnotiId = specialnotiId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	public int getMyspecialchildId() {
		return myspecialchildId;
	}

	public void setMyspecialchildId(int myspecialchildId) {
		this.myspecialchildId = myspecialchildId;
	}

	}
