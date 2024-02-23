<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
Servlet/JSP 프로젝트 실행시 "/" 주소로 요청이 오면 webapp 폴더에 있는
index.gtml 또는 index.jsp를 이용해 메인페이지 화면을 응답해준다." 

(무조건 "/" 요청은 index 파일과 연결이 된다)
-> Spring 에서는 해결됨
--%>

<!-- jsp 액션 태그 : jsp 에서 할수 있는 기능을 담은 태그 -->
<!-- "/" 요청이 들어온 경우 "/main" 요청을 처리하는 Servlet에게 요청 위임 -->
<jsp:forward page="/main"/>
