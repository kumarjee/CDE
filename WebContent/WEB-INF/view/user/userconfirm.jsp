<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 .submitbutton
            {
            background: url(<%=request.getContextPath()%>/resources/images/Login_Button.jpg) no-repeat;
            cursor:pointer;
                        border: none;
            }
  .right {
    text-align: right;
    float: right;
    height: 64px;
    width: 60px;
}
</style>
</head>
<body>
<div>
<a href="<%=request.getContextPath()%>" class="right" style="background-image: url(<%= request.getContextPath()%>/resources/images/HomePage_Logo.png);">  </a>
</div><br>
<form:form commandName="user" action="userconfirm.html" >
<table>
<tr>
<td>
<h3>User Account activated....</h3>
</td>
</tr>
<tr>
<td>Please login Here</td>
<td>
      <!-- <input type="submit" value="Login"/> --> 
      <font color="white" face="verdana" size="2.9"> <a href="userlogin.jsp"><Input type="button" value = "Login"/></a></font>
    </td>
</tr>
</table>
</form:form>
</body>
</html>