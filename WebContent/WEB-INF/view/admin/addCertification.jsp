<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h2 {font-size:130%; color:#0B0B3B; font-weight:bold; font-family:verdana}

</style>
</head>
<body>
<div align="right" style="top: 0">
<%if(session.getAttribute("adminName")!=null){ %> Welcome :<% out.print(session.getAttribute("adminName"));%>
<%} %>&nbsp; <a href="logout.thml">LogOut</a></div>
<form:form commandName="certificationForm" action="addCertification.html" method="post">
	<table style="padding-left: 100px; font-family: verdana; font-size: 12px;">
		
		<tr>
			<td><form:label path="businessLine">Enter line of Business :</form:label> <font
				color="red"> <form:errors path="businessLine"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="businessLine" ></form:input></td>
		</tr>
		
		<tr>
			<td><form:label path="certificationName">Enter certification Name :</form:label> <font
				color="red"> <form:errors path="certificationName"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="certificationName" ></form:input></td>
		</tr>
		<tr>
			<td><form:label path="examPattern">Select ExamPattern :</form:label>
			<font color="red"> <form:errors path="examPattern"></form:errors>
			</font></td>
		</tr>
		<tr>
			<td><form:select path="examPattern" style="width:205px">
				<form:option  label="Multiple Choice" value="multipleChoice" disabled="true"/>
			</form:select></td>
		</tr>
		
		<tr height="40px;">
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>

</body>
</html>