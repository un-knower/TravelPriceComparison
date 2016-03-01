package com.mobin.dao;

import java.util.List;

import com.mobin.domain.Travel;

public interface TravelDao {

	//public List<Travel> query(String SP, String EP, String ST);
	public List findPageRecords(int currentPageNum, int pageSize,String ST,String SP,String EP);
	public int getTotalRecords(String ST,String SP,String EP);
	//public List findPageRecords(int startIndex, int pageSize,String ST);//管理员页面的数据分页
}
