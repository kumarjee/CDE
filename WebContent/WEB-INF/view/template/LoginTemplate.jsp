<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Competency Development Enabler</title>
	<link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen, projection"></link>
	<link rel="stylesheet" href="/resources/css/print.css" type="text/css" media="print"></link>
	<!--[if IE]>
	<link rel="stylesheet" href="resources/css/ie.css" type="text/css" media="screen, projection">
	<![endif]-->
<style>
body{ margin-top:10px; margin-left:150px; margin-right:150px; margin-bottom: 10px;height: 100%}
/* .verticalLine {
    border-right: thin solid gray;
}
.horLine {
    border-top: thin solid gray;
    border-bottom: thin solid gray;
} */
a {text-decoration: none}
</style>
</head>
<body style="height: 100%; font-family: verdana; font-size: 12px;" >
	<div class="container" style="min-height: 95vh; display: block; background-color: #F8FBFC;">
		<!-- Header -->
		<div>
		<tiles:insertAttribute name="header" />
		<hr width="100%" />
		</div>
		
		<!-- Menu Page -->
		<div style="display: block; min-height: 67vh;">
		
		<!-- Body Page -->
		<div class="span-19 last">
			<tiles:insertAttribute name="body" />
		</div>
		
		</div>
		<div style="display: block;">
		<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>