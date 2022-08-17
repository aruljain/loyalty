package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;


import com.lola.dao.PhotoimageLeafPageDao;
import com.lola.dao.PhotoimageLeafPageDaoImpl;

import com.lola.model.PhotoimageLeafPage;

public class PhotoimageLeafPageUtility {
	PhotoimageLeafPageDao photoimageLeafPageDaoImpl = new PhotoimageLeafPageDaoImpl();
	public String savePhotoimagesLeafPage(int userId,int childphotoimageId) throws Exception{
	JSONObject jsonObject = null;
	String Msg=null;
	try{
		PhotoimageLeafPage photoimageLeafPage = new  PhotoimageLeafPage();
				List<PhotoimageLeafPage> user =photoimageLeafPageDaoImpl.findByuserId(userId);
		if(user.size()>0){
				//for(MySpecialLeafPage entity:user){
					List<PhotoimageLeafPage> user1=photoimageLeafPageDaoImpl.findBychildphotoimageid(childphotoimageId);
					if(user1.size()>0){
					//if(userId==entity.getUserId() && myspecialchildId==entity.getMyspecialchildId()){
						for(PhotoimageLeafPage entity:user1){
							entity.setUserId(userId);
							entity.setChildphotoimageid(childphotoimageId);
							entity.setPhotoimagesleafpageId(entity.getPhotoimagesleafpageId());
					
					if(entity.isLiked()){
						entity.setLiked(false);
						Msg="Unliked";
						}
					else{
						entity.setLiked(true);
						Msg="Liked";
						}
					
		
					photoimageLeafPageDaoImpl.update(entity);
					}}
					else{
						photoimageLeafPage.setChildphotoimageid(childphotoimageId);;
						photoimageLeafPage.setUserId(userId);
						 if(photoimageLeafPage.isLiked()){
							 photoimageLeafPage.setLiked(false);
								Msg="Unliked";
								}
							else{
								photoimageLeafPage.setLiked(true);
								Msg="Liked";
								}
						 photoimageLeafPageDaoImpl.persist(photoimageLeafPage);
						
					}
				
					
				//}
		
		}else{
			photoimageLeafPage.setUserId(userId);
			photoimageLeafPage.setChildphotoimageid(childphotoimageId);
			photoimageLeafPage.setLiked(true);
			
			photoimageLeafPageDaoImpl.persist(photoimageLeafPage);
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
