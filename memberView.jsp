<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${member.name }
<fieldset>
<legend>회원 수정</legend>
<form action="memberUpdate.do?id=${member.id }" method="post">
	아이디 : ${member.id }<br />
	비밀번호 : <input type="password" name="passwd" /><br />
	이름 : ${member.name }<br />
	이메일 : <input type="email" name="email" value="${member.email }"/><br />
	성별 : ${member.gender }<br />
	나이 : ${member.age }<br />
	연락처 : <input type="text" name="phone" value="${member.phone }"/><br />
	주소 : <input type="text" name="address" value="${member.address }"/><br />
	<input type="submit" value="수정" />
</form>
</fieldset>
</body>
</html>