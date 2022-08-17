package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface RoleDao<T, Id  extends Serializable> extends HibernateUtilDao {

	public List<Object> getRoleName(int roleId);
	
	
}
