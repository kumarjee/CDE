<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
    th {
     border-bottom: 1px solid grey !important;
    }
  </style>
</head>
<body>

<div align="right" style="top:0 " >
  <%if(session.getAttribute("adminName")!=null){ %>
    Welcome :<% out.print(session.getAttribute("adminName"));%>
  <%} %>&nbsp;
  <a href="logout.thml" >LogOut</a> 
</div> 

<br>
<br>
<core:if test="${!empty allQuestionList}">
<table style="display: block;" >
 <tr style="border-bottom: 3px;">
   <th width="30%" align="left">
     <core:out value="Language"></core:out>
   </th>
   <th width="30%" align="left">
     <core:out value="Question"></core:out>
    </th>
    <%-- <th>
      <core:out value="Answer1"></core:out>
    </th>
    <th>
      <core:out value="Answer12"></core:out>
    </th>
    <th>
      <core:out value="Answer3"></core:out>
    </th>
    <th>
      <core:out value="Answer4"></core:out>
    </th> --%>
    <th width="20%" align="left">  
      <core:out value="Right Answer"></core:out>
   </th>
   <th align="left">  
      <core:out value="Delete"></core:out>
   </th>
 </tr>
<core:forEach var="questionPaperCommand" items="${allQuestionList}" >
     <tr> 
       <td><core:out value="${questionPaperCommand.languageName}"></core:out></td>      
       <td  >
         <a href="addquestion.html?questionId=${questionPaperCommand.questionId}" >
             <core:out value="${questionPaperCommand.question}" ></core:out>
         </a>
       </td>
      <%--  <td><core:out value="${questionPaperCommand.option1}"></core:out></td>
       <td><core:out value="${questionPaperCommand.option2}"></core:out></td>
       <td><core:out value="${questionPaperCommand.option3}"></core:out></td>
       <td><core:out value="${questionPaperCommand.option4}"></core:out></td>  --%>
       <td>
           <core:out value="${questionPaperCommand.rightAnswer}"></core:out> 
       </td>
       <td>
         <a href="deletequestion.html?questionId=${questionPaperCommand.questionId}&languageId=${languageId}" >
             <core:out value="Delete"></core:out>
         </a>
       </td>                      
     </tr>
         
  </core:forEach>
</table>
</core:if>  
</body>
</html>