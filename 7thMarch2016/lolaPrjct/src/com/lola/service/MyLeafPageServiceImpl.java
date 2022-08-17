package com.lola.service;

import com.lola.services.util.BooknowUtility;
import com.lola.services.util.DealsAndOffersLeafPageUtility;
import com.lola.services.util.MySpecialLeafPageUtility;
import com.lola.services.util.NewarrivalsLeafPageUtility;
import com.lola.services.util.OnSaleLeafPageUtility;
import com.lola.services.util.PhotoimageLeafPageUtility;

public class MyLeafPageServiceImpl implements MyLeafPageService{
	
	DealsAndOffersLeafPageUtility dealsAndOffersLeafPageUtility= new DealsAndOffersLeafPageUtility();
	MySpecialLeafPageUtility mySpecialLeafPageUtility= new MySpecialLeafPageUtility();
	NewarrivalsLeafPageUtility newarrivalsLeafPageUtility= new NewarrivalsLeafPageUtility();
	PhotoimageLeafPageUtility photoimageLeafPageUtility= new PhotoimageLeafPageUtility();
	OnSaleLeafPageUtility onSaleLeafPageUtility=new OnSaleLeafPageUtility();
	BooknowUtility booknowUtility=new BooknowUtility();

	@Override
	public String saveDealsAndOffersLeafPage(int userId, int dealandofferId)
			throws Exception {
		
		return dealsAndOffersLeafPageUtility.saveDealsAndOffersLeafPage(userId, dealandofferId);
	}

	@Override
	public String saveMySpecialLeafPage(int userId, int myspecialchildId)
			throws Exception {
		
		return mySpecialLeafPageUtility.saveMySpecialLeafPage(userId, myspecialchildId);
	}

	@Override
	public String saveOnSaleLeafPage(int userId, int onSaleId) throws Exception {
		
		return onSaleLeafPageUtility.saveOnSaleLeafPage(userId, onSaleId);
	}

	@Override
	public String saveNewarrivalsLeafPage(int userId, int newarrivalId)
			throws Exception {
		
		return newarrivalsLeafPageUtility.saveNewarrivalsLeafPage(userId, newarrivalId);
	}

	@Override
	public String SendBooknow(int userId, int bucketId,int brandId) throws Exception {
		
		return booknowUtility.SendBooknow(userId, bucketId,brandId);
	}

	@Override
	public String savePhotoimagesLeafPage(int userId, int childphotoimageId)
			throws Exception {
		
		return photoimageLeafPageUtility.savePhotoimagesLeafPage(userId, childphotoimageId);
	}

}
