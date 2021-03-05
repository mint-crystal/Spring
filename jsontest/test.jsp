<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"    src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function(){ //페이지가 로드되면 한 번만 실행
		
		// 1)서버쪽 컨트롤러로 값을 보내는 방법
		$('#test1').on('click', function(){
			$.ajax({
				url: 'test1.do',
				type: 'post',
				data: {name:"신사임당", age:47},
				success: function(result){ //()의 변수명은 다른 걸로 바꿔도 됨
					if(result=='ok'){
						alert('성공');
					}else{
						alert('전송 실패!');
					}
				},
				error: function(request, status, errorData){ 
					alert("error code: "+request.status+"\n"	// 오류 번호 나옴 ex)500 404
							+"message: "+request.responseText+"\n"	//오류 원인(기술 용어로 나옴)
							+"error: "+errorData);
				}
			});
		});
	
		// 2)컨트롤러에서 전송하는 응답 결과를 화면에 출력하는 방법
		$('#test2').on('click',function(){
			$.ajax({
				url: 'test2.do',
				type: 'post',
				dataType: 'json',
				success: function(data){
					$('#d2').html(
						"번호 : " + data.no +
						"<br>제목 : " + data.title + 
						"<br>작성자 : " + decodeURIComponent(data.writer) + //컨트롤러에서 인코딩했기때문에 디코딩 해줘야함 
						"<br>내용 : " + decodeURIComponent(data.content.replace(/\+/g, " ")) //+를 공백 처리하는 정규표현식 추가
					);
				},
				error: function(request, status, errorData){ 
					alert("error code: "+request.status+"\n"
							+"message: "+request.responseText+"\n"
							+"error: "+errorData);
				}
			});
		});
		
		// 3)컨트롤러에서 전송하는 객체 배열을 화면에 출력하는 방법
		$('#test3').on('click', function(){
			$.ajax({
				url: 'test3.do',
				type: 'post',
				dataType: 'json',
				success: function(data){
					// 전달받은 data를 JSON 문자열 형태로 바꾼다 
					var jsonStr = JSON.stringify(data);
					// 바꾼 문자열을 json 객체로 변환한다
					var json = JSON.parse(jsonStr);
					
					var values = $('#d3').html(); //d3 안에 html이 있으면 html값을 넣어줌
					values += "<ul>";
					for(var i in json.list){	//json.list = sendJson.put("list", jarr);
						//i에 json.list의 값을 하나씩 넣어줌(배열)
						values += '<li>'+json.list[i].userId+", "
										+json.list[i].userPwd+", "
										+decodeURIComponent(json.list[i].userName)+", "
										+json.list[i].age+", "
										+json.list[i].email +'</li>';
					}
					values += "</ul>"
					//values에 담은 값을 d3이라는 id의 div에서 출력
					$('#d3').html(values);
				},
				error: function(request, status, errorData){ 
					alert("error code: "+request.status+"\n"
							+"message: "+request.responseText+"\n"
							+"error: "+errorData);
				}
			});
		});
		
		// 4)컨트롤러에서 맵(Map) 객체를 리턴받아서 출력하는 방법
		$('#test4').on('click', function(){
			$.ajax({
				url: 'test4.do',
				type: 'post',
				success: function(data){
					$('#d4').html('받은 Map안의 sample 객체 정보 확인<br>'
								+'이름: '+decodeURIComponent(data.sample.name)
								+', 나이: '+data.sample.age);
				},
				error: function(request, status, errorData){ 
					alert("error code: "+request.status+"\n"
							+"message: "+request.responseText+"\n"
							+"error: "+errorData);
				}
			});
		});
		
		// 5)JSON 객체를 뷰에서 Controller로 보내는 방법
		$('#test5').on('click', function(){
			//자바스크립트에서 json 객체를 생성해 서버 컨트롤러로 전송한다
			var job = new Object();
			job.name = "홍길동";
			job.age = 33;
			
			$.ajax({
				url: "test5.do",
				data: JSON.stringify(job),
				type: 'post',
				contentType: "application/json; charset=utf-8",
				success: function(result){
					alert("전송 성공!");
					$('#d5').html("전송한 json객체의 값 : "+job.name+", "+job.age);
				},
				error: function(request, status, errorData){ 
					alert("error code: "+request.status+"\n"
							+"message: "+request.responseText+"\n"
							+"error: "+errorData);
				}
			});
		});
		
		// 6)JSON 배열을 뷰에서 Controller로 보내는 방법
		$('#test6').on('click',function(){
			//자바스크립트에서 jsonArray 객체를 만들어서, 서버 컨트롤러로 보내기
			var jArray = [{'name':"이 이", 'age':30},
						{'name':"신사임당", 'age':47},
						{'name':"황진이", 'age':25}];
			
			$.ajax({
				url: 'test6.do',
				data: JSON.stringify(jArray),
				type: 'post',
				contentType: "application/json; charset=utf-8",
				success: function(result){
					alert("전송 성공!");
					var values = $('#d6').html();
					for(var i in jArray){
						values += '이름: ' + jArray[i].name + ', 나이: ' + jArray[i].age+"<br>";
					}
					$('#d6').html(values);
				},
				error: function(request, status, errorData){ 
					alert("error code: "+request.status+"\n"
							+"message: "+request.responseText+"\n"
							+"error: "+errorData);
				}
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<input type="button" id="test1" value="ajax test1" />
<input type="button" id="test2" value="ajax test2" />
<input type="button" id="test3" value="ajax test3" />
<input type="button" id="test4" value="ajax test4" />
<input type="button" id="test5" value="ajax test5" />
<input type="button" id="test6" value="ajax test6" />
<div id="d2"></div>
<div id="d3"></div>
<div id="d4"></div>
<div id="d5"></div>
<div id="d6"></div>
</body>
</html>