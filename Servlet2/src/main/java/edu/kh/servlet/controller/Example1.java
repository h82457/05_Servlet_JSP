package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ex1")


/* 		[Servlet 작성 순서]
 * 
 * 1) HttpServlet 상속 받기
 * 2) @WebServlet() 어노테이선 작성
 * 3) doGet() 또는 doPost() 오버라이딩 -> 요청 method에 따라 수행
 * 4) 필요한 로직 처리 : 파라미터 얻어오기, 필요한 요청 처리 구문 작성
 * 5) 응답 형태 지정 + 응답 스트림 얻어오기
 * 6) 스트림을 통해서 응답 데이터(html 코드) 출력하기
 * 
 * 
 * */

public class Example1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String menu = req.getParameter("menu");
		String type = req.getParameter("type");
		String[] toppingList = req.getParameterValues("topping");
		String[] optionList = req.getParameterValues("opt");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		
		System.out.println("[서버] /ex1 요청됨");
		
		int price = 0;
		
		switch(menu) {
		
		case "치즈피자": price += 10000; break;
		case "고구마피자": price += 13000; break;
		case "포테이토피자": price += 15000; break;
		}
		
		switch(type) {
		case "일반도우": price += 0; break;
		case "씬도우": price += 1500; break;
		case "프리미엄도우": price += 2000; break;
		}
		
		if(!toppingList.equals(null)) {
			
			for(String t : toppingList) {
				
				switch(t) {
				case "치즈추가" : price += 1000; break;
				case "올리브추가" : price += 1500; break;
				case "토핑추가" : price += 2000; break;
				}
			}
		}
		
		if(!optionList.equals(null)) {
			
			for(String o : optionList) {
				
				switch(o) {
				case "콜라추가" : price += 2000; break;
				case "소스추가" : price += 1500; break;
				case "사이즈추가" : price += 10000; break;
				}
			}
		}
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("<!DOCTYPE html><html><title>%s님 주문 영수증</title><link rel=\"stylesheet\" href=\"index.css\"></head><body>", name));
		
		sb.append(String.format("<div>주문자명 : %s<div>", name));
		sb.append(String.format("<div>주소 : %s<div>", address));
		
		sb.append(String.format("<div>피자 선택 : %s<div>", menu));
		sb.append(String.format("<div>도우 선택 : %s<div>", type));
		
		if(toppingList != null) {
			
			sb.append("<div>토핑 선택 : ");
			
			for(String t : toppingList) sb.append(t + "   ");
				
			sb.append("</div>");

			}
		
		if(optionList != null) {
			
			sb.append("<div>기타옵션 : ");
			
			for(String o : optionList) sb.append(o + "   ");
					
				sb.append("</div>");
		}
		
		sb.append(String.format("<div>금액 : %s원<div>", price));
		
		sb.append("</body></html>");
			
		out.print(sb.toString());
		
	}
	
}
