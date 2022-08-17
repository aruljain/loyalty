package com.lola.service;

public interface MyLeafPageService {
	
	public String saveDealsAndOffersLeafPage(int userId,int dealandofferId) throws Exception;
	public String saveMySpecialLeafPage(int userId,int myspecialchildId) throws Exception;
	public String saveOnSaleLeafPage(int userId,int onSaleId) throws Exception;
	public String saveNewarrivalsLeafPage(int userId,int newarrivalId) throws Exception;
	public String SendBooknow(int userId,int bucketId,int brandId) throws Exception;
	public String savePhotoimagesLeafPage(int userId,int childphotoimageId) throws Exception;

}
