package com.lola.dao;

import java.util.List;



import com.lola.model.NewarrivalsLeafPage;

public class NewarrivalsLeafPageDaoImpl implements NewarrivalsLeafPageDao<NewarrivalsLeafPage,String> {

	@Override
	public void persist(NewarrivalsLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();

		
	}

	@Override
	public void update(NewarrivalsLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
		
	}

	@Override
	public List<NewarrivalsLeafPage> findByuserId(int userId) {
		 hibernateUtil.openCurrentSession();
		  List<NewarrivalsLeafPage> user = (List<NewarrivalsLeafPage>) hibernateUtil.getCurrentSession().createQuery("from NewarrivalsLeafPage where userId="+userId).list();
		     hibernateUtil.closeCurrentSession();
		  return user;

		
	}

	@Override
	public List<NewarrivalsLeafPage> findBynewarrivalId(int newarrivalId) {
		hibernateUtil.openCurrentSession();
		  List<NewarrivalsLeafPage> user1 = (List<NewarrivalsLeafPage>) hibernateUtil.getCurrentSession().createQuery("from NewarrivalsLeafPage where newarrivalId="+newarrivalId).list();
		     hibernateUtil.closeCurrentSession();
		  return user1;

		
	
	}


}
