<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="local.hal.night.javawebdb.*"%>
<%
	Emp emp = (Emp) request.getAttribute("emp");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>従業員情報表示</title>
</head>
<body>
	<h1>Java Web-DB Lesson:従業員情報表示</h1>

	<div>
		<dl>
			<dt>従業員番号</dt>
			<dd><%=emp.getEmpno()%></dd>
			<dt>従業員名</dt>
			<dd><%=emp.getEname()%></dd>
			<dt>役職</dt>
			<dd><%=emp.getJob()%></dd>
			<dt>上司番号</dt>
			<dd><%=emp.getMgr()%></dd>
			<dt>雇用日</dt>
			<dd><%=emp.getHiredate()%></dd>
			<dt>給与</dt>
			<dd><%=emp.getSal()%></dd>
			<dt>歩合</dt>
			<dd><%=emp.getComm()%></dd>
			<dt>部門番号</dt>
			<dd><%=emp.getDeptno()%></dd>
		</dl>
		<P>
			<a href="/javawebdb/showSelectEmpno">従業員番号選択画面に戻る</a><br>
		</P>
	</div>
</body>
</html>