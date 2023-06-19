<%--
JavaWebDB Lesson Chap02 Src02

部門番号選択画面２。

ファイル名=selectDeptno2.jsp
ディレクトリ=/javawebdb
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="local.hal.night.javawebdb.*"%>
<%
	Map<Integer, Dept> deptList = (Map<Integer, Dept>) request.getAttribute("deptList");
%>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>部門番号選択2</title>
</head>
<body>
	<h1>JavaWeb-DB Lesson:部門番号選択２</h1>
	<p>部門番号を選択し、表示ボタンをクリックしてください。</p>
	<form action="/javawebdb/showDeptInfo" method="post">
		<div class="box">
			<select name="deptno" required>
				<option value="" selected>選択してください</option>
				<%
					for (Map.Entry<Integer, Dept> element : deptList.entrySet()) {
						Integer deptno = element.getKey();
						Dept dept = element.getValue();
						String dname = dept.getDname();
				%>
				<option value="<%=deptno%>"><%=deptno%>:&nbsp;<%=dname%></option>
				<%
					}
				%>
			</select> <br>
			<button type="submit">表示</button>
		</div>
	</form>
</body>
</html>