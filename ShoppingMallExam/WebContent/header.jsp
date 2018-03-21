<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쇼핑몰</title>
<link rel="stylesheet" href="css/shopping.css" />
<script type="text/javascript" src="member/member.js"></script>
<script type="text/javascript" src="mypage/mypage.js"></script>
<script type="text/javascript" src="product/product.js"></script>
</head>
<body>
	<div id="wrap">
		<header>
			<!-- 로고 -->
			<div id="logo">
				<a href="CSCServlet?command=index">
					<img src="images/logo.gif" width="180" height="100" alt="cscshop" />
				</a>
			</div>
			<nav id="catagory_menu">
				<ul>
					<c:choose>
					<c:when test="${empty sessionScope.loginUser}">
						<li>
							<a href="CSCServlet?command=login_form" style="width:110px;">LOGIN(CUSTOMER)</a>
							<a href="CSCServlet?command=admin_login_form" style="width:100px;">|ADMIN)</a>
						</li>
						<li>/</li>
						<li><a href="CSCServlet?command=contract">JOIN</a></li>
					</c:when>
					<c:otherwise>
						<li style="color:orange">
							${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
						</li>
						<li><a href="CSCServlet?command=logout">LOGOUT</a></li>
					</c:otherwise>
					</c:choose>
						<li>/</li>
						<li>
							<a href="CSCServlet?command=cart_list">CART</a>
						</li><li>/</li>
						<li>
							<a href="CSCServlet?command=mypage">MY PAGE</a>
						</li><li>/</li>
						<li>
							<a href="CSCServlet?command=qna_list">Q&amp;A(1:1)</a>
						</li>
				</ul>
			</nav>
			
			<nav id="top_menu">
				<ul>
					<li>
						<a href="CSCServlet?command=catagory&kind=1">Heels</a>
					</li>
					<li>
						<a href="CSCServlet?command=catagory&kind=2">Boots</a>
					</li>
					<li>
						<a href="CSCServlet?command=catagory&kind=3">Sandals</a>
					</li>
					<li>
						<a href="CSCServlet?command=catagory&kind=4">Sneakers</a>
					</li>
					<li>
						<a href="CSCServlet?command=catagory&kind=5">On Sale</a>
					</li>
				</ul>
			</nav>
			<div class="clear"></div>
			<hr/>
		</header>
