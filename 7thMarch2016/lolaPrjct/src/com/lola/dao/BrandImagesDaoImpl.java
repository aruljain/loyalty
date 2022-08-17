package com.lola.dao;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;



import com.lola.model.BrandImages;

public class BrandImagesDaoImpl implements BrandImagesDao <BrandImages,String> {
	
	
	public BrandImagesDaoImpl(){
		
	}

	@Override
	public List<BrandImages> findByCategoryIdWithLimit(int categoryId, int start,
			int offset) {
		// TODO Auto-generated method stub
		hibernateUtil.openCurrentSession();
		Session session = hibernateUtil.getCurrentSession();
		Criteria criteria = session.createCriteria(BrandImages.class);
		criteria.setFirstResult(start).setMaxResults(offset);
		criteria.add(Restrictions.eq("categoryId",categoryId));
		List<BrandImages> brandimages = (List<BrandImages>) criteria.list();
		hibernateUtil.closeCurrentSession();

		
		return brandimages;
	}
	
	/*@Override
	public List<Object[]> findByCategoryIdWithLimit1(int categoryId, int start,
			int offset) {
		// TODO Auto-generated method stub
				
		List<Object[]> brandimages =  hibernateUtil.getCurrentSession().createQuery("select brandid,imagepath,max(createdon) from BrandImages where categoryId="+categoryId).setCacheable(false).list();

		
		return brandimages;
	}*/
	
	public static void main(String args[])
	{
		
		BrandImagesDaoImpl brandImagesDaoImpl = new BrandImagesDaoImpl();
		//hibernateUtil.openCurrentSession();
		List<BrandImages> images = brandImagesDaoImpl.findByCategoryIdWithLimit(2, 0, 5);
		
		for(BrandImages i : images)
		{
			System.out.println(i.getBrandid()+"  "+i.getImagepath()+"    "+i.getDesc());
		}
		//hibernateUtil.closeCurrentSession();
	}

}
