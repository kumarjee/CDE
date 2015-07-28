<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2 align="center">Question Paper</h2>
 <div align="right" style="top:0 " >
  <%if(session.getAttribute("userName")!=null){ %>
    Welcome :<% out.print(session.getAttribute("userName"));%>
  <%} %>&nbsp;
  <a href="logout.thml" >LogOut</a> 
</div>
<br>
<form:form action="questionpaper.thml" >
 <table style="padding-left: 200px;" >

 <core:if test="${!empty questionPaperList}"> 
   <% int i=0; %>
   
   <core:forEach var="questionPaperCommand" items="${questionPaperList}" >
     <input type="hidden"  name="question" />   
     <input type="hidden" value="${questionPaperCommand.questionId}" name="quesNum[<%=i%>]" />   
     <tr height="30px;" valign="bottom">       
       <td style="font-weight: bold;">
          <core:out value="<%=i+1%>"></core:out>
          <core:out value="."></core:out>
          <core:out value="Question :"></core:out>
          <core:out value="${questionPaperCommand.question}"></core:out></td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option1Id}">
        <core:out value="${questionPaperCommand.option1}"></core:out>
       </td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option2Id}">
        <core:out value="${questionPaperCommand.option2}"></core:out>
       </td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option3Id}">
        <core:out value="${questionPaperCommand.option3}"></core:out>
       </td>
     </tr>
     <tr>
       <td>
        <input type="radio" name="option[<%=i%>]" value="${questionPaperCommand.option4Id}">
        <core:out value="${questionPaperCommand.option4}"></core:out>
       </td>
     </tr>
     <% i++; %>   
    </core:forEach>   
     
     <tr height="40px;">
       <td align="right"> 
         <input type="submit" value="Submit"  />
       </td>
     </tr>
  </core:if> 
  <core:if test="${empty questionPaperList}">
    <tr>
      <td>
       <core:out value="Not Avaliable Any Question"></core:out>
      </td> 
    </tr>
  </core:if>    
 </table>
</form:form>

</body>
</html>