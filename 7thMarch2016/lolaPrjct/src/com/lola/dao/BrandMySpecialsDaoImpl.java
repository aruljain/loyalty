package com.lola.dao;

import java.util.List;

import com.lola.model.BrandMySpecials;
import com.lola.model.MySpecialsChild;
import com.lola.model.OnSale;

public class BrandMySpecialsDaoImpl implements BrandMySpecialsDao <BrandMySpecials,String> {

			public BrandMySpecialsDaoImpl(){
		
				}

			public List<Object> getMySpecialsbyUserId(int userid)
			 {
				 UserBrandDao userbrand= new UserBrandDaoImpl();
				 String brandids = userbrand.getBrandidsByUserId(userid);
					if(brandids.equals(""))
						brandids="0";
				 hibernateUtil.openCurrentSession();
				 List<Object> brandCount = hibernateUtil.getCurrentSession().createQuery("select count(brandid) from BrandMySpecials where brandid in("+brandids+")").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();		
				 
				 return brandCount;
			 }	
			
			public List<Object[]> getMySpecials(int userid,int categoryId)
			 {
				 UserBrandDao userbrand= new UserBrandDaoImpl();
				 String brandids = userbrand.getBrandidsByUserId(userid);
					if(brandids.equals(""))
						brandids="0";
				 hibernateUtil.openCurrentSession();
				 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandId,image from BrandMySpecials where categoryid="+categoryId+" and brandId in("+brandids+")").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();		
				 
				 return brandCount;
			 }
			
			public List<Object[]> getMySpecialsByCategoryId(int userid,int categoryId)
			 {
				 UserBrandDao userbrand= new UserBrandDaoImpl();
				 String brandids = userbrand.getBrandidsByUserId(userid);
					if(brandids.equals(""))
						brandids="0";
				 hibernateUtil.openCurrentSession();
				 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("SELECT p.image,p.brandId,p.specialdesc,p.brandspecialId,c.brandspecialid,c.childimagepath FROM BrandMySpecials p, MySpecialsChild c  WHERE p.brandspecialId=c.brandspecialid AND p.categoryId="+categoryId+"  and p.brandId in("+brandids+")").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();		
				 
				 return brandCount;
			 }
			
			
			public List<Object[]> getMySpecialsChildByCategoryId(int userid,int categoryId)
			 {
				 UserBrandDao userbrand= new UserBrandDaoImpl();
				 String brandids = userbrand.getBrandidsByUserId(userid);
					if(brandids.equals(""))
						brandids="0";
				 hibernateUtil.openCurrentSession();
				 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("SELECT c.brandId, c.myspecialchildId,c.childimagepath, c.content,c.specialDesc FROM BrandMySpecials p, MySpecialsChild c  WHERE p.brandspecialId=c.brandspecialid AND p.categoryId="+categoryId+"  and p.brandId in("+brandids+")").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();		
				 
				 return brandCount;
			 }
			
		/*	@Override
			public List<Object[]> getMySpecialsbyBrandId(int brandId)
			 {
				BrandMySpecialsDao brandMySpecialsDaoImpl= new BrandMySpecialsDaoImpl();
				// String brandids = brandNewArrivals.getNewArrivalsbyBrandId(brandId);
					if(brandids.equals(""))
						brandids="0";
				 hibernateUtil.openCurrentSession();
				 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandId, image from BrandMySpecials where brandid in("+brandId+")").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();		
				 
				 return brandCount;
			 }
*/			
			
			@Override
			public List<Object[]> getMySpecialsChildbyBrandId(int brandId)
			 {
				
				// String brandids = brandNewArrivals.getNewArrivalsbyBrandId(brandId);
					
				 hibernateUtil.openCurrentSession();
				 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select c.myspecialchildId,c.childimagepath, c.content FROM MySpecialsChild c where brandid ="+brandId).setCacheable(false).list();
				hibernateUtil.closeCurrentSession();		
				 
				 return brandCount;
			 }
			
			public List<MySpecialsChild> findAllMySpecialChild(String searchString)
			{
				if(searchString==null)
					searchString="";
				 hibernateUtil.openCurrentSession();
				 List<MySpecialsChild> mySpecialChild = hibernateUtil.getCurrentSession().createQuery("FROM MySpecialsChild c where specialDesc like '%"+searchString+"%' or content like '%"+searchString+"%'").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();		
				 
				 return mySpecialChild;
			}
			
			
			@Override
			public List<MySpecialsChild> findByMySpecialChildId(int myspecialchildId) {
				hibernateUtil.openCurrentSession();
				List<MySpecialsChild> myspecial = (List<MySpecialsChild>) hibernateUtil.getCurrentSession().createQuery("from MySpecialsChild where myspecialchildId='"+myspecialchildId+"'").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();
				return myspecial;
			}
			
			
			@Override
			public List<MySpecialsChild> findAllAvailableDeatilsOfMySpecial(int brandId) {
				hibernateUtil.openCurrentSession();
				List<MySpecialsChild> myspecial = (List<MySpecialsChild>) hibernateUtil.getCurrentSession().createQuery("from MySpecialsChild where available=1 and brandId='"+brandId+"'").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();
				return myspecial;
			}

			
			public static void main(String args[])
			{
				
				BrandMySpecialsDaoImpl brandMySpecialsDaoImpl = new BrandMySpecialsDaoImpl();
				//hibernateUtil.openCurrentSession();
				List<MySpecialsChild> images = brandMySpecialsDaoImpl.findAllAvailableDeatilsOfMySpecial(2);
				
				if(images.size()>0){
					for(MySpecialsChild i : images)
					{
						System.out.println(i.getBrandId()+"   "+i.getBrandspecialid()+"   "+i.getMyspecialchildId()+"   "+i.getChildimagepath()+"   "+i.getSpecialDesc()+"    "+i.getContent());
					}
					}
					else
						System.out.println("No records");
				
				//hibernateUtil.closeCurrentSession();
			}

			
	
}
