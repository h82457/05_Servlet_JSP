package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/el")
public class ELServlet extends HttpServlet {

	// a태그 요청 -> GET방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HttpServletRequest 객체에 여러 속성 추가
//			 - req.setAttribute("K", V);
//			 - 추가된 속성 값은 위임 받은 JSP에서 ${K} 형태로 작성-출력시 해당 위치에 V값 출력
		
		// 기본 자료형
		req.setAttribute("score", 90);;
		
		//String
		req.setAttribute("adress", "서울시 중구 남대문로 120");
		
		// 컬렉션 (List, Set, Map)
		List<String> strList = new ArrayList<String>();
		
		strList.add("collection");
		strList.add("List");
		strList.add("Set");
		strList.add("Map");
		
		req.setAttribute("strList", strList);
		
		// DTO
		Book book1 = new Book("나는 행복한 푸바오 할부지입니다", "강철원", 18000);
		req.setAttribute("book1", book1);
		
//		 ---------------------
		/* null, 빈칸, 비어있음에 대한 EL 처리 확인 */
		
		String test1 = null; //null
		String test2 = ""; // 빈칸
		List<String> test3 = null; // String 타입제한 리스트, null
		List<String> test4 = new ArrayList<String>(); // 비어있는 List
		List<String> test5 = new ArrayList<String>(); // 비어있지 않은 List
		
		test5.add("aaa");
		test5.add("bbb");
		
		req.setAttribute("test1", test1);
		req.setAttribute("test2", test2);
		req.setAttribute("test3", test3);
		req.setAttribute("test4", test4);
		req.setAttribute("test5", test5);
		
//		 ---------------------
		
		// forward : 요청 위임
//		Java에서 HTML 코드 편의성을 높이기 위해 JSP에 요청-> 응답객체 전송 - 대신 결과화면 생성+응답
		
		
		// 1) 요청 위임할 JSP 경로 지정
		String path = "/WEB-INF/views/el/el.jsp";
		
		// 2) 요청 발송자(RequestDispatcher) 생성
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// 3) 요청 위임
		dispatcher.forward(req, resp);
	}
}
