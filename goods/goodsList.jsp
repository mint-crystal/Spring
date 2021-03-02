<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상품 목록</h1>
<table border="1">
	<tr>
	<th>코드</th><th>이름</th><th>가격</th><th>색상</th><th>날짜</th><th>수정</th><th>삭제</th>
	</tr>
	<c:forEach var="list" items="${goodsList }">
	<tr>
	<td><a href="goodsView.do?code=${list.code}">${list.code}</a></td>
	<td>${list.name}</td>
	<td>${list.price}</td>
	<td>${list.color}</td>
	<td>${list.regDate}</td>
	<td><a href="goodsUpt.do?code=${list.code}">수정</a></td>
	<td><a href="goodsDel.do?code=${list.code}">삭제</a></td>
	</tr>
	</c:forEach>
</table>
<a href="goodsIns.do">상품 등록</a>
</body>
</html>