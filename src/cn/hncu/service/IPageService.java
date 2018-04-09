package cn.hncu.service;

import java.util.Map;

import cn.hncu.dao.PageDao;
import cn.hncu.dao.pageDaodbc;

public interface IPageService {
	//注入Dao
	PageDao dao=new pageDaodbc();
	public Map<String, Object> query(Integer pageNo) throws Exception;
}
