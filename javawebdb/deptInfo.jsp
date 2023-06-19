<%--
JavaWebDB Lesson Chap01 Src04

部門情報表示画面。

ファイル名=deptInfo.jsp
ディレクトリ=/javawebdb
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="local.hal.night.javawebdb.*"%>
<%
	Dept dept = (Dept) request.getAttribute("dept");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>部門情報表示</title>
</head>
<body>
	<h1>Java Web-DB Lesson:部門情報表示</h1>
	<div>
		<dl>
			<dt>部門番号</dt>
			<dd><%=dept.getDeptno()%></dd>
			<dt>部門名</dt>
			<dd><%=dept.getDname()%></dd>
			<dt>所在地</dt>
			<dd><%=dept.getLoc()%></dd>
		</dl>
		<P>
			<a href="/javawebdb/selectDeptno.jsp">選択画面１に戻る</a><br> <a
				href="/javawebdb/showSelectDeptno2">選択画面２に戻る</a>
		</P>
	</div>
</body>
</html>
