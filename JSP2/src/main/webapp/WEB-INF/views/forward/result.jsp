<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 찾기 결과</title>
</head>
<body>
	<h1>${message}</h1>
	내장객체 우선순위 적용해서 request생략시에도 출력 가능
	(page -> request -> session ->application)

					↘↘↘ 같은 결과

	<h1>${requestScope.message}</h1>
	내장객체 정확하게 지정해서 request scope의 값을 얻어옴
</body>
</html>