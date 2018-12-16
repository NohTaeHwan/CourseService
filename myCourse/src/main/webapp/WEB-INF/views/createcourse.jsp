<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청하기</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
	<h1>수강 신청</h1><br/>
	<sf:form method="post" action="${pageContext.request.contextPath}/coursecreated" modelAttribute="course">
		<table class="formtable">
			<tr><td class="label"> 과목코드: </td> <td><sf:input class="control" type="text" path="subjectcode"/><br/>
				<sf:errors path="subjectcode" class="error"/> </td></tr>
			<tr><td class="label"> 년도: </td> <td><sf:input class="control" type="text" path="year"/><br/>
				<sf:errors path="year" class="error"/> </td></tr>
			<tr><td class="label"> 학기: </td> <td><sf:input class="control" type="text" path="semester"/><br/>
				<sf:errors path="semester" class="error"/> </td></tr>
			<tr><td class="label"> 과목이름: </td> <td><sf:input class="control" type="text" path="subject"/><br/>
				<sf:errors path="subject" class="error"/> </td></tr>
			<tr><td class="label"> 구분: </td> <td><sf:input class="control" type="text" path="division"/><br/>
				<sf:errors path="division" class="error"/> </td></tr>
			<tr><td class="label"> 학점: </td> <td><sf:input class="control" type="text" path="credit"/><br/>
				<sf:errors path="credit" class="error"/> </td></tr>			
			<tr><td class="label"> </td> <td><input class="control" type="submit" value="신청"/></td></tr>
		</table>
	</sf:form>
</body>
</html>