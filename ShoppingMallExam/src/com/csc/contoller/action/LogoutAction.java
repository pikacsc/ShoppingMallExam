package com.csc.contoller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "CSCServlet?command=index";
		
		//현재 사용자 세션을 가지고 와서 false 널값을 체크할 수 있다.
		HttpSession session = request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
