package com.lola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_specials_count")
public class SpecialCount {
	
	@Column(name="myspecialchildid")
	private int myspecialchildid;
	
	public int getMyspecialchildid() {
		return myspecialchildid;
	}

	public void setMyspecialchildid(int myspecialchildid) {
		this.myspecialchildid = myspecialchildid;
	}

	public int getBrandspecialid() {
		return brandspecialid;
	}

	public void setBrandspecialid(int brandspecialid) {
		this.brandspecialid = brandspecialid;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	public String getSpecialmsg() {
		return specialmsg;
	}

	public void setSpecialmsg(String specialmsg) {
		this.specialmsg = specialmsg;
	}

	public String getSpecialdesc() {
		return specialdesc;
	}

	public void setSpecialdesc(String specialdesc) {
		this.specialdesc = specialdesc;
	}

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public String getChildimagepath() {
		return childimagepath;
	}

	public void setChildimagepath(String childimagepath) {
		this.childimagepath = childimagepath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="brandspecialid")
	private int brandspecialid;
	
	@Column(name="createdon")
	private String createdon;
	
	@Column(name="specialmsg")
	private String specialmsg;
	
	@Column(name="specialdesc")
	private String specialdesc;
	
	@Column(name="brandid")
	private int brandid;
	
	@Column(name="childimagepath")
	private String childimagepath;
	
	@Column(name="content")
	private String content;

}
