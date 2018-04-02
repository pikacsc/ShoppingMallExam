<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp" %>
<%@ include file="/admin/sub_menu.jsp" %>
<script type="text/javascript">
	function go_list(){
		var theForm = document.frm;
		theForm.action="CSCServlet?command=admin_qna_list";
		theForm.submit();
	}
	
	function go_rep(qseq){
		var theForm = document.frm;
		theForm.qseq.value=qseq;
		theForm.action="CSCServlet?command=admin_qna_repsave";
		theForm.submit();
	}
</script>
<article>
	<h1>Q&amp;A 게시판 </h1>
	<form method="post" name="frm">
	<input type="hidden" name="qseq" />
	<table id="orderList">
	<tr>
		<th>제목</th>
		<td>${qnaVO.subject } ${qnaVO.rep }</td>		
	</tr>
	<tr>
		<th>등록일</th>
		<td><f:formatDate value="${qnaVO.indate }"/></td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td>${qnaVO.content }"</td>
	</tr>
	</table>
	<c:choose>
		<c:when test="${qnaVO.rep=='1'}">
			<table id="orderList">
				<tr>
					<td colspan="2">
						<img src="admin/images/opinionimg01.gif" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<textarea name="reply" cols="50" rows="3"></textarea>
					<input type="button" value="저장" class="btn" onClick="go_rep('${qnaVO.qseq }')"/>
					</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<table id="orderList">
				<tr>
					<th>댓글</th>
					<td>${qnaVO.reply }</td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
	<input type="button" value="목록" onClick="go_list()" class="btn" />
	</form>
</article>
<%@ include file="/admin/footer.jsp" %>