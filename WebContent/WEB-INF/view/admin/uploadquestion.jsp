<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Upload Questions</title>
</head>
<body>
	<div align="right" style="top: 0">
		<%if(session.getAttribute("adminName")!=null){ %>
		Welcome :<% out.print(session.getAttribute("adminName"));%>
		<%} %>&nbsp; <a href="logout.thml">LogOut</a>
	</div>
	<form:form commandName="uploadQuestionForm" enctype="multipart/form-data" method="post">	
		<table>
			<tr>
				<td><img alt="Upload File" src="<%= request.getContextPath()%>/resources/images/File_Transfer.png" /></td>
				<td align="left"><b>File to upload: </b>				
				<input type="file" name="file"><br /><br /><br />  
				<input type="submit" value="Upload"> Press here to upload the file!</td>
			</tr>
		</table>
	</form:form>

</body>
</html>