package com.csc.contoller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.csc.dao.CartDAO;
import com.csc.dao.OrderDAO;
import com.csc.dto.CartVO;
import com.csc.dto.MemberVO;

public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "CSCServlet?command=order_list";
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(loginUser==null) {
			url = "CSCServlet?command=login_form";
		}else {
			CartDAO cartDAO = CartDAO.getInstance();
			ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getId());
			
			OrderDAO orderDAO = OrderDAO.getInstance();
			
			int maxOseq = orderDAO.insertOrder(cartList, loginUser.getId());
			url="CSCServlet?command=order_list&oseq="+maxOseq;
		}
		response.sendRedirect(url);
	}

}
