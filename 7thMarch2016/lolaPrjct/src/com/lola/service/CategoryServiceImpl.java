package com.lola.service;

import com.lola.services.util.BrandsnCategoriesUtility;

public class CategoryServiceImpl implements CategoryService {

	
	BrandsnCategoriesUtility brandsnCategoriesUtility =new BrandsnCategoriesUtility();
	@Override
	public String getBrandsAndCategoriesDetails() throws Exception{
		
		return brandsnCategoriesUtility.getBrandsAndCategories();
	}

}
