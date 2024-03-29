<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Dangki</title>
    <link rel="stylesheet" href="css-jsp/dangnhap.css">
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
          Already have an account? <a href="DangNhapController">Login</a>
        </div>
      </form>
    </div>

  </body>
</html>
