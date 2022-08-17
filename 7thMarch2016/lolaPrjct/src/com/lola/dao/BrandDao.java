package com.lola.dao;

import java.io.Serializable;
import java.util.List;

public interface BrandDao<T, Id  extends Serializable> extends HibernateUtilDao{
		
		//public List<Object[]> getMyBrandsByCategoryId(int userid,int categoryid,int start,int offset);
		public List<Object[]> getMyBrandsByCategoryId(int userid,int categoryid);
		public List<Object[]> getAllBrandsByCategoryId(int userid,int categoryid,int start,int offset);
		public String getTotalBrands();
		public List<Object[]> getBrandLogo(int brandid);
		public List<Object[]> getBrandDetails();
		public List<Object[]> getBrandNamesByCategoryId(int categoryid);
		public int getAllBrandsCountByCategory(int userid, int categoryid);
}

