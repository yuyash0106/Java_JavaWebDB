<%--
JavaWebDB Lesson Chsp01 Src02

部門番号選択画面１。

ファイル名=selectDeptno.jsp
ディレクトリ=/javawebdb
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>部門番号選択画面１</title>
<style type="text/css">
#errorMsg {
	border: solid 1px orange;
	color: red;
	padding: 10px;
	margin: 20px;
	width: 400px;
}
</style>
</head>
<body>
	<h1>Java Web-DB Lesson:部門番号選択画面１</h1>
	<P>部門番号を選択し、表示ボタンをクリックしてください。</P>
	<%
		String errorMsg = (String) request.getAttribute("errorMsg");
		if (errorMsg != null) {
	%>
	<p id="errorMsg">
		<%=errorMsg%>
	</p>
	<%
		}
	%>
	<form action="/javawebdb/showEmpInfo" method="post">
		<div class="box">
			<select name="deptno">
				<option value="-1" selected>選択してください</option>
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
			</select> <br>
			<Button type="submit">表示</Button>
		</div>
	</form>
</body>
</html>