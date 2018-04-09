package cn.hncu.v2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hncu.service.IPageService;
import cn.hncu.service.PageService;
import cn.hncu.v2.service.IPageService2;
import cn.hncu.v2.service.PageService2;
public class pageServlet2 extends HttpServlet {
	//注入Service层
	IPageService2 service=new PageService2();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//收集参数
		String sPageNo=request.getParameter("page");
		if(sPageNo==null||sPageNo.trim().length()==0){
			sPageNo="1";
		}
		Integer pageNo=Integer.valueOf(sPageNo);
		
		//调用service层
		Map<String, Object> res=new HashMap<String, Object>();
		
		try {
			res = service.query(pageNo);
			//System.out.println(res);
			//放入当前的页数
			res.put("currentPage", pageNo);
			
			///////分页的分页////////
			int showSize=10;//一页显示几个页号
			int showStart=0;//起始页号
			int showEnd=0;//结束页号
			int pageCount=Integer.parseInt(""+res.get("pageCount"));
			if(pageCount<=showSize){
				showStart=1;
				showEnd=pageCount;
			}else{
				if(pageNo<=(showSize/2-1)){
					showStart=1;
					showEnd=showSize;
				}else{
					showStart=pageNo-(showSize/2);
				}
				//计算结束页号
				showEnd=showStart+showSize-1;
				if(showEnd>pageCount){
					showEnd=pageCount;
					showStart=showEnd-(showSize-1);
				}
				
			}
			
			System.out.println(showStart+","+showEnd);
			
			request.setAttribute("showStart", showStart);
			request.setAttribute("showEnd", showEnd);
			request.setAttribute("res", res);
			
			//导向结果页面 show.jsp
			request.getRequestDispatcher("/jsps/show2.jsp").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
