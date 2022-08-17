package com.lola.dao;

import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;





import com.lola.model.BrandImageData;
import com.lola.model.BrandImages;

public class BrandImagesDataDaoImpl implements BrandImagesDataDao <BrandImages,String> {
	
	UserBrandDao userbrand= new UserBrandDaoImpl();
	
	public BrandImagesDataDaoImpl(){
		
	}

	@Override
	 public List<Object[]> getMyBrandsByCategoryId(int userid, int categoryid) {
	  
	  
	  String brandids = userbrand.getBrandidsByUserId(userid);
	  if(brandids.equals(""))
	   brandids="0";
	  hibernateUtil.openCurrentSession();
	  List<Object[]> brands = hibernateUtil.getCurrentSession().createQuery("select brandId,brandimage,brandName from BrandImageData where categoryid="+categoryid+" and brandId in ("+brandids+")  and isactive=true ").setCacheable(false).list();
	  
	  hibernateUtil.closeCurrentSession();
	  
	  return brands;
	 }
	
	
	/*@Override
	public List<Object[]> getAllBrandsByCategoryId(int userid, int categoryid,int start,int offset) {
		
		
		String brandids = userbrand.getBrandidsByUserId(userid);
		if(brandids.equals(""))
			brandids="0";
		hibernateUtil.openCurrentSession();
		Session session = hibernateUtil.getCurrentSession();
		Criteria criteria = session.createCriteria(BrandImageData.class)
		.setProjection(Projections.projectionList()
				 .add(Projections.property("brandId"), "brandId")
				 .add(Projections.property("brandimage"), "brandimage"));
		criteria.setFirstResult(start).setMaxResults(offset);
		criteria.add(Restrictions.eq("categoryid",categoryid));
		//List<Object[]> brands =  hibernateUtil.getCurrentSession().createQuery("select brandId,logoimage from Brand where categoryid="+categoryid+" and brandid not in ("+brandids+")  and isactive=true").setCacheable(false).list();
		List<Object[]> brands = criteria.list();
		hibernateUtil.closeCurrentSession();
		
		return brands;
		
	}*/
	
	 @Override
		public List<Object[]> getAllBrandsByCategoryId(int userid, int categoryid) {
			
			
			String brandids = userbrand.getBrandidsByUserId(userid);
			if(brandids.equals(""))
				brandids="0";
			hibernateUtil.openCurrentSession();
			
			List<Object[]> brands =  hibernateUtil.getCurrentSession().createQuery("select brandId,brandimage,brandName from BrandImageData where categoryid="+categoryid+" and brandid not in ("+brandids+")  and isactive=true").setCacheable(false).list();
			
			hibernateUtil.closeCurrentSession();
			
			return brands;
			
		}
		
		@SuppressWarnings("unchecked")
		public List<BrandImageData> getAllBrands(int userid, String searchString)
		{
			String brandids = userbrand.getBrandidsByUserId(userid);
			if(brandids.equals(""))
				brandids="0";
			hibernateUtil.openCurrentSession();
			
			List<BrandImageData> brands =  hibernateUtil.getCurrentSession().createQuery("from BrandImageData where categoryid!=1 and brandid not in ("+brandids+")  and isactive=true and brandName like '%"+searchString+"%'").setCacheable(false).list();
			
			hibernateUtil.closeCurrentSession();
			
			return brands;
		}
		
		
		@SuppressWarnings("unchecked")
		public List<BrandImageData> getMyBrands(int userid, String searchString)
		{
			  String brandids = userbrand.getBrandidsByUserId(userid);
			  if(brandids.equals(""))
			   brandids="0";
			  hibernateUtil.openCurrentSession();
			  List<BrandImageData> brands = hibernateUtil.getCurrentSession().createQuery("from BrandImageData where categoryid!=1 and brandId in ("+brandids+")  and isactive=true and brandName like '%"+searchString+"%'").setCacheable(false).list();
			  
			  hibernateUtil.closeCurrentSession();
			  
			  return brands;
		}
		
		
	public static void main(String args[])
	{
		
		BrandImagesDataDaoImpl brandImagesDataDaoImpl = new BrandImagesDataDaoImpl();
		
		List<Object[]> images = brandImagesDataDaoImpl.getAllBrandsByCategoryId(29, 4);
		
		//List<Object[]> images = brandImagesDataDaoImpl.getMyBrandsByCategoryId(29, 3);
		
		for(Object[] i : images)
		{
			System.out.println(i[0]+"  "+i[1]);
		}
		
		/*BrandImagesDataDaoImpl brandImagesDataDaoImpl = new BrandImagesDataDaoImpl();
		System.out.println(brandImagesDataDaoImpl.getMyBrandsByCategoryId(4, 2));*/
	}

}
