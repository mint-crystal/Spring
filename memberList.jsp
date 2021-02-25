<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
	<th>아이디</th><th>이름</th><th>이메일</th><th>수정</th><th>삭제</th>
	</tr>
<c:forEach var="member" items="${memberList }">
	<tr>
	<td><a href="memberView.do?id=${member.id }">${member.id }</a></td>
	<td>${member.name }</td>
	<td>${member.email }</td>
	<td><a href="memberView.do?id=${member.id }">수정</a></td>
	<td><a href="memberDel.do?id=${member.id }">삭제</a></td>
	</tr>
</c:forEach>
</table>
<br />
<fieldset>
<legend>회원 추가</legend>
<form action="memberInsert.do" method="post">
	아이디 : <input type="text" name="id"/><br />
	비밀번호 : <input type="password" name="passwd" /><br />
	이름 : <input type="test" name="name" /><br />
	이메일 : <input type="email" name="email"/><br />
	성별 : <input type="radio" name="gender" value="F"/> 여
		<input type="radio" name="gender" value="M" /> 남 <br />
	나이 : <input type="text" name="age" /><br />
	연락처 : <input type="text" name="phone" /><br />
	주소 : <input type="text" name="address" /><br />
	<input type="submit" value="등록" />
</form>
</fieldset>
</body>
</html>