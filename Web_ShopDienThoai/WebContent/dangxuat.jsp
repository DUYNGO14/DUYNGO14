<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%session.removeAttribute("dn");
	session.removeAttribute("gh");
	session.setAttribute("quyen", (long)0);
	session.setAttribute("dem", (int)0);
	response.sendRedirect("HomeController");
	%>
</body>
</html>