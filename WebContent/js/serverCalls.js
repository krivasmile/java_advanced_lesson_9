$("button.createProduct")
.click(
		function() {
			var name = $(".productName").val();
			var description = $(".productDescription").val();
			var price = $(".productPrice").val();

				var product = {
					name : name,
					description : description,
					price : price
				};

				$.post("product", product,
						function(data) {
							if (data == "Success") {
								alert("Success");
							}
						});
					});
					
$("button.buy-product").click(function() {
	var productId = jQuery(this).attr("product-id");
	
	$.post("bucket", {'productId': productId},
			function(data) {
				if (data == 'Success') {
					$('#buyProductModal').modal('hide');
					alert('Success');
				}
			});
});