<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
<h1>상품 상세 보기</h1>
<form method="post" name="frm">
	<table id="list">
		<tr>
			<th>상품분류</th>
			<td colspan="5">${kind}</td>
		</tr>
		<tr>
			<th align="center">상품명</th>
			<td colspan="5">${productVO.name}</td>
		</tr>
		<tr>
			<th>원가[A]</th>
			<td width="60">${productVO.price1}</td>			
			<th>판매가[B]</th>
			<td width="60">${productVO.price2}</td>			
			<th>[B-A]</th>
			<td>${productVO.price3}</td>
		</tr>
		<tr>
			<th>상세설명</th>
			<td colspan="5">${productVO.content }</td>
		</tr>
		<tr>
			<th>상품이미지</th>
			<td colspan="5" align="center">
			<img src="product_images/${productVO.image}" width="200px" />
			</td>
		</tr>
	</table>
	<!-- [8] 수정버튼이 눌리면 상품 수정페이지로 이동하되 현재페이지와 상품 일련번호 값을 전달해준다.-->
	<input type="button" value="수정" class="btn" onclick="go_mod('${tpage}','${productVO.pseq}')"/>
	
	<!-- 삭제 버튼이 눌리면 현재페이지와 상품 일련번호 값을 전달해준다 -->
	<input type="button" value="삭제" class="btn" onclick="go_delete('${tpage}','${productVO.pseq}')"/>
	
	<!-- [9] 목록버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. -->
	<input type="button" value="목록" class="btn" onclick="go_list('${tpage}')"/>
</form>
</article>
<%@ include file="/admin/footer.jsp"%>