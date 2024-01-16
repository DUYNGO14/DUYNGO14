<%@page import="dao.giohangdao"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css-jsp/style.css">
<link rel="stylesheet"
	href="/assets/owlcarousel/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="/assets/owlcarousel/assets/owl.theme.default.min.css">
<script src="/assets/vendors/jquery.min.js"></script>
<script src="/assets/owlcarousel/owl.carousel.js"></script>
<link rel="icon" type="image/png" sizes="16x16"  href="favicons/favicon-16x16.png">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="theme-color" content="#ffffff">
<title>Thống kê</title>
</head>
<body>
	<section class="header">
		<div class="container py-3">
			<div class="row">
				<div class="col-md-3 ">
					<a href="HomeController"> <img src="image/logo5.png"
						class="img-fluid " alt="Logo"></a>
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-3">
					<div class="input-group mt-2">
						<form class="d-flex" action="HomeController" method="post">
							<input class="form-control me-2"  value="${key}" name="txttk" type="text" placeholder="Search" aria-label="Search">
							<button class="btn btn-danger"  type="submit">Search</button>
						</form>
					</div>
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-3 ">
					<div class="row ">
					<!--  -->
					<%if(session.getAttribute("dn")==null){%>
						<div class="col-md">
							<div class="row">
								<div class="col-3">
									<div class="fs-3 text-danger">
										<i class="fa-solid fa-right-to-bracket"></i>
									</div>
								</div>
								<div class="col-9 mt-2">
									<a href="DangKiController" class="text-decoration-none pb"><strong class="text-danger">Đăng kí</strong></a>
								</div>
							</div>
						</div>
						<div class="col-md">
							<div class="row">
								<div class="col-3">
									<div class="fs-3 text-danger">
										<i class="fa-solid fa-right-to-bracket"></i>
									</div>
								</div>
								<div class="col-9 mt-2">
									 <a href="DangNhapController" class="text-decoration-none"><strong class="text-danger">Đăng nhập</strong></a>
								</div>
							</div>
						</div>
					</div>
					<%}else{ %>
						<div class="col-md">
							<div class="row">
								<div class="col-3">
									<div class="fs-3 text-danger">
										<i class="fa-solid fa-user"></i>
									</div>
								</div>
								<div class="col-9 mt-2">
									<a href="#" class="text-decoration-none pb"><strong class="text-danger">HI!<%=session.getAttribute("dn") %></strong></a>
								</div>
							</div>
						</div>
						<div class="col-md">
							<div class="row">
								<div class="col-3">
									<div class="fs-3 text-danger">
										<i class="fa-solid fa-right-to-bracket"></i>
									</div>
								</div>
								<div class="col-9 mt-2">
									 <a href="dangxuat.jsp" class="text-decoration-none"><strong class="text-danger">Đăng Xuất</strong></a>
								</div>
							</div>
						</div>
					</div>
					<%} %>
					<!--  -->
				</div>
			</div>
	</section>
	<!-- END HEADER -->
	<section class="mymainmenu bg-danger">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="dropdown navbar navbar-light bg-danger">
			            <a class="text-decoration-none text-white fs-5 mt-1 dropdown-toggle bg-danger border-0" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
			              <i class="fa-solid fa-layer-group"></i>
			              Danh mục sản phẩm
			            </a>
			            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
			            	<c:forEach items="${dsloai}" var="o">
			              		<li><a class="dropdown-item text-uppercase" href="HomeController?ml=${o.maloai}">${o.tenloai}</a></li>
			              	</c:forEach>
			            </ul>
			          </div>
				</div>
				<div class="col-md-9 ">
					<ul class="nav justify-content-end mt-2">
						<li class="nav-item "><a class="nav-link active text-white linkl" aria-current="page" href="HomeController">Trang chủ</a></li>
						<li class="nav-item"><a class="nav-link text-white linkl" href="khachhangcontroller">Khách hàng</a></li>
						<li class="nav-item"><a class="nav-link text-white linkl" href="xacnhandonhangController?xn2=chua">Xác nhận đơn hàng</a></li>
						<!-- <li class="nav-item"><a class="nav-link text-white linkl" href="themsanphamController">Thêm sản phẩm</a></li> -->
						<li class="nav-item dropdown ">
					          <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					            Thêm sản phẩm
					          </a>
					          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					            <li><a class="dropdown-item" href="themsanphamController?dt=dt">Thêm điện thoại mới</a></li>
					            <li><a class="dropdown-item" href="themsanphamController?hang=dt">Thêm hãng điện thoại</a></li>
					          </ul>
					     </li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<section class="mymaincontent my-3">
		<div class="container">
      <div class="slider mb-3">
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
              aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
              aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
              aria-label="Slide 3"></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="image/slider_1.webp" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
              <img src="image/slider_1.webp" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
              <img src="image/slider_1.webp" class="d-block w-100" alt="...">
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
          </div>
        </div>
      </div>
	</section>
	
</body>
</html>