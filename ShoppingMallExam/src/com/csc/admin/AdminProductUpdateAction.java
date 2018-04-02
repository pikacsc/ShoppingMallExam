package com.csc.admin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.csc.contoller.action.Action;
import com.csc.dao.ProductDAO;
import com.csc.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminProductUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상품등록 -> 등록버튼 -> 등록액션 ->DBinsert ->상품list.jsp
				String url = "CSCServlet?command=admin_product_list";
				
				HttpSession session = request.getSession();
				
				int sizeLimit = 5 * 1024 * 1024;
				String savePath = "product_images";
				ServletContext context = session.getServletContext();
				String uploadFilePath = context.getRealPath(savePath);
				
				MultipartRequest multi = new MultipartRequest(request, // 1. 요청 객체
						uploadFilePath, //2.업로드 될 파일이 저장될 파일 경로명
						sizeLimit, //3. 업로드 될 파일의 최대 크기(5mb)
						"UTF-8",  //4. 인코딩 타입 지정
						new DefaultFileRenamePolicy()//5. 덮어쓰기를 방지 위한 부분	
						);	// 이 시점에 파일은 이미 저장이 되었다.
			
				ProductVO product = new ProductVO();
				product.setKind(multi.getParameter("kind"));
				product.setName(multi.getParameter("name"));
				product.setPrice1(Integer.parseInt(multi.getParameter("price1")));
				product.setPrice2(Integer.parseInt(multi.getParameter("price2")));
				product.setPrice3(Integer.parseInt(multi.getParameter("price3"))
						- Integer.parseInt(multi.getParameter("price1")));
				product.setContent(multi.getParameter("content"));
			
				if(multi.getFilesystemName("image")==null) {
					product.setImage(multi.getParameter("nonmakeImg"));
				} else {
					product.setImage(multi.getFilesystemName("image"));
				}
				
				ProductDAO productDAO = ProductDAO.getInstance();
				productDAO.updateProduct(product);
				
				response.sendRedirect(url);

	}

}
