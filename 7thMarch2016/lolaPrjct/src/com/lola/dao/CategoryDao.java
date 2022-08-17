package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface CategoryDao <T, Id  extends Serializable> extends HibernateUtilDao{
	public List<Object[]> getcategoryDetails();
 
}
