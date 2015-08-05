<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Select Certification</h2>
<div align="right" style="top:0 " >
  <%if(session.getAttribute("adminName")!=null){ %>
    Welcome :<% out.print(session.getAttribute("adminName"));%>
  <%} %>&nbsp;
  <a href="logout.thml" >LogOut</a> 
</div>
<br>
<br>
 <form:form commandName="certification"   action="searchquestion.html" >
 <table style="padding-left: 100px;">
 <tr>
  <td>
   Select Certification:
  </td>
  <td>
    <form:select path="certificationId">
     <form:option label="--Select certification--" value="-1" />
     <form:options items="${certificationlist}" itemLabel="certificationName" itemValue="certificationId" />     	
    </form:select>  
  </td>
 </tr>
 <tr> 
  <td></td>
  <td><font color="red" ><core:out value="${errormessage}"></core:out></font></font> </td>  
 </tr> 
 <tr height="40px;"> 
  <td></td>
  <td><input type="submit" value="Submit"  /></td>  
 </tr> 
</table> 
 
</form:form>
 
</body>
</html>