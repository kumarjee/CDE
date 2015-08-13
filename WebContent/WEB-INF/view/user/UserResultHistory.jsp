<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Result History of User</h2>
	<div align="right" style="top: 0">
		<%
			if (session.getAttribute("userName") != null) {
		%>
		Welcome :<%
			out.print(session.getAttribute("userName"));
		%>
		<%
			}
		%>&nbsp; <a href="logout.thml">LogOut</a>
	</div>
	<form:form action="UserResultHistory.html">
		<br>
		<table align="center" border="1" style="width: 50%">

			<tr style="font-weight: bold" align="center">
				<td>Language ID</td>
				<td>Exam Date</td>
				<td>Score</td>
				<td>Result</td>
			</tr>

			<core:forEach items="${results}" var="results">
				<tr>
					<td align="center"><core:out value="${results.languageId}" /></td>
					<td align="center"><core:out value="${results.examDate}" /></td>
					<td align="center"><core:out value="${results.score}" /></td>
					<td align="center"><core:out value="${results.result}" /></td>
				</tr>
			</core:forEach>

		</table>
	</form:form>

</body>
</html>