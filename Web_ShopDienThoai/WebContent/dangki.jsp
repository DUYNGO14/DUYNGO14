<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Dangki</title>
    <link rel="stylesheet" href="css-jsp/dangnhap.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" sizes="16x16"  href="favicons/favicon-16x16.png">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="theme-color" content="#ffffff">
  </head>
  <body>
  <%
	String un = request.getParameter("usename");
	String pass = request.getParameter("password");
	if (un != null && pass != null) {
			session.setAttribute("dk", un);
			response.sendRedirect("menu.jsp");
	}
	%>
    <div class="center">
      <h1>Signup</h1>
      <form action="DangKiController" method="post">
        <div class="txt_field">
          <input type="text" required name="fullname">
          <span></span>
          <label>FullName</label>
        </div>
         <div class="txt_field">
          <input type="email" required name="email">
          <span></span>
          <label>Email</label>
        </div>
        <div class="txt_field">
          <input type="text" required name="txtun">
          <span></span>
          <label>Username</label>
        </div>
        <div class="txt_field">
          <input type="password" required name="txtpass">
          <span></span>
          <label>Password</label>
        </div>
        <div class="txt_field">
          <input type="password" required name="txtpass1">
          <span></span>
          <label>Repeat Password</label>
        </div>
        <c:if test="${kt!=null }">
        <p class="text-danger">Wrong!User name already exist!</p>
        </c:if>
        <c:if test="${ktt!=null }">
        <p class="text-danger">Repeated password does not match!</p>
        </c:if>
        <input type="submit" value="Signup">
        <div class="signup_link">
         <a  href="HomeController">
         <button type="button" class="btn btn-sm btn-outline-info">Trang chủ</button> 
         </a>
          Already have an account? <a href="DangNhapController">Login</a>
        </div>
      </form>
    </div>

  </body>
</html>
