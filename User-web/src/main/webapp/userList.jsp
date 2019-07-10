<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		<table width="100%" border="1">
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>生日</th>
				<th>存款</th>
				<th>编辑</th>
				<th>删除</th>
			</tr>
			
			<c:forEach items="${userList }" var="u" varStatus="i">
				<tr>
					<th>${i.index+1 }</th>
					<th>${u.uname }</th>
					<th>${u.birthday }</th>
					<th>${u.money }</th>
					<th><a href="UserServlet.do?method=edit&uid=${u.uid }">编辑</a></th>
					<th><a href="UserServlet.do?method=delete&uid=${u.uid }">删除</a></th>
				</tr>
			
			</c:forEach>
			
		
		</table>
		
		<hr>
		
		<form action="UserServlet.do?method=addUser" method="post">
		
			姓名：<input name="uname"><br>
			生日：<input name="birthday"><br>
			存款：<input name="money"><br>
			
			<button type="submit">GO</button>
		</form>
		
</body>
</html>