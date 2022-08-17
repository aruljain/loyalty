package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;



import com.lola.dao.NewarrivalsLeafPageDao;
import com.lola.dao.NewarrivalsLeafPageDaoImpl;

import com.lola.model.NewarrivalsLeafPage;

public class NewarrivalsLeafPageUtility {
	
	NewarrivalsLeafPageDao newarrivalsLeafPageDaoImpl = new NewarrivalsLeafPageDaoImpl();
	public String saveNewarrivalsLeafPage(int userId,int newarrivalId) throws Exception{
	JSONObject jsonObject = null;
	String Msg=null;
	try{
		NewarrivalsLeafPage newarrivalsLeafPage = new  NewarrivalsLeafPage();
				List<NewarrivalsLeafPage> user =newarrivalsLeafPageDaoImpl.findByuserId(userId);
		if(user.size()>0){
				//for(MySpecialLeafPage entity:user){
					List<NewarrivalsLeafPage> user1=newarrivalsLeafPageDaoImpl.findBynewarrivalId(newarrivalId);
					if(user1.size()>0){
					//if(userId==entity.getUserId() && myspecialchildId==entity.getMyspecialchildId()){
						for(NewarrivalsLeafPage entity:user1){
							entity.setUserId(userId);
							entity.setNewarrivalId(newarrivalId);
							entity.setNewarrivalsleafpageId(entity.getNewarrivalsleafpageId());
							entity.setBook(entity.isBook());
					
					if(entity.isLiked()){
						entity.setLiked(false);
						Msg="Unliked";
						}
					else{
						entity.setLiked(true);
						Msg="Liked";
						}
					
		
					newarrivalsLeafPageDaoImpl.update(entity);
					}}
					else{
						newarrivalsLeafPage.setNewarrivalId(newarrivalId);
						newarrivalsLeafPage.setUserId(userId);
						newarrivalsLeafPage.setBook(newarrivalsLeafPage.isBook());
						
						 if(newarrivalsLeafPage.isLiked()){
							 newarrivalsLeafPage.setLiked(false);
								Msg="Unliked";
								}
							else{
								newarrivalsLeafPage.setLiked(true);
								Msg="Liked";
								}
						 newarrivalsLeafPageDaoImpl.persist(newarrivalsLeafPage);
						
					}
				
					
				//}
		
		}else{
			newarrivalsLeafPage.setUserId(userId);
			newarrivalsLeafPage.setNewarrivalId(newarrivalId);
			newarrivalsLeafPage.setLiked(true);
			newarrivalsLeafPage.setBook(newarrivalsLeafPage.isBook());
			
			newarrivalsLeafPageDaoImpl.persist(newarrivalsLeafPage);
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
}
	
	