package com.lola.dao;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.model.AdvtBrands;
import com.lola.services.util.BrandDealsandOffersUtility;
import com.lola.services.util.BrandMySpecialsUtility;
import com.lola.services.util.BrandUtility;

public class AdvtBrandsDaoImpl implements AdvtBrandsDao<AdvtBrands, String>{

	@Override
	public List<Object[]> getAdImageDetails() {
		// TODO Auto-generated method stub

		hibernateUtil.openCurrentSession();
		List<Object[]> imagepath =hibernateUtil.getCurrentSession().createQuery("select imagepath,priority from  AdvtBrands WHERE createdon >= CURDATE() ORDER BY priority ").setCacheable(false).list();
		hibernateUtil.closeCurrentSession(); 
		return imagepath;
	}

	public static void main (String args[]) throws Exception{

		JSONObject jsonObject1 = null;		

		JSONArray jsonArray1 = null;
		JSONArray jsonArray = new JSONArray();
		JSONArray jsonParentArray = new JSONArray();

		AdvtBrandsDaoImpl advtBrandsDaoImpl =new AdvtBrandsDaoImpl();
		BrandDealsandOffersUtility brandImagesUtility = new BrandDealsandOffersUtility();
		BrandMySpecialsUtility brandMySpecialsUtility = new BrandMySpecialsUtility();	
		BrandUtility brandUtility=new BrandUtility();
		String userBrands="0";
		String TotalBrands="0";
		String myDealsnOffers = brandImagesUtility.getMyDealsandOffersbyUserId(3);
		String mySpecials = brandMySpecialsUtility.getMySpecialsbyUserId(3);
		String totalBrands = brandUtility.getTotalBrands();
		List<Object[]> adImages = advtBrandsDaoImpl.getAdImageDetails();



int i=1;
		if(adImages.size()==5){
			for(Object[] o : adImages)
			{		
				jsonObject1 = new JSONObject();
				jsonArray1 = new JSONArray();
				switch(i){
			case 1:
				jsonObject1.put("My Brands",userBrands);
			case 2:
				jsonObject1.put("My Specials",mySpecials);
			case 3:
				jsonObject1.put("My DealsnOffers",myDealsnOffers);
			case 4:
				jsonObject1.put("All Brands",totalBrands);
				}
				jsonObject1.put("Add Image",o[0].toString());
				jsonArray1.put(jsonObject1);
				jsonArray.put(jsonArray1);

			}

			System.out.println(jsonArray.toString().replace("\\", ""));
		}
		else if (adImages.size()>0 && adImages.size()<4)
			System.out.println("some add image missing");
		else
			System.out.println("No add images");


	}

}
