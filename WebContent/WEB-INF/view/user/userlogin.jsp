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
</div>
<br>
 <form:form commandName="user" action="userlogin.html" >
 <div>
 <table style="padding-left: 10px; margin-left: 275px; margin-top: 45px; background: url(<%=request.getContextPath()%>/resources/images/Login_Form3.png) no-repeat;" height="225px;" width="410px">
  <tr style="height: 70px;">
  	<td colspan="2">&nbsp;</td>
  	<td align="left" rowspan="6" valign="middle"><input type="submit" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" class="submitbutton" style="height: 70px; width: 70px;"/></td>
  </tr>
  
  <tr style="height: 30px;">
    <td align="right" width="125px;"><form:label path="userEmail"><font color="white" face="verdana" size="2.9">User Email:</font></form:label></td>
    <td>
     <form:input path="userEmail" size="20"/>     
    </td>
  </tr>
  <tr style="height: 15px;">
    <td></td>
    <td>
      <FONT color="red"><form:errors path="userEmail"></form:errors></FONT>
    </td>
  </tr>
  <tr style="height: 30px;">
    <td align="right"><form:label path="password"><font color="white" face="verdana" size="2.9">Password:</font></form:label></td>
    <td>
      <form:password path="password" size="20"/>      
    </td>
  </tr>
  <tr style="height: 15px;">
    <td></td>
    <td>
      <FONT color="red"><form:errors path="password"></form:errors></FONT>
    </td>
  </tr>
  <tr valign="top">
    <td></td>
    <td>
      <!-- <input type="submit" value="Login"/> --> 
      <font color="white" face="verdana" size="2.9">New User? <a href="userregistration.jsp"> Sign up</a></font>
    </td>
  </tr> 
 </table>
 </div>
 </form:form> 

</body>
</html>