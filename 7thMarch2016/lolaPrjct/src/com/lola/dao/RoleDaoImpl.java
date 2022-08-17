package com.lola.dao;

import java.util.List;

import com.lola.model.Role;
import com.lola.model.User;

public class RoleDaoImpl implements RoleDao<Role, String>{
	
	
	public RoleDaoImpl(){
		
		
	}

	@SuppressWarnings("unchecked")
	 public List<Object> getRoleName(int roleId) {
		 hibernateUtil.openCurrentSession();
		 List<Object> role =  hibernateUtil.getCurrentSession().createQuery("select roleName from Role where roleid='"+roleId+"'and isactive=true").setCacheable(false).list();
	     hibernateUtil.closeCurrentSession();
	  return role;
	 }
	
	
	public static void main(String args[]) throws Exception
	{
		RoleDaoImpl userDaoImpl = new RoleDaoImpl();
		
			//System.out.println(userDaoImpl.getRoleName(1));
		List<Object> role=userDaoImpl.getRoleName(1);
		for(Object o:role){
			System.out.println(o.toString());	
		}
		
	}
	
	
}
