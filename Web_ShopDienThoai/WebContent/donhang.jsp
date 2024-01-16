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
<title>Đơn hàng</title>
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
				<c:if test="${quyen==0}">
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
						
						<li class="nav-item "><a class="nav-link active text-white linkl" aria-current="page" href="donhangController">Đơn hàng</a></li>
						<li class="nav-item "><a class="nav-link active text-white linkl" aria-current="page" href="voucherController?vcb=vcb">Voucher</a></li>
						<!-- <li class="nav-item"><a class="nav-link text-white linkl" href="ThanhToanController">Thanh Toán</a></li> -->
						<li class="nav-item"><a class="nav-link text-white linkl" href="LichSuMuaHangController">Lịch sử mua hàng</a></li>
					</ul>
				</div>
				</c:if>
				<c:if test="${quyen==1}">
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
				</c:if>
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
              <img src="image/slider_3.png" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
              <img src="image/slider_2.png" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item ">
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
	<!-- cart -->
    <div class="main_index">
        <section class="bread-crum">
            <div class="container border-bottom border-danger mb-3">
                <div class="row pt-3">
                    <div class="col-12 a-left">
                        <ul class="breadcrumb">
                            <li class="home ">
                                <a class="text-decoration-none" href="HomeController"><span class="text-dark">Trang chủ</span></a>
                                <span class="mr_lr">&nbsp;/&nbsp;</span>
                            </li>
                            <li><a class="text-decoration-none" href="donhangController"><span  class="text-warning">Đơn hàng</span></a></li>
                        </ul>
                    </div>
                </div>
               </div>
        </section>
        <section class="title-cart border-bottom border-danger border-3">
            <div class="container">
                <div class="row pt-3">
                    <div class="col-12 a-left  mb-4 fs-4">
                        <strong>ĐƠN HÀNG CỦA BẠN</strong>
                    </div>
                </div>
           </div>
        </section>
        <c:if test="${dem==0}">
        <div class="mb-3">
        		<div style="font-size: 100px; color: red" align="center" ><i class="fa-brands fa-shopify"></i></div>		
				<div style="font-size: 20px; color: red" align="center">Không có đơn hàng nào!</div>
				<div align="center"><a href="HomeController"><button type="button" class="btn btn-danger" name="Mua thêm">Mua điện thoại ngay</button></a></div>
        </div>
        </c:if>
        <!-- test -->
        <c:if test="${dem!=0}">
        <section class="product-cart border-bottom border-danger border-3">
            <div class="container">
                <div class="row pt-3">
                <!-- <form action="#" method="post"> -->
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col col-md-4 ">Thông tin sản phẩm</th>
                            <th scope="col col-md-2">Đơn giá(vnđ)</th>
                            <th scope="col col-md-2">Số lượng mua</th>
                            <th scope="col col-md-2">Thành tiền(vnđ)</th>
                            <th scope="col col-md-2">Ngày đặt</th>
                            <th scope="col col-md-2">Hủy đơn</th>
                          </tr>
                        </thead>
                       
                        <tbody>
                        <c:forEach items="${dsdon}" var="o">
                          <tr>
                            <td class="row">
                                <div class="col-md-6">
                                    <img  src="${o.anh}" alt="Sap" style="width: 150px; height: 150px;">
                                </div>
                                <div class="col-md-6">
                                <h5>Tên:${o.tendt}</h5>
								<p>Dung lượng:${o.ram}/${o.dungluong}</p>
                                <p>Chip:${o.chip}</p>
                                <p>Dung lượng pin:${o.pin}</p>
								</div>
                            </td>
                            <td  ><div class="text-danger mt-5">${o.gia}vnđ</div></td>
                            <td>
                            	<div class="text-danger mt-5">${o.soluong} chiếc</div>
                            </td>
                            <td><div class="mt-5 text-danger">${o.gia * o.soluong}vnđ</div></td>
                            <td><div class="mt-5 text-danger">${o.ngaymua}</div></td>
                            <td>
                           		<a href="donhangController?madt=${o.madt}&mahoadon=${o.mahoadon}"><button type="button" class="btn btn-danger mt-5" data-bs-toggle="modal" data-bs-target="#exampleModal">HỦY ĐƠN</button></a> 
                            </td>
                          </tr>
                          </c:forEach>
                        </tbody>
                      </table>
                     <!-- </form> -->
                </div>
               </div>
        </section>
        </c:if>
        
    </div>
	
	<section class="myfooter bg-dark text-white py-4">
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <h3>Văn phòng giao dịch</h3>
          <ul class="list-group list-group-flush">
            <li class="list-group-item bg-dark"><a href="#" style="text-decoration: none;color:white;">Trang chủ</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Giới thiệu</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Sản phẩm</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Tin mới nhất</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Tuyển dụng</a>
            </li>
          </ul>
        </div>
        <div class="col-md-3">
          <h3>Liên hệ mua hàng</h3>
          <ul class="list-group list-group-flush">
            <li class="list-group-item bg-dark"><a href="#" style="text-decoration: none;color:white;">Trang chủ</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Giới thiệu</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Sản phẩm</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Tin mới nhất</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Tuyển dụng</a>
            </li>
          </ul>
        </div>
        <div class="col-md-3">
          <h3>Về chúng tôi</h3>
          <ul class="list-group list-group-flush">
            <li class="list-group-item bg-dark"><a href="#" style="text-decoration: none;color:white;">Trang chủ</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Giới thiệu</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Sản phẩm</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Tin mới nhất</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Tuyển dụng</a>
            </li>
          </ul>
        </div>
        <div class="col-md-3">
          <h3>Chính sách bán hàng</h3>
          <ul class="list-group list-group-flush">
            <li class="list-group-item bg-dark"><a href="#" style="text-decoration: none;color:white;">Trang chủ</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Giới thiệu</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Sản phẩm</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Tin mới nhất</a>
            </li>
            <li class="list-group-item bg-dark "><a href="#" style="text-decoration: none;color:white;">Tuyển dụng</a>
            </li>
          </ul>
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-md-6">
          <h3>THIÊN ĐƯỜNG MUA SẮM SHOPPING</h3>
          <p class="text-muted">
            Copyright@ 2021 Công ty cổ phần thương mại Ngo Duy<br>
            Chứng nhận ĐKKD số: 0388282938 do sở KH & ĐT TP.Huế cấp <br>
            Địa chỉ: Tòa nhà Ladeco Nguyễn Huệ, Huế <br>
            Điện thoại: 19006750 - Email: support@sapo.vn
          </p>
        </div>
        <div class="col-md-6">
          <h3>NHẬN TIN KHUYẾN MÃI</h3>
          <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Nhập email của bạn" aria-label="Nhập email của bạn"
              aria-describedby="basic-addon2">
            <a href="#" style="text-decoration: none;"><span class="input-group-text text-white bg-danger border-danger"
                id="basic-addon2">Đăng kí</span></a>
          </div>
          <div>
            <span class="box border border-white mr-3 text-primary bg-white">
              <i class="fa-brands fa-square-facebook "></i>
            </span>
            <span class="box border border-white mr-3 text-info bg-white">
              <i class="fa-brands fa-twitter"></i>
            </span>
            <span class="box border border-white mr-3 text-danger bg-white">
              <i class="fa-brands fa-instagram"></i>
            </span>
            <span class="box border border-white mr-3 text-danger bg-white">
              <i class="fa-brands fa-google"></i>
            </span>
          </div>
        </div>
      </div>
      <hr>
      <div class="row">
        <div class="col-md-6 text-muted mt-3">
          <span>Bản quyền thuộc</span>
        </div>
        <div class="col-md-6">
          <nav class="navbar navbar-expand-lg navbar-light bg-dark ">
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav ">
                <a class="nav-link active  text-muted" aria-current="page" href="menu.jsp">Trang chủ</a>
                <a class="nav-link text-muted" href="#">Giới thiệu</a>
                <a class="nav-link  text-muted" href="#">Liên hệ</a>
                <a class="nav-link  text-muted" href="#">Tin tức</a>
                <a class="nav-link  text-muted" href="#">Sản phẩm</a>
              </div>
            </div>
            </nav>
        </div> 
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