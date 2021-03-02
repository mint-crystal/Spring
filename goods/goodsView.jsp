<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>선택 상품 정보</h1>
<table border="1">
	<tr>
	<th>코드</th><th>이름</th><th>가격</th><th>색상</th><th>날짜</th>
	</tr>
	<tr>
	<td>${goods.code}</td>
	<td>${goods.name}</td>
	<td>${goods.price}</td>
	<td>${goods.color}</td>
	<td>${goods.regDate}</td>
	</tr>
</table>
<a href="goodsList.do">메인페이지</a>
</body>
</html>