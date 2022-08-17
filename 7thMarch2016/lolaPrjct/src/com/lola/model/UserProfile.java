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
@Table(name = "tbl_userprofile")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="userProfile", include="all")
public class UserProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "profileid")
	private int profileid;

	

	@Column(name = "userid")
	private int userid;

	@Column(name = "createdby")
	private int createdby;

	@Column(name = "createdon")
	private Date createdon;

	@Column(name = "dob")
	private String dob;
	
	@Column(name = "dealnoffer")
	private boolean dealnoffer;
	
	@Column(name = "gender")
	private String gender;

	@Column(name = "salutation")
	private String salutation;
	
	@Column(name = "baselocation")
	private String baseLocation;


	
	@Column(name = "mycities")
	private String mycities;

	@Column(name = "isactive")
	private boolean isactive;

	@Column(name = "maritalstatus")
	private boolean maritalstatus;

	@Column(name = "profilepic")
	private String profilepic;

	@Column(name = "updatedby")
	private int updatedby;

	@Column(name = "updatedon")
	private Date updatedon;

	@Column(name = "veg")
	private boolean veg;

	@Column(name = "weddinganv")
	private String weddinganv;

	public int getProfileid() {
		return profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMycities() {
		return mycities;
	}

	public void setMycities(String mycities) {
		this.mycities = mycities;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public boolean isMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(boolean maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
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

	public boolean isVeg() {
		return veg;
	}

	public void setVeg(boolean veg) {
		this.veg = veg;
	}

	public String getWeddinganv() {
		return weddinganv;
	}

	public void setWeddinganv(String weddinganv) {
		this.weddinganv = weddinganv;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	
	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	
	public boolean isDealnoffer() {
		return dealnoffer;
	}

	public void setDealnoffer(boolean dealnoffer) {
		this.dealnoffer = dealnoffer;
	}

}
