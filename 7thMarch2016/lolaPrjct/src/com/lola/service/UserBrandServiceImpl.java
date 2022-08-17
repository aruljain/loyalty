package com.lola.service;



import com.lola.services.util.UserBrandUtility;


public class UserBrandServiceImpl implements UserBrandService{
	/*private static UserBrandDao userbrandDaoImpl;

	public  UserBrandService() {
		userbrandDaoImpl = new UserBrandDaoImpl();
	}*/
	
	UserBrandUtility userBrandUtility =new UserBrandUtility();
	public String saveUserBrand(int userid,String newbrandids) throws Exception{
		
		return userBrandUtility.saveUserBrand(userid, newbrandids);
	}


	public String getMyBrandPoints(int userid) throws Exception{

		

		return	userBrandUtility.getUserBrandPointsDetails(userid).toString();		
	}
	
	@Override
	public String unlikeUserBrand(int userid, String newbrandids)
			throws Exception {
		// TODO Auto-generated method stub
		return userBrandUtility.unlikeUserBrand(userid, newbrandids);
	}

	public static void main(String args[]) throws Exception
	{
		/*String newList = "2,2,4";
		String dbList = "1,2,3";
		String brandids = "1,6,2";
		UserBrandService userBrandService = new UserBrandService();
		userBrandService.saveUserBrand(3, brandids);

		String string = "2,2,4";
		String keyword = "3";

		Boolean found = Arrays.asList(string.split(",")).contains(keyword);

		      System.out.println(found);*/
		
		UserBrandServiceImpl userBrandService = new UserBrandServiceImpl();
		System.out.println(userBrandService.getMyBrandPoints(3));


	}
	
	public String getMyBrandsCountByCategoryId(int userid, int categoryid) throws Exception
	{
		return userBrandUtility.getMyBrandsCountByCategoryId(userid, categoryid);
	}


	@Override
	public String brandPreferenceNoti(int userId, int brandId) throws Exception {
		
		return userBrandUtility.brandPreferenceNoti(userId, brandId);
	}



}

















