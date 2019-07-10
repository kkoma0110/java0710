<%@ page language="java"   pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form action="UserServlet.do?method=change" method="post">
			<input name="uid" type="hidden" value="${user.uid }">
			姓名：<input name="uname" value="${user.uname }"><br>
			生日：<input name="birthday" value="${user.birthday }"><br>
			存款：<input name="money" value="${user.money }"><br>
			
			<button type="submit">GO</button>
		</form>

</body>
</html>