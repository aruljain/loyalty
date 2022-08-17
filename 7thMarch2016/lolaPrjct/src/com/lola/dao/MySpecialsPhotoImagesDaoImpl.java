package com.lola.dao;

import java.util.List;








import com.lola.model.MySpecialsChild;
import com.lola.model.User;

public class MySpecialsPhotoImagesDaoImpl implements MySpecialsPhotoImagesDao <MySpecialsChild,String>{

	/*@Override
	public List<Object[]> getLikedMySpecialsPhotoImages(int brandid, int userId) {
		
		 * My Specials
		 * SELECT p.brandspecialid,p.image,c.childimagepath FROM tbl_brandspecials p, tbl_myspecialchild c WHERE p.brandspecialid=c.brandspecialid AND p.brandid=2
		 
		//Join query used below
		 hibernateUtil.openCurrentSession();
		 //select p.affinityCategories,p.photoid,c.photoId,c.imagepath from BrandPhotoImages p, BrandChildPhotoImages c  where p.photoid=c.photoId AND p.brandId="+brandId
		 //                                                           createQuery("select distinct(p.newarrivalId), p.brandId, p.arrivalImage, p.content, p.newarrivaldesc, c.liked from BrandNewArrivals p, NewarrivalsLeafPage c where p.brandId="+brandId+" and p.newarrivalId IN (select newarrivalId FROM NewarrivalsLeafPage WHERE userid="+userId+" AND liked=TRUE) and c.liked=1").list();
		 List<Object[]> brandname = hibernateUtil.getCurrentSession().createQuery("select distinct(c.myspecialchildId), c.brandId,c.childimagepath, c.content, c.specialDesc, cc.liked FROM MySpecialsChild c, MySpecialLeafPage cc where c.brandId ="+brandid+" and c.myspecialchildId in (select myspecialchildId from MySpecialLeafPage where userid="+userId+" and liked=TRUE) and cc.liked=1").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandname;
	
	}
	
	
	@Override
	public List<Object[]> getMySpecialsPhotoImages(int brandid, int userId) {
		
		 * My Specials
		 * SELECT p.brandspecialid,p.image,c.childimagepath FROM tbl_brandspecials p, tbl_myspecialchild c WHERE p.brandspecialid=c.brandspecialid AND p.brandid=2
		 
		//Join query used below
		 hibernateUtil.openCurrentSession();
		 //select p.affinityCategories,p.photoid,c.photoId,c.imagepath from BrandPhotoImages p, BrandChildPhotoImages c  where p.photoid=c.photoId AND p.brandId="+brandId
		 //                                                                               distinct(p.newarrivalId), p.brandId, p.arrivalImage, p.content, p.newarrivaldesc, c.liked from BrandNewArrivals p, NewarrivalsLeafPage c where p.brandId="+brandId+" and p.newarrivalId IN (select newarrivalId FROM NewarrivalsLeafPage WHERE userid="+userId+" AND liked=TRUE) and c.liked=1").list()
		 List<Object[]> brandname = hibernateUtil.getCurrentSession().createQuery("select distinct(c.myspecialchildId), c.brandId,c.childimagepath, c.content, c.specialDesc, cc.liked FROM MySpecialsChild c, MySpecialLeafPage cc where c.brandId ="+brandid+" and c.myspecialchildId not in (select myspecialchildId from MySpecialLeafPage where userid="+userId+" and liked=1) and cc.liked=0").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandname;
	
	}*/
	
	@Override
	public List<Object[]> getAllMySpecialsPhotoImages(String  searchString) {
		/*
		 * My Specials
		 * SELECT p.brandspecialid,p.image,c.childimagepath FROM tbl_brandspecials p, tbl_myspecialchild c WHERE p.brandspecialid=c.brandspecialid AND p.brandid=2
		 */
		//Join query used below
		 hibernateUtil.openCurrentSession();
		 //select p.affinityCategories,p.photoid,c.photoId,c.imagepath from BrandPhotoImages p, BrandChildPhotoImages c  where p.photoid=c.photoId AND p.brandId="+brandId
		 List<Object[]> brandname = hibernateUtil.getCurrentSession().createQuery("select p.affinityCategories,p.photoid,c.photoId,c.imagepath from BrandPhotoImages p, BrandChildPhotoImages c  where p.photoid=c.photoId ").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();		
		 
		 return brandname;
	
	}
	
	
	@Override
	public List<Object[]> getMySpecialChildImages() {
		 hibernateUtil.openCurrentSession();
		 List<Object[]> childimage = hibernateUtil.getCurrentSession().createQuery("select myspecialchildId,childimagepath from  MySpecialsChild").setCacheable(false).list();
		 hibernateUtil.closeCurrentSession();
		return childimage;
	}
	
	@Override
	public void persist(MySpecialsChild entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();

		
	}


	@Override
	public void update(MySpecialsChild entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
		
	}
	
	@SuppressWarnings("unchecked")
	 public List<MySpecialsChild> findBymyspecialchildId(int myspecialchildId) {
		 hibernateUtil.openCurrentSession();
	  List<MySpecialsChild> mySpecialsChild = (List<MySpecialsChild>) hibernateUtil.getCurrentSession().createQuery(" from MySpecialsChild  where myspecialchildId='"+myspecialchildId+"'").setCacheable(false).list();
	     hibernateUtil.closeCurrentSession();
	  return mySpecialsChild;
	 }

	
public static void main(String args[])
{
	MySpecialsPhotoImagesDaoImpl mySpecialsPhotoImagesDaoImpl =new MySpecialsPhotoImagesDaoImpl();
	/*List<Object[]> brandname=mySpecialsPhotoImagesDaoImpl.getMySpecialsPhotoImages(2);
	for(Object[] o:brandname){
		System.out.println(o[0].toString()+"   "+o[1].toString()+"   "+o[2].toString());
*/		// List<Object[]> mySpecialsChild=mySpecialsPhotoImagesDaoImpl.getMySpecialsPhotoImages(3,1);
//for(Object[] i:mySpecialsChild){
	//System.out.println(i[0].toString()+"    "+i[4].toString()+"   "+i[5].toString());//+"   "+i.getNewarrivalId()+"   "+i.getArrivalImage()+"    "+i.getNewarrivaldesc()+"   "+i.getContent());
//}
		
	
	}


@Override
public List<Object[]> getMyspecialchildbyBrandId(int brandId) {
	 hibernateUtil.openCurrentSession();
	 List<Object[]> brandCount = hibernateUtil.getCurrentSession().createQuery("select brandId,childimagepath,content,myspecialchildId,specialDesc,available,bookable,brandshopid from MySpecialsChild where brandId="+brandId).setCacheable(false).list();
	hibernateUtil.closeCurrentSession();		
	 
	return brandCount;
}


@Override
public List<Object[]> getLikedAndUnlikedMyspecialchildbyBrandId(int brandId,
		int userId) {
	
      hibernateUtil.openCurrentSession();
			
	 List<Object[]> brandCount1 = hibernateUtil.getCurrentSession().createQuery("select c.myspecialchildId,c.brandId, c.childimagepath,c.content,c.specialDesc,cc.liked,cc.book,c.available,c.bookable,c.brandshopid from MySpecialsChild c,MySpecialLeafPage cc where c.myspecialchildId =cc.myspecialchildId  and userId="+userId+" and brandId="+brandId).setCacheable(false).list();
	  hibernateUtil.closeCurrentSession();		

	return brandCount1;
}


@Override
public List<Object[]> getUnlikedMyspecialchildbyBrandId(int brandId, int userId) {
	 hibernateUtil.openCurrentSession();
		
		List<Object[]> brandCount2 = hibernateUtil.getCurrentSession().createQuery("select distinct(c.myspecialchildId),c.brandId, c.childimagepath,c.content,c.specialDesc,c.available,c.bookable,c.brandshopid from MySpecialsChild c,MySpecialLeafPage cc  where c.brandId="+brandId+" and c.myspecialchildId NOT IN (select myspecialchildId FROM MySpecialLeafPage WHERE userId="+userId+")").setCacheable(false).list();
		  hibernateUtil.closeCurrentSession();	
	return brandCount2;
}

}


