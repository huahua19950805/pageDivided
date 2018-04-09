package cn.hncu.dao;

import java.sql.SQLException;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.hncu.pubs.C3p0Utils;

/*
 * 必须返回：总页数(int) + 查询的表数据(List<Map<String,String>>)
 * 因此可封装成: 
 * int pageCount = ...
 * List<Map<String,String>> datas = ...
 * Map<String,Object> map = new HashMap<String,Object>();
 * 
 * map.put("pageCount",pageCount); //1
 * map.put("datas",datas);//2
 */

public class pageDaodbc implements PageDao{

	@Override
	public Map<String, Object> query(Integer pageNo) throws Exception {
		
		Map<String, Object> res=new HashMap<String, Object>();
		
		//每页显示多少行
		int pageSize=10;
		
		//查询总页数
		QueryRunner run=new  QueryRunner(C3p0Utils.getDataSource());
		String sql="select count(1) from person2";
		int count=Integer.parseInt("" +run.query(sql, new ScalarHandler()));
		int pageCount=(count/pageSize)+ (count%pageSize>0?1:0);
		 
		res.put("pageCount", pageCount);
		
		//查询当前页的表数据
		int startNo=(pageNo-1)*pageSize;
		String sql2="select * from person2 limit "+startNo+","+pageSize;
		List<Map<String, Object>> datas=run.query(sql2, new MapListHandler());
		res.put("datas", datas);
		
		//封装并返回
		return res;
	}

}
