var products = null;

$.get("products", function(data) {
	if (data !== '') {
		products = data;
	}
}).done(function() {

	var cardsContent = "";
	jQuery.each(products, function(i, value) {

		cardsContent += "<div class='col-3'>" +
			"<div class='card'>" +
			"<div class='card-body'>" +
			"<label for='card-title' class='form-label mb-0'>Product name</label>" +
			"<h5 class='card-title'>" + value.name + "</h5>" +
			"<label for='card-subtitle' class='form-label mb-3'>Price</label>" +
			"<h6 class='card-subtitle mb-2 text-muted'>$" + value.price + "</h6>" +
			"<label for='card-text' class='form-label mb-3'>Description</label>" +
			"<p class='card-text'>" + value.description + "</p>" +
			"<a href='product?id=" + value.id + "' class='card-link'>Open</a>" +
			"</div>" +
			"</div>" +
			"</div>" +
			"</div>"
	});

	$('#productCards').html(cardsContent);

});