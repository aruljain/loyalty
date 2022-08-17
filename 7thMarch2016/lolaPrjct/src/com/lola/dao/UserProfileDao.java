package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface UserProfileDao<T, Id  extends Serializable> extends HibernateUtilDao {
		 public void persist(T entity);
		 public void update(T entity);
		 public void saveorupdate(T entity);
		 public List<T> findByuserid(int userId);
		 public int isUserProfileExist(int userId);
		 public Object getProfilepic(int userId);
}

