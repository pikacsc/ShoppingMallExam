<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 체크</title>
<!-- <link href="CSS/subpage.css" rel="stylesheet"> -->
<style>
body{
	background-color: #B96DB5;
	font-family: Verdana;
}

#wrap{
	margin:0 20px;
}

h1{
	font-family:"Times New Roman", Times, serif;
	font-size:45px;
	color:#ccc;
	font-weight:normal;
}

input[type=button], input[type=submit]{
	float:right;
}
</style>
<script type="text/javascript">
	function idok(){
		opener.formm.id.value = "${id}";
		opener.formm.reid.value = "${id}";
		self.close();
	}
</script>

</head>
<body>
	<div id="wrap">
		<h1>ID 중복 확인</h1>
		<form action="CSCServlet?command=id_check_form" method="post" name="formm" style="margin-right:0;">
			User ID<input type="text" name="id" value="">
			<input type="submit" value="검색" class="submit"/><br>
			<div style="margin-top:20px;">
				<c:if test="${message==1}">
					<script type="text/javascript">
						opener.document.formm.id.value="";
					</script>
					${id }는 이미 사용중인 아이디 입니다.
				</c:if>
				<c:if test="${message==-1}">
						${id } 사용가능한 아이디 입니다.
						<input type="button" value="사용" class="cancel" onclick="idok()" />
				</c:if>	
			</div>	
		</form>
	</div>







</body>
</html>