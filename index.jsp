<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index페이지 ${requestScope.myMessage } <!-- request.setAttribute를 사용할때 스코프를 사용(스프링도 가능) -->
	${myMessage }<!-- 스프링은 key만 적어줘도 됨 -->
</body>
</html>