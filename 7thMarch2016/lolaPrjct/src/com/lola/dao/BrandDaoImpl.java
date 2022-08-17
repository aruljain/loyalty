package com.lola.dao;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.lola.model.Brand;



public class BrandDaoImpl implements BrandDao <Brand, String> {


	
	
	UserBrandDao userbrand= new UserBrandDaoImpl();
	
	/*@Override
	public List<Object[]> getMyBrandsByCategoryId(int userid, int categoryid,int start,int offset) {
		
		
		String brandids = userbrand.getBrandidsByUserId(userid);
		if(brandids.equals(""))
			brandids="0";
		hibernateUtil.openCurrentSession();
		Session session = hibernateUtil.getCurrentSession();
		Criteria criteria = session.createCriteria(Brand.class)
	   .setProjection(Projections.projectionList()
		 .add(Projections.property("brandId"), "brandId")
		 .add(Projections.property("logoimage"), "logoimage")
		 );
		criteria.setFirstResult(start).setMaxResults(offset);
		criteria.add(Restrictions.eq("categoryid",categoryid));
		//List<Object[]> brands = session.createQuery("select brandId,logoimage from Brand where categoryid="+categoryid+" and brandid in ("+brandids+")  and isactive=true LIMIT "+start+","+offset).setCacheable(false).list();
		//List<Object[]> brands = criteria.list();
		List<Object[]> brands = criteria.list();
		hibernateUtil.closeCurrentSession();
		
		return brands;
		
	}*/
	
	@Override
	 public List<Object[]> getMyBrandsByCategoryId(int userid, int categoryid) {
	  
	  
	  String brandids = userbrand.getBrandidsByUserId(userid);
	  if(brandids.equals(""))
	   brandids="0";
	  hibernateUtil.openCurrentSession();
	  List<Object[]> brands = hibernateUtil.getCurrentSession().createQuery("select brandId,logoimage from Brand where categoryid="+categoryid+" and brandid in ("+brandids+")  and isactive=true ").setCacheable(false).list();
	  
	  hibernateUtil.closeCurrentSession();
	  
	  return brands;
	 }
	
	
	@Override
	public List<Object[]> getAllBrandsByCategoryId(int userid, int categoryid,int start,int offset) {
		
		
		String brandids = userbrand.getBrandidsByUserId(userid);
		if(brandids.equals(""))
			brandids="0";
		hibernateUtil.openCurrentSession();
		Session session = hibernateUtil.getCurrentSession();
		Criteria criteria = session.createCriteria(Brand.class)
		.setProjection(Projections.projectionList()
				 .add(Projections.property("brandId"), "brandId")
				 .add(Projections.property("logoimage"), "logoimage"));
		criteria.setFirstResult(start).setMaxResults(offset);
		criteria.add(Restrictions.eq("categoryid",categoryid));
		//List<Object[]> brands =  hibernateUtil.getCurrentSession().createQuery("select brandId,logoimage from Brand where categoryid="+categoryid+" and brandid not in ("+brandids+")  and isactive=true").setCacheable(false).list();
		List<Object[]> brands = criteria.list();
		hibernateUtil.closeCurrentSession();
		
		return brands;
		
	}
	
	public String getTotalBrands()
	{
		hibernateUtil.openCurrentSession();
		List<Object> totalBrands = hibernateUtil.getCurrentSession().createQuery("select count(brandid)-1 from Brand where isactive=true").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
				
		String total = totalBrands.get(0).toString();
		return total;
	}
	
	@Override
	public List<Object[]> getBrandLogo(int brandid) {
		
		hibernateUtil.openCurrentSession();
		List<Object[]> logoimage = hibernateUtil.getCurrentSession().createQuery("select brandName,logoimage,imagepath,descp,aboutus,colortheme from Brand where brandid="+brandid).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
				
		
		return logoimage;
	}
		

	@Override
	public List<Object[]> getBrandDetails() {
		hibernateUtil.openCurrentSession();
		List<Object[]> branddetail = hibernateUtil.getCurrentSession().createQuery("select brandId,brandName from Brand ").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
				
		return branddetail;
	}
	
	
	@Override
	public List<Object[]> getBrandNamesByCategoryId(int categoryid) {
		hibernateUtil.openCurrentSession();
		List<Object[]> branddetail = hibernateUtil.getCurrentSession().createQuery("select brandId,brandName from Brand where categoryid="+categoryid ).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
				
		return branddetail;		
	}
	
	
	
	public int getAllBrandsCountByCategory(int userid, int categoryid)
	{
		int count=0;
		hibernateUtil.openCurrentSession();
		Object totalBrands = hibernateUtil.getCurrentSession().createQuery("select count(brandId) from Brand where brandId not in (select brandid from UserBrand where userid="+userid+" and liked=1) and categoryid="+categoryid).setCacheable(false).uniqueResult();
		hibernateUtil.closeCurrentSession();
		count =Integer.parseInt(totalBrands.toString());
		
		return count;
	}
	
	
 public static void main(String args[]){
	BrandDaoImpl brand = new BrandDaoImpl();
	
	/*List<Object[]> brands=brand.getMyBrandsByCategoryId(3, 2);
	
	
	for(Object[] o:brands){
		System.out.println(o[0].toString()+"       "+o[1].toString());
	}*/
	System.out.println(brand.getAllBrandsCountByCategory(299,2));
	/* int i=0;
	 while(i<brands.size())		 
	 {
		System.out.println(brands.get(i).toString());
		i++;
			 
	 }*/
	/*if(brands.size()>0){
	for(Object i[]:brands){
		
		if(i[0]==null)
		System.out.println("null");	
		else if(brands.size()>0)
		System.out.println(i[0].toString()+" "+i[1].toString());
		else
			System.out.println(brands.size());
	}
	}
	else
		System.out.println(brands.size());
		
	
	
	
	System.out.println(brand.getTotalBrands());
	
	
}

	public static void main(String args[]){
		BrandDaoImpl brand = new BrandDaoImpl();
		List<Object> brandlist=brand.getBrandLogo(50);
		if(brandlist.size()>0)
	System.out.println(brandlist.toString());
		else
			System.out.println("norecords");
		
	

	}

	public static void main(String args[]){
		BrandDaoImpl brand = new BrandDaoImpl();
		List<Object[]> brandlist=brand.getBrandNamesByCategoryId(2);
		if(brandlist.size()>0){
		for(Object[] o:brandlist) {
			System.out.println(o[0].toString()+"    "+o[1].toString());
		}}else
			System.out.println("no data");
	}
*/
	
 }
	
}
