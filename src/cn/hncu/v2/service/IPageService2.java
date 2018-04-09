package cn.hncu.v2.service;

import java.util.Map;

import cn.hncu.dao.PageDao;
import cn.hncu.dao.pageDaodbc;
import cn.hncu.v2.dao.PageDao2;
import cn.hncu.v2.dao.pageDaodbc2;

public interface IPageService2 {
	//注入Dao
	PageDao2 dao=new pageDaodbc2();
	public Map<String, Object> query(Integer pageNo) throws Exception;
}
