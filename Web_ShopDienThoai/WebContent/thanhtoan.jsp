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
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
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
<link href="css-jsp/thanhtoan.css" rel="stylesheet"> 
<link rel="icon" type="image/png" sizes="16x16"  href="favicons/favicon-16x16.png">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="theme-color" content="#ffffff">
<title>Thanh toán</title>
</head>

<body>
	<section class="header">
		<div class="container py-3">
			<div class="row">
				<div class="col-md-3 ">
					<a href="HomeController"> <img src="image/logo5.png"
						class="img-fluid " alt="Logo"></a>
				</div>
				<div class="col-md-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Thanh tìm kiếm" aria-label="Thanh tìm kiếm" aria-describedby="basic-addon2">
						<!-- <span class="input-group-text btn btn-primary" id="basic-addon2"><i class="fa-solid fa-magnifying-glass"></i></span> -->
						<div class="btn-group" role="group" aria-label="Basic mixed styles example">
							<button type="button" class="btn btn-secondary">
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="row">
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
				<div class="col-md-2">
					<div class="row">
						<div class="col-4">
							<a type="#" class="position-relative"> 
							<span class="fs-3"><i class="fa-regular fa-heart"></i></span> 
							<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> 0 </span>
							</a>
						</div>
						<div class="col-4">
							<a type="#" class="position-relative"> <span class="fs-3"><i class="fa-solid fa-bag-shopping"></i></span> 
							<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> 0 </span>
							</a>
						</div>
						<div class="col-4">
							<a type="#" class="position-relative"> <span class="fs-3"><i class="fa-solid fa-shuffle"></i></span> 
							<span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">2 </span>
							</a>
						</div>
					</div>
				</div>
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
						<li class="nav-item"><a class="nav-link text-white linkl position-relative" href="GioHangController">
							<span>Giỏ hàng</span>
							 <%
								if (session.getAttribute("gh") != null) {
									giohangdao ghbo = (giohangdao) session.getAttribute("gh");
							%>
							 <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-white text-danger">
                                   <%=ghbo.ds.size()%>
                                   <%} %>
                               </span>
						</a></li>
						<!-- <li class="nav-item"><a class="nav-link text-white linkl" href="ThanhToanController">Thanh Toán</a></li> -->
						<li class="nav-item"><a class="nav-link text-white linkl" href="LichSuMuaHangController">Lịch sử mua hàng</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<div class="container_pay">

    <form action="XacNhanDatMuaController" method="post">

        <div class="row">

            <div class="col">

                <h3 class="title">billing address</h3>

                <div class="inputBox">
                    <span>full name :</span>
                    <input type="text" required placeholder="Họ và tên" name="txtname" value="${khachhang.hoten}">
                </div>
                <div class="inputBox">
                    <span>email :</span>
                    <input type="email" required value="${khachhang.email}" placeholder="example@example.com" name="txtemail">
                </div>
                <div class="inputBox">
                    <span>address :</span>
                    <input type="text" required value="${khachhang.diachi}" placeholder="room - street - locality" name="txtdiachi">
                </div>
                <div class="inputBox">
                    <span>Number phone :</span>
                    <input type="text" required value="${khachhang.sdt}" placeholder="01234567" name="txtsdt">
                </div>
            </div>
            <div class="col">
                <h3 class="title">payment</h3>

                <div class="inputBox">
                    <span>cards accepted :</span>
                    <img src="image/images.png" alt="" width="100%" height="100%" >
                </div>
                <div class="inputBox">
                    <span>name on card :</span>
                    <input type="text" required placeholder="mr. john deo" name="txtnamecard">
                </div>
                <div class="inputBox">
                    <span>credit card number :</span>
                    <input type="number" required placeholder="1111-2222-3333-4444" name="txtcard">
                </div>
                <div class="inputBox">
                    <span>exp month :</span>
                    <input type="text" required placeholder="january" name="txtexp">
                </div>
            </div>
        </div>
        <c:if test="${kt!=null}">
        <p class="fw-bold text-danger">Vui lòng nhập đầy đủ thông tin!</p>
        </c:if>
        <input type="submit" value="Thanh toán ${tong}" class="submit-btn">
    </form>
</body>
</html>