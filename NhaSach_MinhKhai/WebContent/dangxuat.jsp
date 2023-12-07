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
	session.setAttribute("quyen", (int)0);
	session.removeAttribute("dem");
	response.sendRedirect("sachcontroller");
	%>
</body>
</html>