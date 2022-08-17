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
@Table(name = "tbl_newarrivalsnotification")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="newArrivalNoti", include="all")
public class NewArrivalNoti {

	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	
	@Column(name = "newarrivalnotiid")
	private int newarrivalnotiId;
	
	@Column(name = "userid")
	private int userId;  	
	
	@Column(name = "newarrivalid")
	private int newarrivalId;
	
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
	
	public int getNewarrivalnotiId() {
		return newarrivalnotiId;
	}

	public void setNewarrivalnotiId(int newarrivalnotiId) {
		this.newarrivalnotiId = newarrivalnotiId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNewarrivalId() {
		return newarrivalId;
	}

	public void setNewarrivalId(int newarrivalId) {
		this.newarrivalId = newarrivalId;
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
