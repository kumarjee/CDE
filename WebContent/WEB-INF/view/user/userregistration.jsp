<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(document).ready(function(){
	$("input").on("keydown", function(){
		if($("span").length>0){
			$("span").remove();
		}
		
	});
});
</script>
</head>
<body>
 <h2 align="center" >User Registration</h2>
 <br>
 <form:form action="userregistration.html" commandName="userForm" >
  <table align="center" >
    <tr>
     <td>
       <form:label path="userName" >User Name:</form:label>
       <FONT color="red"><form:errors path="userName" /></FONT>
     </td>
    <tr>
    </tr> 
     <td>
       <form:input path="userName" size="26" />       
    </tr>
    <tr>
     <td>
      <form:label path="userEmail">User Email:</form:label>
      <FONT color="red"><form:errors path="userEmail" /></FONT>
     </td>
    <tr>
    </tr> 
     <td>
       <form:input path="userEmail" size="26" />
    </tr>
    <tr>
     <td>
      <form:label path="password">Password:</form:label>
      <FONT color="red"><form:errors path="password" /></FONT>
     </td>
    <tr>
    </tr> 
     <td>
       <form:password path="password" size="26" />
    </tr> 
    <tr>
     <td>
      <form:label path="confirmPassword">Confirm Password:</form:label>
     </td>
    <tr>
    </tr>  
     <td>
       <form:password path="confirmPassword" size="26" />
    </tr>
   <%--  </tr>    
     <td>
       <form:label path="userGender">Select Gender:</form:label>
       <FONT color="red"><form:errors path="userGender" /></FONT>
     </td>  
    </tr>
    </tr>    
     <td>
       <form:select path="userGender">
        <form:option label="--Select Gender--" value="-1" />
        <form:option label="Male" value="M" />
        <form:option label="Female" value="F" />     	
       </form:select>
     </td>  
    </tr>    --%>  
    <tr>
     <td>
      <form:label path="phoneNo">phone No:</form:label>
      <FONT color="red"><form:errors path="phoneNo" /></FONT>
     </td>
    <tr>
    </tr>  
     <td>
       <form:input path="phoneNo" size="26" />
    </tr>
    <tr>
     <td>
      <form:label path="address">Address:</form:label>
     </td>
   <tr>
   </tr>  
     <td>
       <form:textarea path="address" rows="5" ></form:textarea>
    </tr>       
    <tr>    
    <td>
      <input type="submit" value="Submit"/>     
    </td>
  </tr> 
  
</table>
</form:form>

</body>
</html>