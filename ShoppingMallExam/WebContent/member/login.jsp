<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>

	<article>
		<h1>login</h1>
		<form action="CSCServlet?command=login" method="post">
			<fieldset>
			<legend></legend>
				<label>User ID</label>
				<input type="text" name="id" value="${id}" value="one" /><br>
				<label>Password</label>
				<input type="password" name="pwd" value="1111" /><br>
			</fieldset>
			<div class="clear"></div>
			<div id="buttons">
				<input type="submit" value="로그인" class="submit" />&nbsp;
				<input type="button" value="회원가입" class="cancel" onclick="location='CSCServlet?command=join_form'" />&nbsp;
				<input type="button" value="아이디 비밀번호 찾기" class="submit" onclick="location='CSCServlet?command=find_id_form'"/>
			</div>
		</form>
	</article>
<%@ include file="../footer.jsp" %>