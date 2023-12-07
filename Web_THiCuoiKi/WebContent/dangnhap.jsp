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
    <title>Login</title>
    <link rel="stylesheet" href="css-jsp/dangnhap.css">
  </head>
  <body>
  <%
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
	%>
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
		<div class="checkbox">
			<label><input type="checkbox"> Remember me</label>
		</div>
        <input type="submit" value="Login">
        <div class="signup_link">
          Not a member? <a href="DangKiController">Signup</a>
        </div>
      </form>
    </div>

  </body>
</html>
