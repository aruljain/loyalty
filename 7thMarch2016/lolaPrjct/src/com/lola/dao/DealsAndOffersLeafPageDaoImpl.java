package com.lola.dao;

import java.util.List;

import com.lola.model.DealsAndOffersLeafPage;
import com.lola.model.MySpecialLeafPage;

public class DealsAndOffersLeafPageDaoImpl implements DealsAndOffersLeafPageDao<DealsAndOffersLeafPage,String>{

	@Override
	public void persist(DealsAndOffersLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().save(entity);	
		hibernateUtil.closeCurrentSessionwithTransaction();
		
	}

	@Override
	public void update(DealsAndOffersLeafPage entity) {
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
		

		
	}

	@Override
	public List<DealsAndOffersLeafPage> findByuserId(int userId) {
		hibernateUtil.openCurrentSession();
		  List<DealsAndOffersLeafPage> user = (List<DealsAndOffersLeafPage>) hibernateUtil.getCurrentSession().createQuery("from DealsAndOffersLeafPage where userid="+userId).list();
		     hibernateUtil.closeCurrentSession();
		  return user;
		
	}

	@Override
	public List<DealsAndOffersLeafPage> findBydealsandofferid(int dealandofferId) {
		hibernateUtil.openCurrentSession();
		  List<DealsAndOffersLeafPage> user1 = (List<DealsAndOffersLeafPage>) hibernateUtil.getCurrentSession().createQuery("from DealsAndOffersLeafPage where dealandofferid="+dealandofferId).list();
		     hibernateUtil.closeCurrentSession();
		  return user1;


		
	}

}
