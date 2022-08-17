package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.MySpecialLeafPageDao;
import com.lola.dao.MySpecialLeafPageDaoImpl;
import com.lola.model.MySpecialLeafPage;

public class MySpecialLeafPageUtility {
	
	MySpecialLeafPageDao mySpecialLeafPageDaoImpl = new MySpecialLeafPageDaoImpl();
	public String saveMySpecialLeafPage(int userId,int myspecialchildId) throws Exception{
	JSONObject jsonObject = null;
	String Msg=null;
	try{
		MySpecialLeafPage mySpecialLeafPage = new  MySpecialLeafPage();
				List<MySpecialLeafPage> user =mySpecialLeafPageDaoImpl.findByuserId(userId);
		if(user.size()>0){
				
					List<MySpecialLeafPage> user1=mySpecialLeafPageDaoImpl.findBymyspecialId(myspecialchildId);
					if(user1.size()>0){
					
						for(MySpecialLeafPage entity:user1){
							entity.setUserId(userId);
							entity.setMyspecialchildId(myspecialchildId);
							entity.setMyspecialleafId(entity.getMyspecialleafId());
							entity.setBook(entity.isBook());
					
					if(entity.isLiked()){
						entity.setLiked(false);
						Msg="Unliked";
						}
					else{
						entity.setLiked(true);
						Msg="Liked";
						}
					
		
					mySpecialLeafPageDaoImpl.update(entity);
					}}
					else{
						mySpecialLeafPage.setMyspecialchildId(myspecialchildId);
						mySpecialLeafPage.setUserId(userId);
						mySpecialLeafPage.setBook(mySpecialLeafPage.isBook());
						 if(mySpecialLeafPage.isLiked()){
							 mySpecialLeafPage.setLiked(false);
								Msg="Unliked";
								}
							else{
								mySpecialLeafPage.setLiked(true);
								Msg="Liked";
								}
						mySpecialLeafPageDaoImpl.persist(mySpecialLeafPage);
						
					}
				
					
				
		
		}else{
			mySpecialLeafPage.setUserId(userId);
			mySpecialLeafPage.setMyspecialchildId(myspecialchildId);
			mySpecialLeafPage.setBook(mySpecialLeafPage.isBook());
			mySpecialLeafPage.setLiked(true);
			
			mySpecialLeafPageDaoImpl.persist(mySpecialLeafPage);
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
		MySpecialLeafPageUtility mySpecialLeafPageUtility = new MySpecialLeafPageUtility();
		System.out.println(mySpecialLeafPageUtility.saveMySpecialLeafPage(5, 4));
	}
}
