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
<link rel="stylesheet" href="css-jsp/add.css">
<link rel="icon" type="image/png" sizes="16x16"  href="favicons/favicon-16x16.png">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="theme-color" content="#ffffff">
<title>Thêm sản phẩm</title>
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
	<section class="mymainmenu bg-danger mb-4">
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
	<!-- Điện thoại -->
	<c:if test="${themdt!=null or addt!=null or add!=null }">
	<section class="bread-crum">
            <div class="container border-bottom border-danger mb-3">
                <div class="row pt-3">
                    <div class="col-12 a-left">
                        <ul class="breadcrumb">
                            <li class="home ">
                                <a class="text-decoration-none" href="HomeController"><span class="text-dark">Trang chủ</span></a>
                                <span class="mr_lr">&nbsp;/&nbsp;</span>
                            </li>
                            <li><span  class="text-warning">Thêm điện thoại mới</span></li>
                        </ul>
                    </div>
                </div>
               </div>
        </section>
	<section class="form-add">
		<div class="container1">
	      <h1 class="form-title">THÊM SẢN PHẨM MỚI</h1>
	      <form action="themsanphamController" method="post">
	        <div class="main-user-info">
		      <div class="user-input-box">
		          <label for="email">Tên loại diện thoại</label>
		          <select name="maloai" id="disabledSelect" class="form-select">
				      <option>Chọn hãng điên thoại</option>
				      <c:forEach items="${dsloai}" var="o">
				      <option value="${o.maloai}">${o.tenloai}</option>
				      </c:forEach>
				   </select>
		      </div>
	          <div class="user-input-box">
	            <label >Mã điện thoại</label>
	            <input type="text" id="fullName" required name="madt" value="${madt}"  placeholder="Nhập mã điện thoại">
	          </div>
	          <div class="user-input-box">
	            <label >Tên điện thoại</label>
	            <input type="text" id="username" required name="tendt" value="${tendt}" placeholder="Nhập tên điện thoại">
	          </div>
	          <div class="user-input-box">
	            <label >Giá điện thoại</label>
	            <input type="number"  id="password" required name="gia" value="${gia}" placeholder="Nhập giá điện thoại">
	          </div>
	          <div class="user-input-box">
	            <label >Kích thước màn</label>
	            <input type="text"  name="kichthuocman" required value="${kichthuocman}" placeholder="Nhập kích thước màn"/>
	          </div>
	          <div class="user-input-box">
	            <label >Dung lượng pin</label>
	            <input type="number"  name="pin" required value="${pin}" placeholder="Nhập dung lượng pin"/>
	          </div>
	          <div class="user-input-box">
	            <label >Chip</label>
	            <input type="text"  name="chip" required value="${chip}" placeholder="Nhập loại chip"/>
	          </div>
	          <div class="user-input-box">
	            <label >Ram</label>
	            <input type="number"  name="ram" required value="${ram}" placeholder="Nhập dung lượng ram"/>
	          </div>
	          <div class="user-input-box">
	            <label >Dung lượng bộ nhớ</label>
	            <input type="number"  name="dungluong" required value="${dungluong}" placeholder="Nhập dung lượng bộ nhớ"/>
	          </div>
	          <div class="user-input-box">
	            <label >Số lượng</label>
	            <input type="number"  id="phoneNumber" required name="soluong" value="${soluong}" placeholder="Nhập số lượng">
	          </div>
	          <div class="user-input-box">
	            <label >Hình ảnh</label>
	            <input type="text" id="username" required name="hinhanh" value="${hinhanh}" placeholder="Nhập link hình ảnh">	          
	       	 </div>
	        </div>
	            <c:if test="${trung!=null}">
		        	<p class="text-dark text-uppercase">Trùng mã sách!Vui lòng chọn mã sách khác.</p>
		        </c:if>
		        <c:if test="${add!=null}">
		       		<p class="text-dark text-uppercase">Thêm sản phẩm thành công!</p>
		       	</c:if>
	          <div class="form-submit-btn">
		          <div class="d-grid gap-2">
					  <button class="btn btn-success" type="submit">Thêm sản phẩm</button>
				 </div>
	         </div>
	      </form>
	    </div>
	</section>
	</c:if>
	<!-- Hãng -->
	<c:if test="${hang!=null or addh!=null or dsloai2!=null or dsloai1!=null}">
	
	<section class="container ml-3">
			<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="themsanphamController?dsloai1=vc"><button type="button" class="btn btn-outline-danger btn-sm">Danh sách hãng điện thoại</button></a></li>
			    <li class="breadcrumb-item"><a href="themsanphamController?dsloai2=vc"><button type="button" class="btn btn-outline-danger btn-sm">Thêm hãng</button></a></li>
			  </ol>
			</nav>
	</section>
	<c:if test="${hang!=null or addh!=null or dsloai2!=null}">
	<section class="bread-crum">
            <div class="container border-bottom border-danger mb-3">
                <div class="row pt-3">
                    <div class="col-12 a-left">
                        <ul class="breadcrumb">
                            <li class="home ">
                                <a class="text-decoration-none" href="HomeController"><span class="text-dark">Trang chủ</span></a>
                                <span class="mr_lr">&nbsp;/&nbsp;</span>
                            </li>
                            <li><span  class="text-warning">Thêm hãng điện thoại mới</span></li>
                        </ul>
                    </div>
                </div>
               </div>
    </section>
	<section class="form-add"> 
	     <div class="container1">
	      <h1 class="form-title">THÊM HÃNG ĐIỆN THOẠI MỚI</h1>
	      <form action="themsanphamController" method="post">
	        <div class="main-user-info">
	          <div class="user-input-box">
	            <label >Mã hãng điện thoại</label>
	            <input type="text" id="fullName" required name="mahang" value="${mahang}"  placeholder="Nhập mã hãng">
	          </div>
	          <div class="user-input-box">
	            <label >Tên hãng điện thoại</label>
	            <input type="text" id="username" required name="tenloai" value="${tenloai}" placeholder="Nhập tên hãng điện thoại">
	          </div>
	        </div>
	          <c:if test="${trung!=null}">
		        	<p class="text-dark text-uppercase">Trùng mã sách!Vui lòng chọn mã sách khác.</p>
		        </c:if>
		        <c:if test="${hang1!=null}">
		       		<p class="text-dark text-uppercase">Thêm hãng mới thành công!</p>
		       	</c:if>
	          <div class="form-submit-btn">
		          <div class="d-grid gap-2">
					  <button class="btn btn-success" type="submit">Thêm hãng điện thoại mới</button>
				 </div>
	         </div>
	      </form>
	    </div>
	</section>
	</c:if>
	<c:if test="${dsloai1!=null}">
	<section class="bread-crum">
            <div class="container border-bottom border-danger mb-3">
                <div class="row pt-3">
                    <div class="col-12 a-left">
                        <ul class="breadcrumb">
                            <li class="home ">
                                <a class="text-decoration-none" href="HomeController"><span class="text-dark">Trang chủ</span></a>
                                <span class="mr_lr">&nbsp;/&nbsp;</span>
                            </li>
                            <li>
                            	<a  class="text-decoration-none"  href="themsanphamController?dsloai2=vc"><span  class="text-warning">Thêm hãng điện thoại mới</span></a>
                            	<span class="mr_lr">&nbsp;/&nbsp;</span>
                            </li>
                            <li><span  class="text-danger">Danh sách hãng điện thoại</span></li>
                        </ul>
                    </div>
                </div>
               </div>
    </section>
	<h2 class="text-center">Danh sách hãng điện thoại</h2>
		<table class="table table-hover m-2">
              <thead>
                <tr>
                	<th scope="col col-md">Mã loại của hãng</th>
                  	<th scope="col col-md">Tên hãng điện thoại</th>
                 	<th scope="col col-md">Thao tác</th>
                </tr>
              </thead>
              <tbody>
             	<c:forEach items="${dsloai}" var="o">
                 <tr>
                 	<td><div class="my-2">${o.maloai}</div></td>
                    <td><div class="my-2">${o.tenloai}</div></td>
                   <td>
    	 	 			<a href="themsanphamController?dsloai1=vc&maloai1=${o.maloai}"><button id="liveToastBtn" type=""button"" class="btn btn-primary">Delete</button></a>
    	 	 			<a href="capnhatloaihangController?updateloai=vc&maloai2=${o.maloai}&tenloai2=${o.tenloai}"><button type="button" class="btn btn-primary">Update</button></a>
					</td>
                 </tr>
               </c:forEach>
              </tbody>
         </table>
	
	</c:if>
	</c:if>
	
	<!-- Voucher -->
	<c:if test="${vc!=null or voucher!=null or dsvou!=null}">
	
		<section class="container ml-3">
			<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="themsanphamController?ds=vc"><button type="button" class="btn btn-outline-danger btn-sm">Danh sách vorcher</button></a></li>
			    <li class="breadcrumb-item"><a href="themsanphamController?vc=vc"><button type="button" class="btn btn-outline-danger btn-sm">Thêm voucher</button></a></li>
			  </ol>
			</nav>
		</section>
		<c:if test="${dsvou!=null}">
		<section class="bread-crum">
            <div class="container border-bottom border-danger mb-3">
                <div class="row pt-3">
                    <div class="col-12 a-left">
                        <ul class="breadcrumb">
                            <li class="home ">
                                <a class="text-decoration-none" href="HomeController"><span class="text-dark">Trang chủ</span></a>
                                <span class="mr_lr">&nbsp;/&nbsp;</span>
                            </li>
                            <li><span  class="text-warning">Danh sách voucher</span></li>
                        </ul>
                    </div>
                </div>
               </div>
    </section>
		<h2 class="text-center">Danh sách voucher</h2>
		<table class="table table-hover m-2">
                        <thead>
                          <tr>
                          	<th scope="col col-md">Tên voucher</th>
                            <th scope="col col-md">Giá trị khuyến mãi</th>
                            <th scope="col col-md">Số lượng voucher</th>
                            <th scope="col col-md">Loại voucher</th>
                            <th scope="col col-md">Xóa voucher</th>
                          </tr>
                        </thead>
                        <tbody>
	                      	<c:forEach items="${dsvoucher}" var="o">
	                          <tr>
	                          	<td><div class="my-2">${o.tenvoucher}</div></td>
	                            <td><div class="my-2">${o.giatri} vnđ</div></td>
	                            <td><div class="my-2">${o.soluong}</div></td>
	                            <c:if test="${o.maloaivoucher==1}">
	                            <td><div class="my-2">Giảm giá sản phẩm</div></td>
	                            </c:if>
	                            <c:if test="${o.maloaivoucher==2}">
	                            <td><div class="my-2">Giảm phí vận chuyển</div></td>
	                            </c:if>
	                            <td>
              	 	 				<a href="themsanphamController?ds=vc&mavoucher=${o.mavoucher}"><button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">Delete</button></a>
                    			</td>
	                          </tr>
	                        </c:forEach>
                        </tbody>
                     </table>
		</c:if>
		<c:if test="${vc!=null or voucher!=null}">
		<section class="bread-crum">
            <div class="container border-bottom border-danger mb-3">
                <div class="row pt-3">
                    <div class="col-12 a-left">
                        <ul class="breadcrumb">
                            <li class="home ">
                                <a class="text-decoration-none" href="HomeController"><span class="text-dark">Trang chủ</span></a>
                                <span class="mr_lr">&nbsp;/&nbsp;</span>
                            </li>
                            <li><span  class="text-warning">Thêm voucher mới</span></li>
                        </ul>
                    </div>
                </div>
               </div>
    </section>
		<section class="form-add"> 
	     <div class="container1">
	      <h1 class="form-title">THÊM VOURCHER MỚI</h1>
	      <form action="themsanphamController" method="post">
	        <div class="main-user-info">
	          <div class="user-input-box">
		          <label for="email">Tên loại voucher</label>
		          <select name="maloaivoucher" id="disabledSelect" class="form-select">
				      <option>Chọn loại voucher</option>
				      <c:forEach items="${dsloaivoucher}" var="o">
				      <option value="${o.maloaivoucher}">${o.tenloaivoucher}</option>
				      </c:forEach>
				   </select>
		      </div>
	          <div class="user-input-box">
	            <label >Tên voucher</label>
	            <input type="text" id="fullName" required name="tenvoucher" value="${tenvoucher}"  placeholder="Nhập tên voucher">
	          </div>
	          <div class="user-input-box">
	            <label >Giá trị voucher<label>
	            <input type="number" id="username" required name="giatri" value="${giatri}" placeholder="Nhập giá trị voucher">
	          </div>
	          <div class="user-input-box">
	            <label >Số lượng voucher<label>
	            <input type="number" id="username" required name="soluongvc" value="${soluong}" placeholder="Nhập số lượng voucher">
	          </div>
	        </div>
	        	<c:if test="${thieu!=null}">
	        		<p class="text-dark text-uppercase">Vui lòng chọn loại voucher!</p>
	        	</c:if>
		       <c:if test="${voucher!=null}">
		       		<p class="text-dark text-uppercase">Thêm voucher mới thành công!</p>
		       	</c:if>
	          <div class="form-submit-btn">
		          <div class="d-grid gap-2">
					  <button class="btn btn-success" type="submit">Thêm voucher mới</button>
				 </div>
	         </div>
	      </form>
	    </div>
	</section>
	</c:if>
	</c:if>
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