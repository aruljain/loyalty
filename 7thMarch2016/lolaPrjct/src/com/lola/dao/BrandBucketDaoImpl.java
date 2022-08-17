package com.lola.dao;

import java.util.List;

import com.lola.model.BrandBucket;
import com.lola.model.UserBrand;

public class BrandBucketDaoImpl implements BrandBucketDao <BrandBucket,String>{

	@Override
	public String getBucketidsByBrandid(int brandid) {
		// TODO Auto-generated method stub
		 String ids = "";
		 StringBuffer strBuff = new StringBuffer();
			
		 hibernateUtil.openCurrentSession();
		 List<Object> brandbucketids = hibernateUtil.getCurrentSession().createQuery("select bucketid from BrandBucket where brandid="+brandid+" and isactive=true").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		 int i=0;
		 while(i<brandbucketids.size())		 
		 {
			strBuff = strBuff.append(brandbucketids.get(i).toString());
			 i++;
			 if(i<brandbucketids.size())
			 strBuff.append(",");		 
		 }
		 
		 ids=strBuff.toString();
		 
		 return ids;
		
	}
	
	public static void main(String args[]){
		BrandBucketDaoImpl brandBucketDaoImpl=new BrandBucketDaoImpl();
	System.out.println(brandBucketDaoImpl.getBucketidsByBrandid(11));	
		
	}
}
