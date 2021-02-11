<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="d-flex justify-content-center container mt-5">
		<div class="card p-3 bg-white">
			<div class="about-product text-center mt-2">
				<img src="https://i.imgur.com/U80Uf70.jpg" width="300">
				<div>
					<h4>${product.name}</h4>
					<h6 class="mt-0 text-black-50">${product.description}</h6>
				</div>
			</div>
			<div class="stats mt-2">
				<div class="d-flex justify-content-between p-price">
					<span>Price</span><span>$${product.price}</span>
				</div>
			</div>
			<button type="button" class="btn btn-primary mt-5"
				data-toggle="modal" data-target="#buyProductModal">buy</button>
		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="buyProductModal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Are You sure that You want to buy this
					product?</div>
				<div class="modal-footer d-flex justify-content-center">
					<button type="button" product-id="${product.id}" class="btn btn-primary buy-product my-2">Buy</button>
				</div>
			</div>
		</div>
	</div>  

	<jsp:include page="footer.jsp"></jsp:include>

	<script src="js/serverCalls.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>  

</body>
</html>