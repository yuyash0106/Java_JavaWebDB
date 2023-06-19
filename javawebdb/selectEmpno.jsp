<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="local.hal.night.javawebdb.*"%>
<%
	Map<Integer, Emp> empList = (Map<Integer, Emp>) request.getAttribute("empList");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="author" content="Yuya Ozaki">
<title>従業員番号選択</title>
</head>
<body>
	<h1>JavaWeb-DB Lesson:従業員番号選択</h1>

	<form action="/javawebdb/showEmpInfo" method="post">
		<div class="box">
			<select name="empno" required>
				<option value="" selected>選択してください</option>
				<%
					for (Map.Entry<Integer, Emp> element : empList.entrySet()) {
						Integer empno = element.getKey();
						Emp emp = element.getValue();
						String ename = emp.getEname();
				%>
				<option value="<%=empno%>"><%=empno%>:&nbsp;<%=ename%></option>
				<%
					}
				%>
			</select> <br>
			<button type="submit">表示</button>
		</div>
	</form>
</body>
</html>