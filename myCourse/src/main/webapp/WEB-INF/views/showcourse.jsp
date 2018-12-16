<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 목록</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css"/>
</head>
<body>
	<h1>수강 내역 조회</h1><br/>
	<table border="1" class="formtable">
			<tr><th> 년도 </th> <th>학기</th><th>이수학점</th><th>상세보기</th></tr>
			<tr><td> 2017 </td> <td>1</td><td>18</td><td><a href="${pageContext.request.contextPath}/2017-1view">상세보기</a></td></tr>
			<tr><td> 2017 </td> <td>2</td><td>21</td><td><a href="${pageContext.request.contextPath}/2017-2view">상세보기</a></td></tr>
			<tr><td> 2018 </td> <td>1</td><td>20</td><td><a href="${pageContext.request.contextPath}/2018-1view">상세보기</a></td></tr>
			<tr><td> 2018 </td> <td>2</td><td>21</td><td><a href="${pageContext.request.contextPath}/2018-2view">상세보기</a></td></tr>
	</table>
</body>
</html>