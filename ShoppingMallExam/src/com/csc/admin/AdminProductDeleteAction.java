package com.csc.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csc.contoller.action.Action;
import com.csc.dao.ProductDAO;

public class AdminProductDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseq = request.getParameter("pseq");
		
		ProductDAO productDAO = ProductDAO.getInstance();
		
		productDAO.deleteProduct(pseq);
		
		String url = "CSCServlet?command=admin_product_list";
		request.getRequestDispatcher(url).forward(request, response);;
	}

}
