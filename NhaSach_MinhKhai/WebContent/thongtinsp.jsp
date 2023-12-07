<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<link href="css_jsp/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<section class="mymainmenu bg-dark mb-4">
		<div class="container-fluid ">
			<div class="row">
				<div class="col-md-5 ">
					<ul class="nav justify-content-left mt-2">
						<li class="nav-item "><a class="nav-link active text-white linkl" aria-current="page" href="sachcontroller">Trang chủ</a></li>
						<%
						if (session.getAttribute("gh") != null) {
							giohangbo ghbo = (giohangbo) session.getAttribute("gh");
						%>
						<li class="nav-item"><a class="nav-link text-white linkl" href="giohangController">
						<i class="fa-solid fa-bag-shopping"></i>
						Giỏ hàng(<%=ghbo.ds.size()%>)</a></li>
						<%} else {%>
						<li class="nav-item"><a class="nav-link text-white linkl" href="giohangController">
						<i class="fa-solid fa-bag-shopping"></i>
						Giỏ hàng(0)</a></li>
						<%}%>
						<li class="nav-item"><a class="nav-link text-white linkl" href="thanhtoan.jsp">
						<i class="fa-brands fa-paypal"></i>
						Thanh Toán</a></li>
						<li class="nav-item"><a class="nav-link text-white linkl" href="lichsuController">Lịch sử mua hàng</a></li>
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
	<section class="bread-crum">
            <div class="container">
                <div class="row">
                    <div class="col-12 a-left">
                        <ul class="breadcrumb">
                            <li class="home ">
                                <a class="text-decoration-none" href="sachcontroller"><span class="text-dark">Trang chủ</span></a>
                                <span class="mr_lr">&nbsp;/&nbsp;</span>
                            </li>
                            <li><a class="text-decoration-none" href="#"><span  class="text-warning">Thông tin</span></a></li>
                        </ul>
                    </div>
                </div>
    </section>
	<div class="card mb-3 ml-4" style="max-width: 540px;">
		<div class="row g-0 ">
			<div class="col-md-5">
				<img src="${sach.anh}" class="img-fluid rounded-start ml-3 mt-5" alt="Ảnh sản phẩm">
			</div>
			<div class="col-md-7">
				<div class="card-body">
					<h5 class="card-title">Tên sách: ${sach.tensach}</h5>
					<h5 class="card-title">Tác giả: ${sach.tacgia}</h5>
					<h5 class="card-title">Giá sách: ${sach.gia}vnđ</h5>
					<h5 class="card-title">Số lượng sách còn trong kho: ${sach.soluong}</h5>
					<h5 class="card-title">Thông tin sách</h5>
					<p class="card-title">This is a wider card with supporting text
						below as a natural lead-in to additional content. This content is
						a little bit longer.</p>
					<a href="giohangController?ms=${sach.masach} &ts=${sach.tensach}&gia=${sach.gia}&tg=${sach.tacgia}&anh=${sach.anh}">
									<button type="button" class="btn btn-success"><i class="fa-solid fa-cart-plus"></i>Đặt hàng</button>
								</a>
					<p class="card-text">
						<small class="text-muted">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>