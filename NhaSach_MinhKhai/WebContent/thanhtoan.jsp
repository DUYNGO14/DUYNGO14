<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css_jsp/style.css">
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
						<li class="nav-item"><a class="nav-link text-white linkl" href="giohangController">Giỏ hàng(<%=ghbo.ds.size()%>)</a></li>
						<%} else {%>
						<li class="nav-item"><a class="nav-link text-white linkl" href="giohangController">Giỏ hàng(0)</a></li>
						<%}%>
						<li class="nav-item"><a class="nav-link text-white linkl" href="thanhtoan.jsp">Thanh Toán</a></li>
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
							<a href="dangkiController" class="text-decoration-none pb"><strong class="text-white">Đăng kí</strong></a>
						</div>
						<div class="col-md mt-2">
							<a href="dangnhapController" class="text-decoration-none"><strong class="text-white">Đăng nhập</strong></a>
						</div>
					</div>
					<%}else{ %>
						<div class="col-md mt-2">
							<a href="#" class="text-decoration-none pb"><strong class="text-white">HI!<%=session.getAttribute("dn") %></strong></a>
						</div>
						<div class="col-md mt-2">
							<a href="dangxuat.jsp" class="text-decoration-none"><strong class="text-white">Đăng Xuất</strong></a>
						</div>
					<%} %>
					<!--  -->
				</div>
			</div>
		</div>
	</section>	<%
		String tien = request.getParameter("tt");
	%>
	<div class="container">

    <form action="">

        <div class="row">

            <div class="col">

                <h3 class="title">billing address</h3>

                <div class="inputBox">
                    <span>full name :</span>
                    <input type="text" placeholder="john deo">
                </div>
                <div class="inputBox">
                    <span>email :</span>
                    <input type="email" placeholder="example@example.com">
                </div>
                <div class="inputBox">
                    <span>address :</span>
                    <input type="text" placeholder="room - street - locality">
                </div>
                <div class="inputBox">
                    <span>city :</span>
                    <input type="text" placeholder="mumbai">
                </div>

                <div class="flex">
                    <div class="inputBox">
                        <span>state :</span>
                        <input type="text" placeholder="india">
                    </div>
                    <div class="inputBox">
                        <span>zip code :</span>
                        <input type="text" placeholder="123 456">
                    </div>
                </div>

            </div>

            <div class="col">

                <h3 class="title">payment</h3>

                <div class="inputBox">
                    <span>cards accepted :</span>
                    <img src="image/card_img.png" alt="">
                </div>
                <div class="inputBox">
                    <span>name on card :</span>
                    <input type="text" placeholder="mr. john deo">
                </div>
                <div class="inputBox">
                    <span>credit card number :</span>
                    <input type="number" placeholder="1111-2222-3333-4444">
                </div>
                <div class="inputBox">
                    <span>exp month :</span>
                    <input type="text" placeholder="january">
                </div>

                <div class="flex">
                    <div class="inputBox">
                        <span>exp year :</span>
                        <input type="number" placeholder="2022">
                    </div>
                    <div class="inputBox">
                        <span>CVV :</span>
                        <input type="text" placeholder="1234">
                    </div>
                </div>

            </div>
    
        </div>

        <input type="submit" value="Thanh toán <%=tien%>vnđ" class="submit-btn">

    </form>

</div>    
    
</body>
</html>