<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function(){
		$('#codeDup').on('click', function(){
			var codeStr = $('#code').val();
			
			$.ajax({
				url: 'goodsData.do',
				data: {'code':codeStr},
				dataType: 'json',
				success: function(data){
					if(data.codeDup=='dup'){
						alert('중복된 코드입니다.');
					}else{
						alert('사용가능한 코드입니다.');
					}
				},
				error: function(data){
					alert('전송 오류');
				}
			});
		});
	});
</script>
</head>
<body>
<fieldset>
	<legend>상품 등록</legend>
	<form action="goodsIns.do" method="post">
		코드 : <input type="text" name="code" id="code" /><input type="button" value="중복확인" id="codeDup" /> <br />
		이름 : <input type="text" name="name" /> <br />
		가격 : <input type="text" name="price" /> <br />
		색상 : <select name="color">
			<option value="" selected>색상선택</option>
			<option value="white">화이트</option>
			<option value="black">블랙</option>
			<option value="blue">블루</option>
			<option value="red">레드</option>
			</select>
			<br />
			<input type="submit" value="등록" />
	</form>
</fieldset>
</body>
</html>