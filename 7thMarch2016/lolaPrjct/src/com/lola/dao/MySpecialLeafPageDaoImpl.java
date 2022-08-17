package com.lola.dao;

import java.util.List;

import com.lola.model.MySpecialLeafPage;
import com.lola.model.User;


public class MySpecialLeafPageDaoImpl implements MySpecialLeafPageDao<MySpecialLeafPage,String>{
	
	@Override
	public void update(MySpecialLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
		
	}

	@Override
	public void persist(MySpecialLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();
		
	}
	
	@SuppressWarnings("unchecked")
	 public List<MySpecialLeafPage> findByuserId(int userId) {
		 hibernateUtil.openCurrentSession();
	  List<MySpecialLeafPage> user = (List<MySpecialLeafPage>) hibernateUtil.getCurrentSession().createQuery("from MySpecialLeafPage where userId="+userId).list();
	     hibernateUtil.closeCurrentSession();
	  return user;
	 }

	@Override
	public List<MySpecialLeafPage> findBymyspecialId(int myspecialchildId) {
		hibernateUtil.openCurrentSession();
		  List<MySpecialLeafPage> user1 = (List<MySpecialLeafPage>) hibernateUtil.getCurrentSession().createQuery("from MySpecialLeafPage where myspecialchildId="+myspecialchildId).list();
		     hibernateUtil.closeCurrentSession();
		  return user1;

		
	}

}
