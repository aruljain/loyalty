package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.model.BrandShowRoom;

public interface BrandShowRoomDao<T, Id  extends Serializable> extends HibernateUtilDao {

	public List<BrandShowRoom>  getBrandShowroomDetails(int brandId, double latti,double lng,float dist);
	public List<Object[]>  getBrandShowroomDetails(int bucketId);
	public List<Object[]> getLolaContact();
	public List<Object> getBrandShowroomEmailid(int brandId);
	public List<Object[]> getBrandShowroom(int brandId);
	
	public List<BrandShowRoom> getBrandShowroomDetail(int brandId,double lat,double lng);
	
	public List<BrandShowRoom> getBrandShowroomDetail(int brandId,double lat,double lng,String pin);
	
	
}
