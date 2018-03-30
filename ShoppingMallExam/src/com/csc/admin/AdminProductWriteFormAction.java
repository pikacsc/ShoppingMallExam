package com.csc.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csc.contoller.action.Action;

public class AdminProductWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상품등록 -> Admin~form ->상품등록.jsp
		String url = "admin/product/productWrite.jsp";
		
		String kindList[] = {"Heels","Boots","Sandals"
				,"Slipers","Sneakers","Sale"
		};
		
		request.setAttribute("kindList", kindList);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
