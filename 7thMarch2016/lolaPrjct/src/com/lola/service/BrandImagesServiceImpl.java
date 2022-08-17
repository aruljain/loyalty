package com.lola.service;



import com.lola.services.util.BrandImagesUtility;

public class BrandImagesServiceImpl implements BrandImagesService{
	private static BrandImagesUtility brandImagesUtility;

	public BrandImagesServiceImpl() {
		brandImagesUtility = new BrandImagesUtility();
	}

	public String findByCategoryIdWithLimit(int categoryId, int start,
			int offset) throws Exception{
		
		
		
		 
		
		
		return  brandImagesUtility.findByCategoryIdWithLimit(categoryId, start, offset);
	}
}
