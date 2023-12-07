<%@page import="bo.giohangbo"%>
<%@page import="java.awt.RenderingHints"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	/* giohangbo ghbo = (giohangbo)session.getAttribute("gh");
	String ms = request.getParameter("ms");
	String ms1= request.getParameter("ms1");
	String tru = request.getParameter("tru");
	String cong = request.getParameter("cong");
	String xoaall = request.getParameter("xoa");
	if(ms!=null){
		ghbo.Xoahang(ms);
	}
	if(xoaall!=null){
		session.removeAttribute("gh");
	}
	if(tru!=null){
		ghbo.tru(ms1);
	}
	if(cong!=null){
		ghbo.Cong(ms1);
	}
    String[] gt = request.getParameterValues("c1");
    if(gt!=null){
    	for(String c : gt){
    		ghbo.Xoahang(c);
    	}
    } */
    response.sendRedirect("giohang.jsp"); 
%>
</body>
</html>