package com.lola.service;

import com.lola.services.util.BrandChildPhotoImagesUtility;

public class BrandPhotoImagesServiceImpl implements BrandPhotoImagesService {
	
	
	private static BrandChildPhotoImagesUtility brandChildPhotoImagesUtility;

	public BrandPhotoImagesServiceImpl() {
		brandChildPhotoImagesUtility = new BrandChildPhotoImagesUtility();
	}

	public String getimagepathbyBrandId(int brandId,int userId) throws Exception{

		

		return	brandChildPhotoImagesUtility.getimagepathbyBrandId(brandId,userId).toString();		
	}
/*
	@Override
	public String saveBrandChildPhotoImagesLeafPage(int userId, int childphotoimageId) throws Exception {
		// TODO Auto-generated method stub
		return brandChildPhotoImagesUtility.saveBrandChildPhotoImagesLeafPage(userId, childphotoimageId);
	}
	
*/
}
