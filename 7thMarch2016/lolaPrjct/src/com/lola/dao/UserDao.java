package com.lola.dao;

import java.io.Serializable;
import java.util.List;

import com.lola.hibernate.HibernateUtil;
import com.lola.model.User;

public interface UserDao<T, Id  extends Serializable> extends HibernateUtilDao{
	
	 public void persist(T entity);
	 public void update(T entity);
	 public List<T> findByMobile(String mobile);
	 public List<T> findByemailId(String email);
	 public List<T> findByuserid(int userId);
	 public String getUserLocation(int userid);
	
	 
	
}
