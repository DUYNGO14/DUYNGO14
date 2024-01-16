<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="css-jsp/dangnhap.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" sizes="16x16"  href="favicons/favicon-16x16.png">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="theme-color" content="#ffffff">
  </head>
  <body>
  <%-- <%
	String un = request.getParameter("usename");
	String pass = request.getParameter("password");
	if (un != null && pass != null) {
		if (un.equals("Ngoduy") && pass.equals("123")) {
			session.setAttribute("dn", un);
			response.sendRedirect("menu.jsp");
		} else {
			out.print("Sai mật khẩu hoặc tên đăng nhập");
		}
	}
	%> --%>
    <div class="center">
      <h1>Login</h1>
      <form class="form-inline " action="DangNhapController" method="post">
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
         	<select name="quyen"  class="form-select" aria-label="Disabled select example"  style="width: 100%">
         		<option selected value="null">Hãy chọn vai trò</option>
         		<option value="0">Khách hàng</option>
         		<option value="1">Admin</option>
         	</select>
        </div>
        <c:if test="${dem>=3}">
        <img alt="captcha" src="simpleCaptcha.jpg" width="150px" height="50px">
        <div class="txt_field">
          <input type="text" required name="answer">
          <span></span>
          <label>Captcha</label>
        </div>
        </c:if>
        <div class="pass">Forgot Password?</div>
        <c:if test="${kt!=null }">
        <p class="text-danger">Tên người dùng hoặc mật khẩu không đúng!</p>
        </c:if>
		<c:if test="${thieu!=null }">
		<p class="text-danger">Vui lòng nhập đầy đủ thông tin!</p>
		</c:if>
		<c:if test="${thieuquyen!=null}">
		<p class="text-danger">Vui lòng chọn vai trò!</p>
		</c:if>
			<div class="checkbox">
			<label><input type="checkbox"> Remember me</label>
		</div>
        <input type="submit" value="Login">
        <div class="signup_link">
        <a  href="HomeController">
         <button type="button" class="btn btn-sm btn-outline-info">Trang chủ</button> 
         </a>
         Not a member? <a href="DangKiController">Signup</a>
        </div>
      </form>
    </div>

  </body>
</html>
