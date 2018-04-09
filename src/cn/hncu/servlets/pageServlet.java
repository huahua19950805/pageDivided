package cn.hncu.servlets;

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
public class pageServlet extends HttpServlet {
	//注入Service层
	IPageService service=new PageService();
	
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
			
			request.setAttribute("res", res);
			
			//导向结果页面 show.jsp
			request.getRequestDispatcher("/jsps/show.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
