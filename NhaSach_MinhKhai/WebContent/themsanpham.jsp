<%@page import="bo.giohangbo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="bean.Loaibean"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<!------ Include the above in your HEAD tag ---------->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css_jsp/add.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<section class="mymainmenu bg-dark mb-4">
		<div class="container-fluid ">
			<div class="row">
				<div class="col-md-5 ">
					<ul class="nav justify-content-left mt-2">
						<li class="nav-item "><a class="nav-link active text-white linkl" aria-current="page" href="sachcontroller">Trang chủ</a></li>
						<li class="nav-item"><a class="nav-link text-white linkl" href="adminxacnhancontroller">Xác nhận đơn</a></li>
						<li class="nav-item"><a class="nav-link text-white linkl" href="thongkekhachhangController">Khách hàng</a></li>
						<li class="nav-item"><a class="nav-link text-white linkl" href="themsanphamController">Thêm sản phẩm</a></li>
					</ul>
				</div>
				<div class="col-md-5">
					<div class="input-group mt-2">
						<form class="d-flex" action="sachcontroller" method="post">
							<input class="form-control me-2" name="txttk" type="text" placeholder="Search" aria-label="Search">
							<button class="btn btn-success" type="submit">Search</button>
						</form>
					</div>
				</div>

				<div class="col-md-2">
					<div class="row">
					<!--  -->
					<%if(session.getAttribute("dn")==null){%>
						<div class="col-md mt-2">
							<i class="fa-solid fa-right-to-bracket text-success"></i>
							<a href="dangkiController" class="text-decoration-none pb"><strong class="text-white">Đăng kí</strong></a>
						</div>
						<div class="col-md mt-2">
							<i class="fa-solid fa-right-to-bracket text-success"></i>
							<a href="dangnhapController" class="text-decoration-none"><strong class="text-white">Đăng nhập</strong></a>
						</div>
					</div>
					<%}else{ %>
						<div class="col-md mt-2">
							<i class="fa-solid fa-user text-success"></i>
							<a href="#" class="text-decoration-none pb"><strong class="text-white">HI!<%=session.getAttribute("dn") %></strong></a>
						</div>
						<div class="col-md mt-2">
							<i class="fa-solid fa-right-from-bracket text-success"></i>
							<a href="dangxuat.jsp" class="text-decoration-none"><strong class="text-white">Đăng Xuất</strong></a>
						</div>
					<%} %>
					<!--  -->
				</div>
			</div>
		</div>
	</section>
	<div class="container1">
      <h1 class="form-title">NHẬP THÊM SẢN PHẨM</h1>
      <form action="themsanphamController" method="post">
        <div class="main-user-info">
	      <div class="user-input-box">
	          <label for="email">Tên loại</label>
	          <select name="maloai" id="disabledSelect" class="form-select">
			      <option>Chọn loại sách</option>
			      <c:forEach items="${dsloai}" var="o">
			      <option value="${o.maloai}">${o.tenloai}</option>
			      </c:forEach>
			   </select>
	      </div>
          <div class="user-input-box">
            <label >Mã sách</label>
            <input type="text" id="fullName" name="masach" value="${masach}"  placeholder="Nhập mã sách">
          </div>
          <div class="user-input-box">
            <label >Tên sách</label>
            <input type="text" id="username" name="tensach" value="${tensach}" placeholder="Nhập tên sách">
          </div>
          <div class="user-input-box">
            <label >Tác giả</label>
            <input type="text"  name="tacgia" value="${tacgia}" placeholder="Nhập tác giả"/>
          </div>
          <div class="user-input-box">
            <label for="phoneNumber">Số lượng</label>
            <input type="number"  id="phoneNumber"  name="soluong" value="${soluong}" placeholder="Nhập số lượng">
          </div>
          <div class="user-input-box">
            <label for="password">Giá sách</label>
            <input type="number"  id="password"  name="giasach" value="${giasach}" placeholder="Nhập giá sách">
          </div>
          <div class="user-input-box">
            <label for="fullName">Số tập</label>
            <input type="number" id="fullName"  name="sotap" value="${sotap}" placeholder="Nhập số tập">
          </div>
          <div class="user-input-box">
            <label for="username">Hình ảnh</label>
            <input type="text" id="username" name="hinhanh" value="${hinhanh}" placeholder="Nhập link hình ảnh">
          </div>
        </div>
        <c:if test="${masach!=null}">
        	<p class="text-white text-uppercase">Trùng mã sách!Vui lòng chọn mã sách khác.</p>
        </c:if>
        <c:if test="${tc!=null}">
       		<p class="text-white text-uppercase">Thêm sản phẩm thành công!</p>
       	</c:if>
       	<c:if test="${th!=null}">
       		<p class="text-white text-uppercase">Vui lòng nhập đầy đủ thông tin!</p>
       	</c:if>
        <div class="form-submit-btn">
          <input type="submit" value="Thêm sản phẩm">
        </div>
        
      </form>
    </div>
</body>
</html>