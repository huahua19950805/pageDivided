package cn.hncu.v2.service;

import java.util.Map;

public class PageService2 implements IPageService2{

	@Override
	public Map<String, Object> query(Integer pageNo) throws Exception {
		return dao.query(pageNo);
	}

}
