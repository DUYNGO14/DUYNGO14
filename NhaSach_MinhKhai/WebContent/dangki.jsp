<%@page import="bo.giohangbo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Dangki</title>
    <link rel="stylesheet" href="css_jsp/dangnhap.css">
  </head>
  <body>
  <nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="nav-item "><a class="nav-link active text-white linkl" aria-current="page" href="sachcontroller">Trang chủ</a></li>
				<%
				if (session.getAttribute("gh") != null) {
					giohangbo ghbo = (giohangbo) session.getAttribute("gh");
				%>
				<li class="nav-item"><a class="nav-link text-white linkl" href="giohangController">Giỏ hàng(<%=ghbo.ds.size()%>)</a></li>
				<%} else {%>
				<li class="nav-item"><a class="nav-link text-white linkl" href="giohangController">Giỏ hàng(0)</a></li>
				<%}%>
				<li class="nav-item"><a class="nav-link text-white linkl" href="thanhtoan.jsp">Thanh Toán</a></li>
				<li class="nav-item"><a class="nav-link text-white linkl" href="lichsuController">Lịch sử mua hàng</a></li>
			</ul>
		</div>
	</nav>
    <div class="center">
      <h1>Signup</h1>
      <form action="dangkiController" method="post">
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
          Already have an account? <a href="dangnhapController">Login</a>
        </div>
      </form>
    </div>

  </body>
</html>
