package com.lola.service;

import com.lola.services.util.SearchUtility;

public class SearchServiceImpl implements SearchService{
	
	SearchUtility searchUtility = new SearchUtility();
	
	public String searchGlobal(int userid, String searchString) throws Exception
	{
		return searchUtility.searchBucketsAcrossBrands(userid, searchString);
	}

}
