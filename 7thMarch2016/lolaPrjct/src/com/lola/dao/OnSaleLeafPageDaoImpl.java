package com.lola.dao;

import java.util.List;




import com.lola.model.OnSaleLeafPage;

public class OnSaleLeafPageDaoImpl implements OnSaleLeafPageDao<OnSaleLeafPage,String>{

	@Override
	public void persist(OnSaleLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();
		
		
	}

	@Override
	public void update(OnSaleLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
		
	}

	@Override
	public List<OnSaleLeafPage> findByuserId(int userId) {
		hibernateUtil.openCurrentSession();
		  List<OnSaleLeafPage> user = (List<OnSaleLeafPage>) hibernateUtil.getCurrentSession().createQuery("from OnSaleLeafPage where userId="+userId).list();
		     hibernateUtil.closeCurrentSession();
		  return user;
		
	}
	

	@Override
	public List<OnSaleLeafPage> findByonSaleid(int onSaleId) {
		hibernateUtil.openCurrentSession();
		  List<OnSaleLeafPage> user1 = (List<OnSaleLeafPage>) hibernateUtil.getCurrentSession().createQuery("from OnSaleLeafPage where onsaleid="+onSaleId).list();
		     hibernateUtil.closeCurrentSession();
		  return user1;

	}

}
