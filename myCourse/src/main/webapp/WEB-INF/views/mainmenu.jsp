<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 선택</title>
</head>
<body>
	<h1>- 메뉴 선택 -</h1><br/>
	<p><a href="${pageContext.request.contextPath}/showcourse">Show courses</a>
	<p><a href="${pageContext.request.contextPath}/createcourse">Create new course</a>
	<p><a href="${pageContext.request.contextPath}/newcourse">Show new course</a><br/>
<%-- 	<p><a href="${pageContext.request.contextPath}/logout">Logout</a> --%>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
      <a href="javascript:document.getElementById('logout').submit()">Logout</a>
   </c:if>

   <form id="logout" action="${pageContext.request.contextPath}/logout" method="post">
      <input type="hidden" name="${_csrf.parameterName}"
         value="${_csrf.token}" />
   </form>
</body>
</html>