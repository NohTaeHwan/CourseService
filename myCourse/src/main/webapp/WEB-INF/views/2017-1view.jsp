<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2017학년도 1학기</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
	<h1>2017학년도 1학기</h1><br/>
	<table border="1" class="formtable">
			<tr><th>과목이름</th><th>년도</th><th>학기</th><th>과목코드</th><th>구분</th><th>학점</th></tr>
			<c:forEach var="course" items="${courses}">
				<tr>
					<td><c:out value="${course.subject}"></c:out></td> 
					<td><c:out value="${course.year}"></c:out></td>
					<td><c:out value="${course.semester}"></c:out></td>
					<td><c:out value="${course.subjectcode}"></c:out></td>
					<td><c:out value="${course.division}"></c:out></td>
					<td><c:out value="${course.credit}"></c:out></td>
				</tr>
			</c:forEach>
	</table>	
</body>
</html>