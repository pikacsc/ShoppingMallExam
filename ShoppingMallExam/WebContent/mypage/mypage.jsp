<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>
	<article>
		<h2>My Page(${title})</h2>
		<form action="" method="post" name="formm">
			<table id="cartList">
			<tr>
				<th>주문일자</th>
				<th>주문번호</th>
				<th>상품명</th>
				<th>결제 금액</th>
				<th>주문 상세</th>
			</tr>
			<c:forEach items="${orderList}" var="orderVO">
				<tr>
					<td><fmt:formatDate value="${orderVO.indate}" type="date"/></td>
					<td>${orderVO.oseq}</td>
					<td>${orderVO.pname}</td>
					<td><fmt:formatNumber value="${orderVO.price2}" type="currency"/></td>
					<td><a href="CSCServlet?command=order_datail&oseq=${orderVO.oseq}">조회</a></td>
				</tr>
			</c:forEach>
			</table>
			<div class="clear"></div>
			<div id="buttons" style="float:right;">
				<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='CSCServlet?command=index'"/>
			</div>
		</form>
	</article>
<%@ include file="../footer.jsp"%>