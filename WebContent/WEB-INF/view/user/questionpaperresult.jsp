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
 <h2 align="center">Paper Result </h2>
<div align="right" style="top:0 " >
  <%if(session.getAttribute("userName")!=null){ %>
    Welcome :<% out.print(session.getAttribute("userName"));%>
  <%} %>&nbsp;
  <a href="logout.thml" >LogOut</a> 
</div>
 <br>
 <table align="center" >
   <% int i=0; %>
  <%-- <core:forEach var="questionPaperCommand" items="${questionPaperList}" >
     <tr>
       <td>
        <core:out value="<%=i+1%>"></core:out>
        <core:out value="."></core:out>
        <core:out value="Question :"></core:out>
        <core:out value="${questionPaperCommand.question}"></core:out></td>
     </tr>
     <tr> 
       <td>
         <font color="green" ><core:out value="Answer : "></core:out></font>
         <core:out value="${questionPaperCommand.option1}"></core:out>
      </tr>
     <% i++; %>        
  </core:forEach> --%>
  
  
 <%--  <tr>
  	<td></td>
    <td colspan="2" ><core:out value="--------------------------------------"></core:out></td>   
  </tr> --%>
  <%-- <tr>
    <td><core:out value="Result"></core:out></td>   
  </tr> --%>
  <tr>
  	<td rowspan="4"><img alt="Result" src="<%= request.getContextPath()%>/resources/images/Results.png"></td>
    <td colspan="2">
        <core:out value="Total Questions: "></core:out>
        <core:out value="${totalQuestion}"></core:out>
    </td>   
  </tr>
  <tr>
    <td colspan="2" >
        <core:out value="Percentage (%): "></core:out>
        <core:out value="${rightAnswer*100/totalQuestion}"></core:out>
    </td>   
  </tr>
  <tr>
    <td colspan="2" >
       <core:out value="Number of right answer : "></core:out>
       <core:out value="${rightAnswer}"></core:out>
   </td>   
  </tr>
  <tr>
    <td colspan="2" >
      <core:out value="Number of wrong answer : "></core:out>
      <core:out value="${wongAnswer}"></core:out>
    </td>   
  </tr>
</table>
</body>
</html>