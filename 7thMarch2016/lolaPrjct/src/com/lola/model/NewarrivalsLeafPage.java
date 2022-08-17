package com.lola.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_newarrivalsleafpage")

public class NewarrivalsLeafPage {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name = "newarrivalsleafpageid")
	private int newarrivalsleafpageId;  
	
	public int getNewarrivalsleafpageId() {
		return newarrivalsleafpageId;
	}

	public void setNewarrivalsleafpageId(int newarrivalsleafpageId) {
		this.newarrivalsleafpageId = newarrivalsleafpageId;
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

	public int getNewarrivalId() {
		return newarrivalId;
	}

	public void setNewarrivalId(int newarrivalId) {
		this.newarrivalId = newarrivalId;
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
	@Column(name = "userid")
	private int userId;
	
	
	@Column(name="liked")
	private boolean liked;
	
	@Column(name="book")
	private boolean book;
	
	

	@Column(name="newarrivalid")
	private int newarrivalId;
	
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


	

}
