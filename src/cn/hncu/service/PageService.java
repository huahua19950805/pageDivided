package cn.hncu.service;

import java.util.Map;

public class PageService implements IPageService{

	@Override
	public Map<String, Object> query(Integer pageNo) throws Exception {
		return dao.query(pageNo);
	}

}
