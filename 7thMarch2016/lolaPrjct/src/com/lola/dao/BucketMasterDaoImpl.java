package com.lola.dao;

import java.util.List;

import com.lola.model.Brand;
import com.lola.model.BucketMaster;

public class BucketMasterDaoImpl implements BucketMasterDao<BucketMaster, String> {
	
	@Override
	public List<Object[]> getBucketDetails(int brandid) {
		// TODO Auto-generated method stub
		
		BrandBucketDao brandBucket= new BrandBucketDaoImpl();
		String brandbucketids= brandBucket.getBucketidsByBrandid(brandid);
		if(brandbucketids.equals(""))
			brandbucketids="0";
		hibernateUtil.openCurrentSession();
		List<Object[]> bucketmaster=  hibernateUtil.getCurrentSession().createQuery("select bucketname,iconimagepath  from BucketMaster where  bucketId in ("+brandbucketids+")").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return bucketmaster;
	}
public static void main(String args[]){
	BucketMasterDaoImpl bucketMasterDaoImpl =new BucketMasterDaoImpl();
List<Object[]> buckets=	(List<Object[]>) bucketMasterDaoImpl.getBucketDetails(10);
for(Object[] o:buckets){
	System.out.println(o[0].toString()+"       "+o[1].toString());
}
	
}
}


