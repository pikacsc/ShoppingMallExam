package com.csc.contoller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.csc.dao.OrderDAO;
import com.csc.dto.MemberVO;
import com.csc.dto.OrderVO;

public class OrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderDetail.jsp";
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url="CSCServlet?command=login_form";
		} else {
			//주문번호를 찾고
			int oseq = Integer.parseInt(request.getParameter("oseq"));
			
			//주문DAO 객체 생성
			OrderDAO orderDAO = OrderDAO.getInstance();
			
			//DB에서 listOrderById 함수를 통해서 로그인 유저의 주문번호에 대한 리스트를 다 가져온다.
			ArrayList<OrderVO> orderList = 
					orderDAO.listOrderById(loginUser.getId(), "%", oseq);
			
			int totalPrice = 0;
			for(OrderVO ovo : orderList) {
				totalPrice+=ovo.getPrice2()*ovo.getQuantity();
			}
			
			request.setAttribute("orderDetail", orderList.get(0));
			request.setAttribute("orderList", orderList);
			request.setAttribute("totalPrice", totalPrice);
			System.out.println(orderList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
