<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<article>
<h1>상품리스트</h1>
<form name="frm" method="post">
	<table>
		<tr>
			<td width="642">
			상풍명
			<input type="text" name="key" />
			<input type="button" value="검색" name="btn_search" class="btn" 
			onclick="go_search()" />
			<input type="button" value="전체보기" class="btn" name="btn_total" 
			onclick="go_total()"/>
			<input type="button" value="상품등록" class="btn" name="btn_wrtie"
			onclick="go_wrt()" />
			</td>
		</tr>
	</table>
	<table id="productList">
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>원가</th>
			<th>판매가</th>
			<th>등록일</th>
			<th>사용유무</th>
		</tr>
		<c:choose>
			<c:when test="${productListSize<=0}">
				<tr>
					<td width="100%" colspan="7" align="center" height="23">
					등록된 상품이 없습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${productList}" var="productVO">
					<tr>
						<td height="23" align="center">${productVO.pseq }</td>
						<td style="text-align: left; padding-left: 50px; padding-right: 0px;">
							<a href="#" onclick="go_detail('${tpage}', '${productVO.pseq}')">
							${productVO.name}
							</a>
						</td>
						<td>
							<fmt:formatNumber value="${productVO.price1}"/>
						</td>
						<td>
							<fmt:formatNumber value="${productVO.price2}"/>
						</td>
						<td>
							<fmt:formatDate value="${productVO.indate }"/>
						</td>
						<td>
							<c:choose>
								<c:when test='${productVO.useyn=="1"}'>미사용</c:when>
								<c:otherwise>사용</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan="6" style="text-align: center;">${paging }</td>
					</tr>
			</c:otherwise>
		</c:choose>
	</table>
</form>
</article>


<%@ include file="/admin/footer.jsp"%>
