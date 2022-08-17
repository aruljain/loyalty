package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;



import com.lola.dao.OnSaleLeafPageDao;
import com.lola.dao.OnSaleLeafPageDaoImpl;
import com.lola.model.DealsAndOffersLeafPage;
import com.lola.model.OnSaleLeafPage;

public class OnSaleLeafPageUtility {
	OnSaleLeafPageDao onSaleLeafPageDaoImpl = new OnSaleLeafPageDaoImpl();
	
	public String saveOnSaleLeafPage(int userId,int onSaleId) throws Exception{
	JSONObject jsonObject = null;
	String Msg=null;
	try{
		OnSaleLeafPage onSaleLeafPage = new  OnSaleLeafPage();
				List<OnSaleLeafPage> user =onSaleLeafPageDaoImpl.findByuserId(userId);
		if(user.size()>0){
				
					List<OnSaleLeafPage> user1=onSaleLeafPageDaoImpl.findByonSaleid(onSaleId);
					if(user1.size()>0){
					
						for(OnSaleLeafPage entity:user1){
							entity.setUserId(userId);
							entity.setOnsaleid(onSaleId);
							entity.setOnsaleleafpageId(entity.getOnsaleleafpageId());
							entity.setBook(entity.isBook());
					
					if(entity.isLiked()){
						entity.setLiked(false);
						Msg="Unliked";
						}
					else{
						entity.setLiked(true);
						Msg="Liked";
						}
					
		
					onSaleLeafPageDaoImpl.update(entity);
					}}
					else{
						onSaleLeafPage.setOnsaleid(onSaleId);
						onSaleLeafPage.setUserId(userId);
						onSaleLeafPage.setBook(onSaleLeafPage.isBook());
						
						 if(onSaleLeafPage.isLiked()){
							 onSaleLeafPage.setLiked(false);
								Msg="Unliked";
								}
							else{
								onSaleLeafPage.setLiked(true);
								Msg="Liked";
								}
						 onSaleLeafPageDaoImpl.persist(onSaleLeafPage);
						
					}
				
					
				
		
		}else{
			onSaleLeafPage.setUserId(userId);
			onSaleLeafPage.setOnsaleid(onSaleId);
			onSaleLeafPage.setLiked(true);
			onSaleLeafPage.setBook(onSaleLeafPage.isBook());
			
			onSaleLeafPageDaoImpl.persist(onSaleLeafPage);
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
		
		OnSaleLeafPageUtility onSaleLeafPageUtility =new OnSaleLeafPageUtility();
		
		System.out.println(onSaleLeafPageUtility.saveOnSaleLeafPage(1, 700004));
	}
	

}
