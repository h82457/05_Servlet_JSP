package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")

public class SignupServlet extends HttpServlet{

	// a태그 요청 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// forward - 요청에 따른 응답 화면이 존재
		String path = "/WEB-INF/views/redirect/signup.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	// 폼태그 제출 (POST)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어오기
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String pwCheck = req.getParameter("pwCheck");
		
		
		// pw, pwCheck가 일치하면 "(id) 회원 가입 성공" / 일치하지 않으면 "비밀번호 불일치"
		String message = null;
		
		if(pw.equals(pwCheck))	message = id + " 회원 가입 성공";
		else	message = "비밀번호 불일치";
		
//		req.setAttribute("message", message); <- 새로운 request에는 존재XXX)		
//								↘↘↘
		// redirect(재요청) 수행 -> 기존 요청이 담긴 request 객체 삭제 + 새로운 요청이 담긴 request 객체가 생성

//		[해결방법]
//		session 객체를 이용 <-브라우저 종료 또는 만료 전까지 유지된다
		
		// session 객체 얻어오기
		HttpSession session = req.getSession(); 
		
		// session에 메세지 추가
		session.setAttribute("message", message);
		
		// Servlet 코드 수행후 답할 화면이 별도로 존재X -> Redirect 사용
		resp.sendRedirect("/signup");
		
		// redirect <- 무조건 GET 방식 요청
		
	}
}
