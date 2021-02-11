<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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


	<div class="container">
		<div
			class="border col-xl-6 col-xxl-6 col-md-12 col-sm-12 rounded py-3">
			<div class="mb-1 ml-1">
				<img
					src="https://img.icons8.com/plasticine/100/000000/reading-unicorn.png" />
			</div>
			<div class="row"></div>
			<form class="col-11">
				<div class="mb-3">
					<label for="productName" class="form-label">Product name</label> <input
						class="productName" type="text" placeholder="Enter product name" />
				</div>
				<div class="mb-3">
					<label for="productPrice" class="form-label">Product price</label>
					<input class="productPrice" type="text" placeholder="0.00" />
				</div>
				<div class="mb-3">
					<label for="productDescription" class="form-label">Description</label>
					<input class="productDescription" type="text"
						placeholder="Enter product description" />
				</div>
				<div class="row"></div>
				<button type="submit" class="btn btn-primary createProduct">Create
					product</button>
			</form>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script src="js/serverCalls.js"></script>

</body>
</html>