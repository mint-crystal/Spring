<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${data1 }
	${data2 } <br>
	${data3 } <br>
	<fmt:formatDate value="${data3}" type="date" pattern="yyyy년MM월dd일 hh시mm분ss초"/>
	
</body>
</html>