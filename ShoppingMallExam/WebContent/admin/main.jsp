<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="admin/css/admin.css" />
<script>
	function worker_check(){
		if(document.frm.workId.value==""){
			alert("아이디를 입력하세요.");
			return false;
		}else if(document.frm.workPwd.value==""){
			alert("비밀번호를 입력하세요.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div id="wrap">
		<header>
		<div id="logo">
			<a href="../admin/main.jsp">
				<img src="admin/images/bar_01.gif" style="float:left"/>
				<img src="admin/images/text.gif"/>
			</a>
		</div>
		</header>
		<div class="clear"></div>
		<article>
			<div id="loginform">
				<form action="CSCServlet?command=admin_login" name="frm" method="post">
					<table>
						<tr>
							<td>아이디</td>
							<td>
							<input type="text" name="workerId" size="10" value="admin"/>
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td>
							<input type="password" name="workerPwd" size="10" value="admin"/>
							</td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<input type="submit" value="업무 로그인" class="btn"
								onclick="return worker_check()" /><br><br>
								<h4 style="color:red">${message}</h4>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</article>
	</div>
</body>
</html>