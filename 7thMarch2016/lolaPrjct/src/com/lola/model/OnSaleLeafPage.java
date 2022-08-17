package com.lola.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_onsaleleafpage")
public class OnSaleLeafPage {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "onsaleleafpageid")
	private int onsaleleafpageId;  
	
	@Column(name = "userid")
	private int userId;  
	
	@Column(name="liked")
	private boolean liked;
	

	@Column(name="book")
	private boolean book;
	
	
	@Column(name="onsaleid")
	private int onsaleid;

	@Column(name="createdon")
	private Date createdon;
	
	@Column(name="updatedon")
	private Date updatedon;
	
	@Column(name="createdby")
	private int createdby;
	
	@Column(name="updatedby")
	private int updatedby;
	
	@Column(name="isactive")
	private boolean isactive;
	
	

	public int getOnsaleleafpageId() {
		return onsaleleafpageId;
	}

	public void setOnsaleleafpageId(int onsaleleafpageId) {
		this.onsaleleafpageId = onsaleleafpageId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public int getOnsaleid() {
		return onsaleid;
	}

	public void setOnsaleid(int onsaleid) {
		this.onsaleid = onsaleid;
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

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isBook() {
		return book;
	}

	public void setBook(boolean book) {
		this.book = book;
	}


}
