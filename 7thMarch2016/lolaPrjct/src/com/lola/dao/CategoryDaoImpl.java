package com.lola.dao;

import java.util.List;

import com.lola.model.Brand;
import com.lola.model.Category;

public class CategoryDaoImpl implements CategoryDao<Category, String>{

	@Override
	public List<Object[]> getcategoryDetails() {
		hibernateUtil.openCurrentSession();
		List<Object[]> categorydetail = hibernateUtil.getCurrentSession().createQuery("select categoryId,categoryName from Category ").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return categorydetail;
		
	}
	public static void main(String args[]){
		CategoryDaoImpl categoryDaoImpl = new CategoryDaoImpl();
		
		List<Object[]> categorydetail=categoryDaoImpl.getcategoryDetails();
		for(Object[] o:categorydetail){
		System.out.println(o[0].toString()+"     "+o[1].toString());
		}
	}

}
