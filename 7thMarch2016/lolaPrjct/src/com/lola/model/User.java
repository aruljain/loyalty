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

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name = "tbl_user")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="user", include="all")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "userid")
	private int userId;  			

	
	@Column(name = "roleid")
	private int roleid;  

	@Column(name = "username")
	private String userName;    

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "otp")
	private String otp;
	
	@Column(name = "otpstatus")
	private boolean otpstatus;

	@Column(name = "location")
	private String location;

	@Column(name = "mobile")
	private String mobile;

	@Column(name="createdon")
	private Date createdon;

	@Column(name="updatedon")
	private Date updatedon;

	@Column(name="createdby")
	private int createdby;
	
	@Column(name="updatedby")
	private int updatedby;

	@Column(name="lattitude")
	private String lattitude;

	@Column(name = "longtitude")
	private String longtitude;	
	
	@Column(name = "isActive")
	private boolean isActive;
	
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
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

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	

	public String getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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


	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public boolean isOtpstatus() {
		return otpstatus;
	}

	public void setOtpstatus(boolean otpstatus) {
		this.otpstatus = otpstatus;
	}


}
