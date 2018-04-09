package cn.hncu.dao;

import java.util.Map;

public interface PageDao {
	/*
	 * 必须返回：总页数(int)+查询的表数据(List<Map<String,String>>)
	 * int pageCount=...
	 * List<Map<String,String>> datas=...
	 * 因此可封装成：Map<String,Object>
	 * map.put("pageCount",pageCount)
	 * map.put("datas",datas)
	 */
	
	public Map<String, Object> query(Integer pageNo) throws Exception;
}
