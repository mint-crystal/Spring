<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>@RequestParam 사용</h3>
<form action="submitReport1.do" method="post" enctype="multipart/form-data">
	학번 : <input type="text" name="studentNumber" /><br />
	리포트파일 <input type="file" name="report" /><br />
	<input type="submit" />
</form>
<hr>

<h3>MultipartHttpServletRequest 사용</h3>
<form action="submitReport2.do" method="post" enctype="multipart/form-data">
	학번 : <input type="text" name="studentNumber" /><br />
	리포트파일 <input type="file" name="report" /><br />
	<input type="submit" />
</form>
<hr>

<h3>커맨드 객체 사용</h3>
<form action="submitReport3.do" method="post" enctype="multipart/form-data">
	학번 : <input type="text" name="studentNumber" /><br />
	리포트파일 <input type="file" name="report" /><br />
	<input type="submit" />
</form>
<hr>

<h3>파일 여러 개 받기(배열)</h3>
<form action="submitReport3.do" method="post" enctype="multipart/form-data">
	학번 : <input type="text" name="studentNumber" /><br />
	리포트파일(다중선택가능) <input type="file" name="report" multiple="multiple"/><br />
	<input type="submit" />
</form>
</body>
</html>