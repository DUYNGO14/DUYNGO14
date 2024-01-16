<%@page import="bo.thongkebo"%>
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
<title>Trang chủ</title>
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
										<a href="dangxuat.jsp" class="text-decoration-none text-danger"><i class="fa-solid fa-right-to-bracket"></i></a>
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
				<c:if test="${quyen==0 or quyen==null}">
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
				</c:if>
			</div>
		</div>
	</section>
	<c:if test="${quyen==0 or quyen==null}">
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
	</c:if>
	<!-- Begin san pham -->
	
	<section class="mymaincontent my-3 mx-5"> 
	<img class="mx-auto" alt="" src="image/Dien_thoai.png" style="width: 100%;">
	<c:if test="${quyen==0 or quyen==null}">
		<div class="product-list mb-3">
	        <div class="product_title border-bottom">
	          <div class="col-md-3 mx-5 my-3">
	            <!-- <Strong class="bg-danger text-white p-2"><i class="fa-solid fa-mobile-screen-button"></i>  Điện thoại</Strong> -->
	            <a href="HomeController">
			     <button type="button" class="btn btn-danger">Tất cả sản phẩm</button>
			    </a>
	          </div>
	          <div class="col-md-6 ">
	          </div>
	        </div>
	    </div>
	    <div class="product-list-s py-3 mx-5 my-3">
	    	<div class="row row-cols-1 row-cols-md-3 g-4">
	    		<c:choose>
	    		<c:when test="${k==0}">
	    			<div class="col-md-4 mb-3"></div>
	    			<div class="col-md-4 mb-3">
						<div style="font-size: 100px; color: red" align="center" ><i class="fa-solid fa-mobile-screen"></i></div>		
						<div style="font-size: 20px; color: red" align="center">Không tìm thấy sản phẩm nào!</div>
	    			</div>
	    			<div class="col-md-4 mb-3"></div>
	    		</c:when>
	    		<c:otherwise>
		    		<c:forEach items="${dsdt}" var="o">
				    	<div class="col-12 col-md-6 col-lg-3 mb-4 ">
				    	  <p class="fw-lighter">Trả góp 0%</p>
			              <a href="ThongTinSanPhamConTroller?mdt=${o.madt}"><img class="anhdienthoai" src="${o.anh}" alt="nah" width="173px" height="225px"></a>
			              <h4 class="card-title show_txt" >
							 <a href="ThongTinSanPhamConTroller?mdt=${o.madt}" class=" text-decoration-none text-dark fs-6 " title="View Product">${o.tendt}</a>
						  </h4>
						  <div class="badge bg-secondary text-wrap" style="width: 3rem;">
							  ${o.kichthuocman}''
						  </div>
						  <div class="badge bg-secondary text-wrap" style="width: 3rem;">
							  ${o.dungluong}GB
						  </div>
			              <div class="row mt-2">
			                <div class="col-md-4 ">
			                 	<p class="text-danger fs-5 fw-bold">${o.gia}đ</p>
			                </div>
			                <div class="col-md-1 "></div>
			                <div class="col-md-2 ">
			                  <a href="GioHangController?mdt=${o.madt}&tendt=${o.tendt}&gia=${o.gia}&anh=${o.anh}&ktm=${o.kichthuocman}&pin=${o.pin}&dungluong=${o.dungluong}&ram=${o.ram}&chip=${o.chip}&maloai=${o.maloai}"><i class="fa-solid fa-cart-plus fs-4 text-danger"></i></a>
			                </div>
			              </div>
			              <c:if test="${o.soluong==0}">
			              <p class="fst-italic text-danger mb-2">Hết hàng!</p>
			              </c:if>
			              <p class="fst-italic mb-2">Đánh giá</p>
			              <c:forEach begin="1" end="5">
			              	<i class="fa-solid fa-star fs-6 text-warning"></i>
			              </c:forEach>
			            </div>
		            </c:forEach>
	            </c:otherwise>
	            </c:choose>
	    	</div>
	    </div>
	    </c:if>
	    <c:if test="${quyen==1}">
	    <c:choose>
	    		<c:when test="${k==0}">
	    		<div class="row">
	    			<div class="col-md-4 mb-3"></div>
	    			<div class="col-md-4 mb-3">
						<div style="font-size: 100px; color: red" align="center" ><i class="fa-solid fa-mobile-screen"></i></div>		
						<div style="font-size: 20px; color: red" align="center">Không tìm thấy sản phẩm nào!</div>
	    			</div>
	    			<div class="col-md-4 mb-3"></div>
	    		</div>
	    		</c:when>
	    <c:otherwise>
	    <div class="ml-3">
	     <button type="button" class="btn btn-sm btn-outline-primary" disabled>
	    	<div>Doanh thu : ${doanhthu}</div>
	     </button>
	     <button type="button" class="btn btn-sm btn-outline-danger" disabled>
	    	<div>Mặt hàng bán chạy: ${banchay}</div>
	     </button>
	     <a href="HomeController">
	     <button type="button" class="btn btn-sm btn-outline-danger">Tất cả</button>
	     </a>
	     </div>
    	 <table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">Ảnh sản phẩm</th>
			      <th scope="col">Thông tin sản phẩm</th>
			      <th scope="col">Giá</th>
			      <th scope="col">Số lượng còn</th>
			      <th scope="col">Xóa sản phẩm</th>
			      <th scope="col">Cập nhật</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach items="${dsdt}" var="o">
	            <tr>
              	 	<td><div class="mt-5"><a href="ThongTinSanPhamConTroller?mdt=${o.madt}"><img src="${o.anh}" alt="nah" width="100px" height="120px"></a></div></td>
              	 	<td>
              	 	  <div class="" style="font-size: 15px">
              	 	  	 <p>Tên sản phẩm:${o.tendt}</p>
					     <p>Kích thước màn:${o.kichthuocman}''</p>
					     <p>Dung lượng pin:${o.pin}mAh</p>
					     <p>Chip:${o.chip}</p>
					     <p>Ram:${o.ram}GB</p>
					     <p>Dung lượng lưu trữ:${o.dungluong}GB</p>
					  </div>
              	 	 	</td>
              	 	 	<td><div class="mt-5">${o.gia}vnđ</div></td>
              	 	 	<td>
              	 	 		<div class="mt-5">${o.soluong} chiếc
              	 	 		<c:if test="${o.soluong<5}"><p class="text-danger"> (Số lượng còn ít)</p> </c:if>
              	 	 		</div>
              	 	 	</td>
              	 	 	<td>
              	 	 		<a href="HomeController?madtdelete=${o.madt}"><button type="submit" class="btn btn-danger mt-5" data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</button></a>
                    	</td>
                    	<td>
                    		<a href="capnhatController?updatedienthoai=vc&madt=${o.madt}"><button type="submit" class="btn btn-danger mt-5" data-bs-toggle="modal" data-bs-target="#exampleModal">Update</button></a>
                    	</td>
              	 	 </tr>
	           </c:forEach>	     
			  </tbody>
		</table>
		</c:otherwise>
		</c:choose>
     </c:if>
	    <nav class="page" aria-label="Page navigation example pb-3">
		  <ul class="nav justify-content-center">
		    <c:forEach begin="1" end="${maxpage}" var="i">
		    <c:if test="${ml==null&&key==null}">
		    <li class="page-item"><a class="page-link"  href="HomeController?index=${i}">${i}</a></li>
		    </c:if>
		    <c:if test="${ml!=null}">
		    <li class="page-item"><a class="page-link"  href="HomeController?index1=${i}&ml1=${ml}">${i}</a></li>
		    </c:if>
		   <c:if test="${key!=null}">
		    <li class="page-item"><a class="page-link"  href="HomeController?index2=${i}&tk=${key}">${i}</a></li>
		    </c:if>
		    </c:forEach>
		  </ul>
		</nav>
	</section>
	

	<!-- End san pham -->
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