package com.lola.dao;

import java.util.List;




import com.lola.model.PhotoimageLeafPage;

public class PhotoimageLeafPageDaoImpl implements PhotoimageLeafPageDao<PhotoimageLeafPage,String>  {

	@Override
	public void persist(PhotoimageLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();
		
	}

	@Override
	public void update(PhotoimageLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
		
	}

	@Override
	public List<PhotoimageLeafPage> findByuserId(int userId) {
		 hibernateUtil.openCurrentSession();
		  List<PhotoimageLeafPage> user = (List<PhotoimageLeafPage>) hibernateUtil.getCurrentSession().createQuery("from PhotoimageLeafPage where userId="+userId).list();
		     hibernateUtil.closeCurrentSession();
		  return user;
		
	}

	@Override
	public List<PhotoimageLeafPage> findBychildphotoimageid(
			int childphotoimageiId) {
		hibernateUtil.openCurrentSession();
		  List<PhotoimageLeafPage> user1 = (List<PhotoimageLeafPage>) hibernateUtil.getCurrentSession().createQuery("from PhotoimageLeafPage where childphotoimageid="+childphotoimageiId).list();
		     hibernateUtil.closeCurrentSession();
		  return user1;
		
	}

}
