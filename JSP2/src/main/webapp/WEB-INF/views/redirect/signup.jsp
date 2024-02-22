<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect 확인</title>
</head>
<body>
	<!-- session 에 message가 존재하면 출력됨 -->
	<h3>${message}</h3>
	
	<%	// session에 존재하는 속성중 message를 제거
		session.removeAttribute("message");
		
	// redirection 시 데이터를 유지하기 위해 session을 이용했는데
	// 1회성으로 사용 불가능 -> 1회 출력후 session에서 제거
	
	%>
	
	
	
	<hr>
	<h1>회원가입</h1>
	
	<form action="/signup" method="POST">
		<div>ID : <input type="text" name="id"></div>
		<div>PW : <input type="password" name="pw"></div>
		<div>PW CHECK : <input type="password" name="pwCheck"></div>
	
		<button>회원가입</button>
	
	</form>
</body>
</html>