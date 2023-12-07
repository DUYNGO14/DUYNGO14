<%@page import="bo.giohangbo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css_jsp/dangnhap.css">
<title>Insert title here</title>

</head>
<body>
	
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<%--<li class="nav-item "><a class="nav-link active text-white linkl" aria-current="page" href="sachcontroller">Trang chủ</a></li>
				 <c:choose>
    				<c:when test="${sessionScope.gh != null}">
       					<c:set var="ghbo" scope="session" value="${sessionScope.gh}"/>
       					<c:set var="sl" value="${ghbo.ds.size()}" >
       					<li class="nav-item"><a class="nav-link text-white linkl" href="giohangController">Giỏ hàng(${sl})</a></li>
    					</c:set>
    				</c:when>    
    				<c:otherwise>
       					 <li class="nav-item"><a class="nav-link text-white linkl" href="giohangController">Giỏ hàng(0)</a></li>
    				</c:otherwise>
				</c:choose> --%>
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
      <h1>Login</h1>
      <form class="form-inline " action="dangnhapController" method="post" id="form">
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
        <c:if test="${dem==3}">
        <img alt="captcha" src="simpleCaptcha.jpg">
        <div class="txt_field">
          <input type="text" required name="answer">
          <span></span>
          <label>Captcha</label>
        </div>
        </c:if>
        <div class="txt_field">
         	<select name="quyen" class="form-select" aria-label="Disabled select example"  style="width: 100%">
         		<option selected>Hãy chọn vai trò</option>
         		<option value="0">Khách hàng</option>
         		<option value="1">Admin</option>
         	</select>
        </div>
        <div class="pass">Forgot Password?</div>
        <c:if test="${kt!=null }">
        <p class="text-danger">Wrong user or password!</p>
        </c:if>
<!-- 		<div class="checkbox">
			<label><input type="checkbox"> Remember me</label>
		</div> -->
		<!-- <div class="g-recaptcha" data-sitekey="6LdqBREpAAAAABsoZmOBq7iiq-SuFjYk7TbYcZKZ"></div>
		<div id="error"></div> -->
        <input type="submit" value="Login">
        <div class="signup_link">
          Not a member? <a href="dangkiController">Signup</a>
        </div>
        <!-- <script src="https://www.google.com/recaptcha/api.js" async defer></script>
		<script>
			window.onload = function (){
				let isValid = false;
				const form = document.getElementById("form");
				const error = document.getElementById("error");
				
				form.addEventListener("submit", function (event){
					event.preventDefault();
					const response = grecaptcha.getResponse();
					if (response){
						form.submit();
					} else {
						error.innerHTML = "Please check";
					}
				});
			}
		</script> -->
      </form>
    </div>
</body>
</html>