package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/add")

public class TodoAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// TodoListService 참조 변수 선언
		TodoListService service = null;
		
		try {
			// 1. 전달 받은 파라미터 얻어와 변수에 저장
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			
			// 2. TodoService를 상속 받은 자식 객체 생성
			service = new TodoListServiceImpl();
			
			// 3. 할 일을 추가하는 Service 호출후 결과를 반환 받기
//					성공시 추가된 index / 실패시 -1 반환
			int index = service.todoAdd(title, detail);
			
			// 4. session을 이용해서 성공,실패 메시지 세팅하기
			String message = null;
			if(index != -1) message = "추가 성공 !!";
			else	message = "추가 실패 ..";
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			// 5. 메인 페이지로 redirect
			resp.sendRedirect("/"); // index.jsp --forward--> /main.jsp (main에서 파일을 다시 읽어와서 추가)
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
