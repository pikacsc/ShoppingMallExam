<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CSC Admin</title>
<link rel="stylesheet" href="admin/css/admin.css" />
<script type="text/javascript" src="admin/product/product.js"></script>
</head>
<c:choose>
	<c:when test="${empty workerId}"><!-- 관리자 아이디 없으면 로그인 폼으로 돌아가라 -->
		<script type="text/javascript">
			location.href= 'CSCServlet?command=admin_login_form';
		</script>
	</c:when>
</c:choose>
<body onload="go_ab()">
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="CSCServlet?command=admin_login_form">
					<img src="admin/images/bar_01.gif" style="width:800px" />
					<img src="admin/images/text.gif" />
				</a>
			</div>
			<input type="button" value="logout" style="float:right;" class="btn"
			onclick="location.href='CSCServlet?command=admin_logout'" />
		</header>
	</div>
	<div class="clear"></div>
</body>
</html>