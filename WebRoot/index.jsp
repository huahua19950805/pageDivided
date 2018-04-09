<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>数据分页技术演示</title>
  </head>
  
  <body>
  	<!-- 重定向 -->
   	<a href="pageServlet">分页</a><br>
   <a href="pageServlet2">分页的分页</a>
  </body>
</html>
