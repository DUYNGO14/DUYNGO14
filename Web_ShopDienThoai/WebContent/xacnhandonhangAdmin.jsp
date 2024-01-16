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
<title>Xác nhận admin</title>
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
					            Thêm mới
					          </a>
					          <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					            <li><a class="dropdown-item" href="themsanphamController?dt=dt">Thêm điện thoại mới</a></li>
					            <li><a class="dropdown-item" href="themsanphamController?hang=dt">Thêm hãng điện thoại</a></li>
					            <li><a class="dropdown-item" href="themsanphamController?vc=vc">Thêm voucher</a></li>
					          </ul>
					     </li>
					     <li class="nav-item"><a class="nav-link text-white linkl" href="danhsachdanhgiaController">Đánh giá</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	
	
	<section class="bread-crum">
            <div class="container border-bottom border-danger mb-3">
                <div class="row pt-3">
                    <div class="col-12 a-left">
                        <ul class="breadcrumb">
                            <li class="home ">
                                <a class="text-decoration-none" href="HomeController"><span class="text-dark">Trang chủ</span></a>
                                <span class="mr_lr">&nbsp;/&nbsp;</span>
                            </li>
                            <li><span  class="text-warning">Xác nhận đơn hàng admin</span></li>
                        </ul>
                    </div>
                </div>
               </div>
        </section>
	<section class="container ml-3">
	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="xacnhandonhangController?xn1=roi"><button type="button" class="btn btn-outline-danger btn-sm">Đơn hàng đã xác nhận</button></a></li>
	    <li class="breadcrumb-item"><a href="xacnhandonhangController?xn2=chua"><button type="button" class="btn btn-outline-danger btn-sm">Đơn hàng chờ xác nhận</button></a></li>
	  </ol>
	</nav>
	</section>
	<section class="product-cart border-bottom border-danger border-3">
            <div class="container">
                <div class="row pt-3">
                	<c:if test="${xn2!=null}">
                	<h2 class="text-center">Danh sách đơn hàng cần xác nhận</h2>
                	<c:if test="${sodonxn==0}">
                	<div class="mb-3">
							<div style="font-size: 20px; color: red" align="center">Không có đơn hàng!</div>
			        </div>
                	</c:if>
                	<c:if test="${sodonxn!=0}">
                    <table class="table table-hover ">
                        <thead>
                          <tr>
                          	<th scope="col col-md-2 ">Tên khách hàng</th>
                            <th scope="col col-md-2 ">Tên điện thoai</th>
                            <th scope="col col-md-2">Đơn giá</th>
                            <th scope="col col-md-2">Số lượng mua</th>
                            <th scope="col col-md-2">Thành tiền</th>
                            <th scope="col col-md-2">Xác nhận đơn</th>
                          </tr>
                        </thead>
                        <tbody>
	                      	<c:forEach items="${dsxn}" var="o">
	                          <tr>
	                          	<td><div class="my-2">${o.hoten}</div></td>
	                            <td><div class="my-2">${o.tendt}</div></td>
	                            <td><div class="my-2">${o.gia}</div></td>
	                            <td><div class="my-2">${o.soluongmua}</div></td>
	                            <td><div class="my-2">${o.thanhtien}</div></td>
	                            <td><div class="my-2"><a class="text-decoration-none" href="xacnhandonhangController?mact=${o.machitiethd}&xn2=chua">Xác nhận</a></div></td>
	                          </tr>
	                        </c:forEach>
                        </tbody>
                     </table>
                     </c:if>
                     </c:if>
                     <c:if test="${xn1!=null}">

                     <h2 class="text-center">Danh sách đơn hàng đã xác nhận</h2>
                     <c:if test="${sodondxn==0}">
                     	<div class="mb-3">
							<div style="font-size: 20px; color: red" align="center">Chưa bán được đơn hàng!</div>
			        	</div>
                     </c:if>
                    <c:if test="${sodondxn!=0}">
                    <table class="table table-hover">
                        <thead>
                          <tr>
                          	<th scope="col col-md">Tên khách hàng</th>
                            <th scope="col col-md">Tên điện thoai</th>
                            <th scope="col col-md">Đơn giá</th>
                            <th scope="col col-md">Số lượng mua</th>
                            <th scope="col col-md">Thành tiền</th>
                          </tr>
                        </thead>
                        <tbody>
	                      	<c:forEach items="${dsdxn}" var="o">
	                          <tr>
	                          	<td><div class="my-3">${o.hoten}</div></td>
	                            <td><div class="my-3">${o.tendt}</div></td>
	                            <td><div class="my-3">${o.gia}</div></td>
	                            <td><div class="my-3">${o.soluongmua}</div></td>
	                            <td><div class="my-3">${o.thanhtien}</div></td>
	                          </tr>
	                        </c:forEach>
                        </tbody>
                     </table>
                     </c:if>
                     </c:if>
                </div>
        	</div>
        </section>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <script>
    $(document).ready(function () {
      $('.owl-carousel').owlCarousel({
        loop: true,
        margin: 10,
        nav: false,
        dots: false,
        responsiveClass: true,
        responsive: {
          0: {
            items: 4,
            // nav: true
          },
          600: {
            items: 6,
            // nav: false
          },
          1000: {
            items: 8,
            // nav: true,
            loop: false,
            margin: 20
          }
        }
      })
    })
  </script>
</body>
</html>