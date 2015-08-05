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
<form:form commandName="addQuestionForm">
	<table style="padding-left: 100px; font-family: verdana; font-size: 12px;">
		<tr>
			<td><form:label path="certificationId">Select Certification :</form:label>
			<font color="red"> <form:errors path="certificationId"></form:errors>
			</font></td>
		</tr>
		<tr>
			<td><form:select path="certificationId" style="width:205px">
				<form:option label="--Select One--" value="-1" />
				<form:options items="${certificationlist}" itemLabel="certificationName"
					itemValue="certificationId" />
			</form:select></td>
		</tr>
		<tr>
			<td><form:label path="question">Enter Question :</form:label> <font
				color="red"> <form:errors path="question"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:textarea path="question" cols="23"></form:textarea></td>
		</tr>
		<tr>
			<td><form:label path="option1">Enter Answer1 :</form:label> <font
				color="red"> <form:errors path="option1"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="option1" size="30" /></td>
		</tr>
		<tr>
			<td><form:label path="option2">Enter Answer2 :</form:label> <font
				color="red"> <form:errors path="option2"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="option2" size="30" /></td>
		</tr>
		<tr>
			<td><form:label path="option3">Enter Answer3 :</form:label> <font
				color="red"> <form:errors path="option3"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="option3" size="30" /></td>
		</tr>
		<tr>
			<td><form:label path="option4">Enter Answer4 :</form:label> <font
				color="red"> <form:errors path="option4"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:input path="option4" size="30" /></td>
		</tr>
		<tr>
			<td><form:label path="rightOption">Right Answer :</form:label> <font
				color="red"> <form:errors path="rightOption"></form:errors> </font></td>
		</tr>
		<tr>
			<td><form:label path="rightOption">Answer1</form:label> <form:radiobutton
				path="rightOption" value="1" /> <form:label path="rightOption">Answer2</form:label>
			<form:radiobutton path="rightOption" value="2" /></td>
		</tr>
		<tr>
			<td><form:label path="rightOption">Answer3</form:label> <form:radiobutton
				path="rightOption" value="3" /> <form:label path="rightOption">Answer4</form:label>
			<form:radiobutton path="rightOption" value="4" /></td>
		</tr>
		<tr height="40px;">
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>

</body>
</html>