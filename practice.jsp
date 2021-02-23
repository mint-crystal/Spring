<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 장바구니번호 / 회원이름 / 상품코드  /가격  / 수량  / 입력날짜(오늘날짜) 에 대해  vo(getter/setter) 를 만들어서  실습2) 와같은 내용을 완성하시오 -->
<form method="get">
	장바구니 번호 : <input type="text" name="num" /><br/>
	회원 이름 : <input type="text" name="userName" /><br/>
	상품 코드 : <input type="text" name="code" /><br/>
	가격 : <input type="text" name="price" /><br />
	날짜: <input type="date" name="date" id="date"><br/>
	<input type="submit" value="제출">
</form>
</body>
</html>