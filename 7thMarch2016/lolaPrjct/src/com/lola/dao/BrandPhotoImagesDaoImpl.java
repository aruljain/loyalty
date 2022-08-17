package com.lola.dao;

import java.util.List;

import com.lola.model.BrandChildPhotoImages;
import com.lola.model.BrandDealsandOffers;
import com.lola.model.BrandPhotoImages;

public class BrandPhotoImagesDaoImpl implements BrandPhotoImagesDao <BrandPhotoImages,String> {

	
	public BrandPhotoImagesDaoImpl(){
		
	}
	
	@Override
	public List<Object[]> getLikedAffinityCategoriesbyBrandId(int brandId,int userId)
	 {
		BrandPhotoImagesDao brandPhotoImages= new BrandPhotoImagesDaoImpl();
		// String brandids = brandNewArrivals.getNewArrivalsbyBrandId(brandId);
			/*if(brandids.equals(""))
				brandids="0";*/
		//SELECT p.affinityCategories,p.photoid,c.imagepath FROM tbl_photoimages p, tbl_childphotoimages c WHERE p.photoid=c.photoid AND p.brandid=3
		/*
		 * My Specials
		 * SELECT p.brandspecialid,p.image,c.childimagepath FROM tbl_brandspecials p, tbl_myspecialchild c WHERE p.brandspecialid=c.brandspecialid AND p.brandid=2
		 */
		//Join query used below
		 hibernateUtil.openCurrentSession();
		 //                                                           createQuery("select distinct(c.myspecialchildId), c.brandId,c.childimagepath, c.content, c.specialDesc, cc.liked FROM MySpecialsChild c, MySpecialLeafPage cc where c.brandId ="+brandid+" and c.myspecialchildId not in (select myspecialchildId from MySpecialLeafPage where userid="+userId+" and liked=1) and cc.liked=0").setCacheable(false).list();
		 List<Object[]> brandname = hibernateUtil.getCurrentSession().createQuery("select p.affinityCategories,p.photoid,c.photoId,c.imagepath,c.content,c.childphotoimageId,c.photoDesc,gc.liked from BrandPhotoImages p, BrandChildPhotoImages c, PhotoimageLeafPage gc  where p.photoid=c.photoId AND p.brandId="+brandId+" and c.childphotoimageId in (select childphotoimageid from PhotoimageLeafPage where userId="+userId+" and liked=1) and gc.liked=1").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandname;
	 }
	
	@Override
	public List<Object[]> getAffinityCategoriesbyBrandId(int brandId,int userId)
	 {
		BrandPhotoImagesDao brandPhotoImages= new BrandPhotoImagesDaoImpl();
		// String brandids = brandNewArrivals.getNewArrivalsbyBrandId(brandId);
			/*if(brandids.equals(""))
				brandids="0";*/
		//SELECT p.affinityCategories,p.photoid,c.imagepath FROM tbl_photoimages p, tbl_childphotoimages c WHERE p.photoid=c.photoid AND p.brandid=3
		/*
		 * My Specials
		 * SELECT p.brandspecialid,p.image,c.childimagepath FROM tbl_brandspecials p, tbl_myspecialchild c WHERE p.brandspecialid=c.brandspecialid AND p.brandid=2
		 */
		//Join query used below
		 hibernateUtil.openCurrentSession();
		 //                                                           createQuery("select distinct(c.myspecialchildId), c.brandId,c.childimagepath, c.content, c.specialDesc, cc.liked FROM MySpecialsChild c, MySpecialLeafPage cc where c.brandId ="+brandid+" and c.myspecialchildId not in (select myspecialchildId from MySpecialLeafPage where userid="+userId+" and liked=1) and cc.liked=0").setCacheable(false).list();
		 List<Object[]> brandname = hibernateUtil.getCurrentSession().createQuery("select p.affinityCategories,p.photoid,c.photoId,c.imagepath,c.content,c.childphotoimageId,c.photoDesc,gc.liked from BrandPhotoImages p, BrandChildPhotoImages c, PhotoimageLeafPage gc  where p.photoid=c.photoId AND p.brandId="+brandId+" and c.childphotoimageId not in (select childphotoimageid from PhotoimageLeafPage where userId="+userId+" and liked=1) and gc.liked=0").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandname;
	 }
	
	public List<BrandChildPhotoImages> findAllPhotoImages(String searchString)
	{
		if(searchString==null)
			searchString="";
		 hibernateUtil.openCurrentSession();		
		 List<BrandChildPhotoImages> brandPhotoImages = hibernateUtil.getCurrentSession().createQuery("from BrandChildPhotoImages  where content like '%"+searchString+"%' or photoDesc like '%"+searchString+"%'").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandPhotoImages;
	}
	
	public static void main(String args[]) throws Exception
	{
		
		BrandPhotoImagesDaoImpl brandPhotoImagesDaoImpl = new BrandPhotoImagesDaoImpl();
		//hibernateUtil.openCurrentSession();
		List<Object[]> images = brandPhotoImagesDaoImpl.getLikedAffinityCategoriesbyBrandId(2,1);
		if(images.size()>0){
		for(Object[] i : images)
		{
			
			System.out.println(i[0].toString()+"    "+i[5].toString()+"   "+i[7].toString());//+"   "+i.getNewarrivalId()+"   "+i.getArrivalImage()+"    "+i.getNewarrivaldesc()+"   "+i.getContent());
		}
		}
		else
			System.out.println("No records");
		//hibernateUtil.closeCurrentSession();
		//System.out.println(brandPhotoImagesDaoImpl.getaffinityCategoriesbyBrandId(3));
	}

	
}
