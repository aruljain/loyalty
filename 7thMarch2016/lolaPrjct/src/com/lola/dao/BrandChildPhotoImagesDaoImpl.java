package com.lola.dao;

import java.util.List;

import com.lola.model.BrandChildPhotoImages;
import com.lola.model.BrandDealsandOffers;

public class BrandChildPhotoImagesDaoImpl implements BrandChildPhotoImagesDao <BrandChildPhotoImages,String>{

	public BrandChildPhotoImagesDaoImpl(){
		
	}
	
	
	@Override
	public List<Object> getimagepathbyBrandId(int brandid, int photoid)
	 {
		//BrandPhotoImagesDao brandPhotoImages= new BrandPhotoImagesDaoImpl();
		
		// String brandids = brandNewArrivals.getNewArrivalsbyBrandId(brandId);
			/*if(brandids.equals(""))
				brandids="0";*/
		 hibernateUtil.openCurrentSession();
		 List<Object> brandname = hibernateUtil.getCurrentSession().createQuery("select imagepath from BrandChildPhotoImages where brandId="+brandid+" and photoid="+photoid).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandname;
	 }
	

	@Override
	public void persist(BrandChildPhotoImages entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();
		
		
	}


	@Override
	public void update(BrandChildPhotoImages entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
		
	}


	@Override
	public List<BrandChildPhotoImages> findBychildphotoimageId(int childphotoimageId) {
		hibernateUtil.openCurrentSession();
		List<BrandChildPhotoImages> brandChildPhotoImages = (List<BrandChildPhotoImages>) hibernateUtil.getCurrentSession().createQuery("from BrandChildPhotoImages where childphotoimageId='"+childphotoimageId+"'").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		return brandChildPhotoImages;
	}

	
	public static void main(String args[]) throws Exception
	{
		
		BrandChildPhotoImagesDaoImpl brandChildPhotoImagesDaoImpl = new BrandChildPhotoImagesDaoImpl();
		
		//System.out.println(brandChildPhotoImagesDaoImpl.getimagepathbyBrandId(3,3));
		List<BrandChildPhotoImages> brandChildPhotoImages =brandChildPhotoImagesDaoImpl.findBychildphotoimageId(1);
		for(BrandChildPhotoImages o:brandChildPhotoImages){
			System.out.println(o.getContent()+"   "+o.getImagepath());
		}
		
	}


}
