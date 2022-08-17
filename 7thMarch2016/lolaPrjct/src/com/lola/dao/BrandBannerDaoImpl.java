package com.lola.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.lola.model.BrandBanner;

public class BrandBannerDaoImpl implements BrandBannerDao <BrandBanner,String> {

			public BrandBannerDaoImpl(){
					
				}

			@Override
			public List<Object[]> getBrandBanner(int brandid) {
				// TODO Auto-generated method stub
				 hibernateUtil.openCurrentSession();
				 //List<Object[]> brandbanner = hibernateUtil.getCurrentSession().createQuery("select brandid,bannerimagePath from BrandBanner where brandid="+brandid+" and createdon >= CURDATE() and isactive=true ORDER BY createdon DESC").setCacheable(false).list();
				 List<Object[]> brandbanner = hibernateUtil.getCurrentSession().createQuery("select brandid,bannerimagePath from BrandBanner where brandid="+brandid+" and isactive=true ORDER BY createdon DESC").setCacheable(false).list();
				hibernateUtil.closeCurrentSession();
				return brandbanner;
			}
	

			
			public static void main(String args[])
			{
				
				BrandBannerDaoImpl brandBannerDaoImpl = new BrandBannerDaoImpl();
				
				List<Object[]> images = brandBannerDaoImpl.getBrandBanner(2);
				int size=images.size();
				if(size>0)
				{
				for(Object[] i:images)
				{
					
					System.out.println(i[0].toString()+"    "+ i[1].toString());					
					break;
				}
				}
				
			}
}
