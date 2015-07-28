<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Test Application</title>
<style type="text/css">
#admin-logo {
    background-image:url(<%= request.getContextPath()%>/resources/images/Admin_Logo.png);
    display:block;
    height:150px;
    text-indent:-9999px;
    width:150px;
}

#user-logo {
    background-image:url(<%= request.getContextPath()%>/resources/images/User_Logo.png);
    display:block;
    height:150px;
    text-indent:-9999px;
    width:125px;
}
</style>
</head>
<body>
<%-- <li><a href="forms/user/userlogin.html" style="background-image: <%= request.getContextPath()%>/resources/images/Admin_Logo.png">&nbsp;</a></li>
<li><a href="forms/admin/adminlogin.html">admin login</a></li> --%>

<table style="padding-left: 275px; padding-top: 50px;">
	<tr>
		<td><a href="forms/admin/adminlogin.html" id="admin-logo">Admin Login</a></td>
		<td width="100px;"></td>
		<td><a href="forms/user/userlogin.html" id="user-logo">User Login</a></td>
	</tr>
</table>

</body>
</html>