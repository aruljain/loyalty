package com.lola.service;

import com.lola.services.util.MySpecialPhotoImagesUtility;

public class MySpecialPhotoImagesServiceImpl implements MySpecialPhotoImagesService{
	
	private static MySpecialPhotoImagesUtility mySpecialPhotoImagesUtility;
	
	public MySpecialPhotoImagesServiceImpl(){
		
		mySpecialPhotoImagesUtility = new MySpecialPhotoImagesUtility();
	}

	public String getMySpecialsPhotoImages(int brandId,int userId) throws Exception{

		

		return	mySpecialPhotoImagesUtility.getMySpecialsPhotoImages(brandId,userId).toString();		
	}

	/*@Override
	public String saveMySpecialLeavePage(int userId, int myspecialchildId)
			throws Exception {
		
		return mySpecialPhotoImagesUtility.saveLeavePage(userId, myspecialchildId);
	}
	*/
}
