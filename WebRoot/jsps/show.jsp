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
    <h1>信息分页</h1>
  	<c:forEach items="${res.datas }" var="map">
  		${map.id }&nbsp;${map.name }<br>
  	</c:forEach>
  	
  	<hr>
  	<c:set value="${res.currentPage }" var="currentPage"></c:set>
  	<c:set value="${res.pageCount }" var="pageCount"></c:set>
  	
  	<c:if test="${currentPage!=1}">
  		<a href="<c:url value='/pageServlet?page=${ currentPage-1}'/>">上一页</a>&nbsp;
  	</c:if>
  	
  	<c:forEach begin="1" end="${pageCount}" var="idx">
  		<c:if test="${currentPage==idx}" var="isCurrent">
  			${idx }&nbsp;
  		</c:if>
  		
  		<c:if test="${!isCurrent}">
  			<a href="<c:url value='/pageServlet?page=${ idx}'/>">${idx }</a>&nbsp;
  		</c:if>
  	</c:forEach>
   
   <c:if test="${currentPage!=pageCount}">
  		<a href="<c:url value='/pageServlet?page=${ currentPage+1}'/>">下一页</a>&nbsp;
  	</c:if>
  	
  	<hr>
  	<select onchange="sub(this)">
  		<c:forEach begin="1" end="${pageCount }" var="idx">
  			<option <c:if test="${ currentPage==idx}">selected</c:if> value="${idx}">第${idx}页</option>
  		</c:forEach>
  	</select>
  	
  	<script type="text/javascript">
  		function sub(obj){
  			window.location.href="<c:url value='/pageServlet?page='/>+${obj.value}";
  		}
  	</script>
  </body>
</html>
