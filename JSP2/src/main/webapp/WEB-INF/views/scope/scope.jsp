<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet/JSP 내장 객체와 범위</title>
</head>
<body>

	<h1>Servlet/JSP 내장 객체와 범위</h1>
	
	<ul>
		<% // pageContext == page scope 객체
			pageContext.setAttribute("pageMassage", "page scope 입니다.");
		%>
		
		<li>page socpe : ${pageMassage} </li>
		<li>request socpe : ${requestMessage} </li>
		<li>session socpe : ${sessionMessage} </li>
		<li>application socpe : ${applicationMessage} </li>
		
		<li>
				<a href="/scope/check">scope 확인하기</a>
		</li>
	</ul>
	
	<hr><hr>
	
	<h1>범위별 우선 순위 확인</h1>
	
	<pre>
		- \${key} 작성시 page -> request -> session -> application 순서로
		내장 객체를 탐색하여 일치하는 키가 있으면 해당 key의 value를 출력
	</pre>
	
	<% // page scope
		pageContext.setAttribute("str", "PAGE");
	%>
	
	<h2>${str}</h2>
	
	<hr>
	
	<h2> \${000scope.key}</h2>
	
	<pre>
		- 000 자리에는 각 scope 작성
		- 해당 scope에 존재하는 key를 찾아서 value 출력 (scope를 구분!)
	</pre>
	
	<h4>${pageScope.str}</h4>
	<h4>${requestScope.str}</h4>
	<h4>${sessionScope.str}</h4>
	<h4>${applicationScope.str}</h4>
</body>
</html>