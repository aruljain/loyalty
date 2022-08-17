package com.lola.service;

import com.lola.services.util.OnSaleUtility;

public class OnSaleServiceImpl implements OnSaleService{
	
	OnSaleUtility onSaleUtility=new OnSaleUtility();

	@Override
	public String getMyOnSale(int userId, int categoryId) throws Exception {
		
		return onSaleUtility.getMyOnSale(userId, categoryId);
	}

}
