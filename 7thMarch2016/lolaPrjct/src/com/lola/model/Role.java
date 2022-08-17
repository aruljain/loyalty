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
@Table(name = "tbl_role")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="role", include="all")
public class Role {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "roleid")
	private int roleid;  

	@Column(name = "rolename")
	private String roleName;    

	@Column(name = "desc")
	private String desc;

	@Column(name="createdon")
	private Date createdon;

	@Column(name="updatedon")
	private Date updatedon;

	@Column(name="createdby")
	private int createdby;
	
	@Column(name="updatedby")
	private int updatedby;
	
	@Column(name = "isActive")
	private boolean isActive;
	
	
	
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
