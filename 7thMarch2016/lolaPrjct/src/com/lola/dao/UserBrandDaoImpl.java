package com.lola.dao;






import java.util.List;

import com.lola.model.User;
import com.lola.model.UserBrand;

public class UserBrandDaoImpl implements UserBrandDao <UserBrand,String>{





	@Override
	public void persist(UserBrand entity) {
		// TODO Auto-generated method stub
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().saveOrUpdate(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();
	}



	public void update(UserBrand entity) {
		// TODO Auto-generated method stub
		hibernateUtil.openCurrentSessionwithTransaction();
		hibernateUtil.getCurrentSession().update(entity);
		hibernateUtil.closeCurrentSessionwithTransaction();		

	}


	public String getBrandidsByUserId(int userid)
	{
		String ids = "";
		StringBuffer strBuff = new StringBuffer();

		hibernateUtil.openCurrentSession();
		List<Object> brandids = hibernateUtil.getCurrentSession().createQuery("select distinct(brandid) from UserBrand where userid="+userid+" and liked=1").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		int i=0;
		while(i<brandids.size())		 
		{
			strBuff = strBuff.append(brandids.get(i).toString());
			i++;
			if(i<brandids.size())
				strBuff.append(",");		 
		}

		ids=strBuff.toString();

		return ids;
	}


	public String getUserBrandids(int userid)
	{
		String ids = "";
		StringBuffer strBuff = new StringBuffer();

		hibernateUtil.openCurrentSession();
		List<Object> brandids = hibernateUtil.getCurrentSession().createQuery("select distinct(brandid) from UserBrand where userid="+userid).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		int i=0;
		while(i<brandids.size())		 
		{
			strBuff = strBuff.append(brandids.get(i).toString());
			i++;
			if(i<brandids.size())
				strBuff.append(",");		 
		}

		ids=strBuff.toString();

		return ids;
	}
	public String getUserbrandid(int userid)
	{
		String ids = "";
		StringBuffer strBuff = new StringBuffer();

		hibernateUtil.openCurrentSession();
		List<Object> brandids = hibernateUtil.getCurrentSession().createQuery("select distinct(userbrandid) from UserBrand where userid="+userid).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		int i=0;
		while(i<brandids.size())		 
		{
			strBuff = strBuff.append(brandids.get(i).toString());
			i++;
			if(i<brandids.size())
				strBuff.append(",");		 
		}

		ids=strBuff.toString();

		return ids;
	}


	@Override
	public List<Object[]> getUserBrandPoints(int userid) {
		// TODO Auto-generated method stub
		hibernateUtil.openCurrentSession();
		List<Object[]> brandids = hibernateUtil.getCurrentSession().createQuery("select count(distinct brandid),sum(balancepoints) from UserBrand where userid="+userid+" and liked="+1).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return brandids;
	}	



	@Override
	public List<Object> getUserPointsByBrandid(int userid, int brandid) {
		// TODO Auto-generated method stub
		hibernateUtil.openCurrentSession();
		List<Object> brandpoints = hibernateUtil.getCurrentSession().createQuery("select sum(balancepoints) from UserBrand where userid="+userid+" and brandid="+brandid+" and liked="+1).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();
		return brandpoints;		
	}

	@Override
	public String getUserBrandIdsByBrandidsAnduserIds(int userId, String brandIds) 
	{
		String userBrandIds = "";
		StringBuffer strBuff = new StringBuffer();
		hibernateUtil.openCurrentSession();
		List<Object> brandids = hibernateUtil.getCurrentSession().createQuery("select userbrandid from UserBrand where userid="+userId+" and brandid in("+brandIds+") and liked="+1).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();

		int i=0;
		while(i<brandids.size())		 
		{
			strBuff = strBuff.append(brandids.get(i).toString());
			i++;
			if(i<brandids.size())
				strBuff.append(",");		 
		}

		userBrandIds=strBuff.toString();

		return userBrandIds;

	}

	public String getUserbrandIds(int userid,String brandids)
	{
		String userBrandIds = "";
		StringBuffer strBuff = new StringBuffer();
		hibernateUtil.openCurrentSession();
		List<Object> ids = hibernateUtil.getCurrentSession().createQuery("select userbrandid from UserBrand where userid="+userid+" and brandid in ("+brandids+")").setCacheable(false).list();
		hibernateUtil.closeCurrentSession();

		int i=0;
		while(i<ids.size())		 
		{
			strBuff = strBuff.append(ids.get(i).toString());
			i++;
			if(i<ids.size())
				strBuff.append(",");		 
		}

		userBrandIds=strBuff.toString();

		return userBrandIds;

	}

	public int getUserbrandId(int userid,int brandid){
		int userbrandid=0;
		hibernateUtil.openCurrentSession();
		List<Object> id = hibernateUtil.getCurrentSession().createQuery("select userbrandid from UserBrand where userid="+userid+" and brandid="+brandid).setCacheable(false).list();
		hibernateUtil.closeCurrentSession();

		for(Object o: id)
		{
			userbrandid=Integer.parseInt(o.toString());
		}

		return userbrandid;
	}


	public int getMyBrandCountByCategoryId(int userid, int categoryid)
	{
		int count=0;
		hibernateUtil.openCurrentSession();
		Object totalBrands = hibernateUtil.getCurrentSession().createQuery("select count(brandid) from UserBrand where userid="+userid+" and brandid in (select brandId from Brand where categoryid="+categoryid+") and liked=1)").setCacheable(false).uniqueResult();
		hibernateUtil.closeCurrentSession();
		count =Integer.parseInt(totalBrands.toString());

		return count;
	}



	public static void main (String args[]){

		String newbrandids="2,3,4";
		UserBrandDaoImpl userbrand= new UserBrandDaoImpl();
		/*hibernateUtil.openCurrentSessionwithTransaction();
		UserBrand user=new UserBrand();
		user.setUserid(3);
		user.setBalancepoints(500);
		user.setBrandid(1);
	   userbrand.persist(user);
	   hibernateUtil.closeCurrentSessionwithTransaction();*/
		//	System.out.println(userbrand.getUserbrandId(4,2));
		System.out.println(userbrand.getMyBrandCountByCategoryId(299,2));


		/*	List<Object> userbrands = userbrand.getUserPointsByBrandid(30, 2);
		if(userbrands.size()>0){
		for(Object o:userbrands)
		{
			if(o!=null)
			System.out.println(o.toString());
			else
				System.out.println("no ...");

		}}else
			System.out.println("no records");*/

		/*List<Object[]> userbrands = userbrand.getUserBrandPoints(51);
		for(Object o[]:userbrands){

		if(o[1]==null)

			System.out.println("null");*/

		/*
		String brandids = userbrand.getUserBrandIdsByBrandidsAnduserIds(2,"2,3,4");
		if(brandids.equals(""))
		{
			System.out.println("User has no brands");
		}
		else
		{
			System.out.println("brandid "+brandids);
		}
		 */



	}



	@Override
	public List<UserBrand> findByuserId(int userId) {
		  hibernateUtil.openCurrentSession();
		  List<UserBrand> user = (List<UserBrand>) hibernateUtil.getCurrentSession().createQuery("from UserBrand where userid='"+userId+"'and isactive=true").setCacheable(false).list();
		  hibernateUtil.closeCurrentSession();
		return user;
	}



	@Override
	public List<UserBrand> findBybrandId(int brandId) {
		 hibernateUtil.openCurrentSession();
		  List<UserBrand> userBrandId = (List<UserBrand>) hibernateUtil.getCurrentSession().createQuery("from UserBrand where brandid='"+brandId+"'and isactive=true").setCacheable(false).list();
		  hibernateUtil.closeCurrentSession();
		return userBrandId;
	}




}
