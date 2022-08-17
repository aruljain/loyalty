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
@Table(name = "tbl_bucketmaster")
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="bucketMaster", include="all")
public class BucketMaster implements Serializable {
	

		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue
		@Column(name = "bucketid")
		private int bucketId;  
		
		@Column(name="bucketname")
		private String bucketname;
		
		@Column(name="iconimagepath")
		private String iconimagepath;
		
		@Column(name="desc")
		private String desc;
		
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
		
		
		public int getBucketId() {
			return bucketId;
		}

		public void setBucketId(int bucketId) {
			this.bucketId = bucketId;
		}

		public String getBucketname() {
			return bucketname;
		}

		public void setBucketname(String bucketname) {
			this.bucketname = bucketname;
		}

		public String getIconimagepath() {
			return iconimagepath;
		}

		public void setIconimagepath(String iconimagepath) {
			this.iconimagepath = iconimagepath;
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
