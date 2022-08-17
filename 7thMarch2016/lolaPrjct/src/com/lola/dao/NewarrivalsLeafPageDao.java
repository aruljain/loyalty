package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface NewarrivalsLeafPageDao<T,Id extends Serializable>  extends HibernateUtilDao  {
	
	 public void persist(T entity);
		public void update(T entity);
		public List<T> findByuserId(int userId);
		public List<T> findBynewarrivalId(int newarrivalId);


}
