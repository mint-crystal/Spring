<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>상품 정보 수정</legend>
	<form action="goodsUpt.do" method="post">
		코드 : <input type="text" name="code" value="${goods.code}" readonly /> <br />
		이름 : <input type="text" name="name" value="${goods.name}"/> <br />
		가격 : <input type="text" name="price" value="${goods.price}"/> <br />
		색상 : <select name="color">
			<option value="" selected>색상선택</option>
			<option value="white" ${color=='black' ? 'selected':' '}>화이트</option>
			<option value="black" ${color=='white' ? 'selected':' '}>블랙</option>
			<option value="blue" ${color=='blue' ? 'selected':' '}>블루</option>
			<option value="red" ${color=='red' ? 'selected':' '}>레드</option>
			</select>
			<br />
			<input type="submit" value="수정" />
	</form>
</fieldset>
</body>
</html>