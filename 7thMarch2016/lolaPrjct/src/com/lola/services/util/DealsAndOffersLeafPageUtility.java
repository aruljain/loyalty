package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.DealsAndOffersLeafPageDao;
import com.lola.dao.DealsAndOffersLeafPageDaoImpl;


import com.lola.model.DealsAndOffersLeafPage;


public class DealsAndOffersLeafPageUtility {
	DealsAndOffersLeafPageDao dealsAndOffersLeafPageDaoImpl = new DealsAndOffersLeafPageDaoImpl();
	
	public String saveDealsAndOffersLeafPage(int userId,int dealandofferId) throws Exception{
	JSONObject jsonObject = null;
	String Msg=null;
	try{
		DealsAndOffersLeafPage dealsAndOffersLeafPage = new  DealsAndOffersLeafPage();
				List<DealsAndOffersLeafPage> user =dealsAndOffersLeafPageDaoImpl.findByuserId(userId);
		if(user.size()>0){
				
					List<DealsAndOffersLeafPage> user1=dealsAndOffersLeafPageDaoImpl.findBydealsandofferid(dealandofferId);
					if(user1.size()>0){
					
						for(DealsAndOffersLeafPage entity:user1){
							entity.setUserid(userId);
							entity.setDealandofferid(dealandofferId);
							entity.setDealsandoffersleafId(entity.getDealsandoffersleafId());
							entity.setBook(entity.isBook());
					
					if(entity.isLiked()){
						entity.setLiked(false);
						Msg="Unliked";
						}
					else{
						entity.setLiked(true);
						Msg="Liked";
						}
					
		
					dealsAndOffersLeafPageDaoImpl.update(entity);
					}}
					else{
						dealsAndOffersLeafPage.setDealandofferid(dealandofferId);
						dealsAndOffersLeafPage.setUserid(userId);
						dealsAndOffersLeafPage.setBook(dealsAndOffersLeafPage.isBook());
						
						 if(dealsAndOffersLeafPage.isLiked()){
							 dealsAndOffersLeafPage.setLiked(false);
								Msg="Unliked";
								}
							else{
								dealsAndOffersLeafPage.setLiked(true);
								Msg="Liked";
								}
						 dealsAndOffersLeafPageDaoImpl.persist(dealsAndOffersLeafPage);
						
					}
				
					
				
		
		}else{
			dealsAndOffersLeafPage.setUserid(userId);
			dealsAndOffersLeafPage.setDealandofferid(dealandofferId);;
			dealsAndOffersLeafPage.setLiked(true);
			dealsAndOffersLeafPage.setBook(dealsAndOffersLeafPage.isBook());
			
			dealsAndOffersLeafPageDaoImpl.persist(dealsAndOffersLeafPage);
			Msg="Liked";


		}
	jsonObject =new JSONObject();
	jsonObject.put("Status","Success");
	jsonObject.put("Message",Msg);
	return jsonObject.toString();
}
	catch(Exception e){
		jsonObject =new JSONObject();
		jsonObject.put("Status", "Failure");
		jsonObject.put("Message"," ");
		System.out.println(e);
		return jsonObject.toString();
		
	
}
	


}
	
	public static void main(String[] args) throws Exception{
		DealsAndOffersLeafPageUtility dealsAndOffersLeafPageUtility = new DealsAndOffersLeafPageUtility();
		System.out.println(dealsAndOffersLeafPageUtility.saveDealsAndOffersLeafPage(1, 500009));
	}

}
