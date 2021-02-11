function loginRegSwitch(){
	$('form').animate({
		height : "toggle",
		opacity : "toggle"
	}, "slow");
};

$('.message a').click(function(){
	loginRegSwitch();
	});
	
function showSuccess(){
	$('div.alert.alert-success').show();
};

$("button.register")
.click(
		function() {
			var firstName = $("form.register-form input.firstName").val();
			var lastName = $("form.register-form input.lastName").val();
			var email = $("form.register-form input.email").val();
			var password = $("form.register-form input.password").val();
			var cpassword = $("form.register-form input.cpassword")
					.val();

			if (firstName == '' || lastName == '' || email == ''
					|| password == '' || cpassword == '') {
				alert("Please fill all fields...!");
			} else if ((password.length) < 8) {
				alert("Password should at least 8 character in length...!!!!!!");
			} else if (!(password).match(cpassword)) {
				alert("Your passwords don't match. Try again?");
			} else {
				var userRegistration = {
					firstName : firstName,
					lastName : lastName,
					email : email,
					password : password
				};

				$.post("registration", userRegistration,
						function(data) {
							if (data == 'Success') {
								$("form")[0].reset();
								$("form")[1].reset();
								loginRegSwitch();	
								showSuccess();					
							}
						});
			}
		});
		
$("button.login").click(function() {
	let email = $("form.login-form input.login_email").val();
	let password = $("form.login-form input.login_pass").val();

	if (email == '' || password == '') {
		alert("Please fill login form!");
	} else {
		var userLogin = {
			email : email,
			password : password
		};

		$.post("login", userLogin, function(data) {
			if(data !== ''){
				var customUrl = '';
				var urlContent = window.location.href.split('/');
				for (var i = 0; i < urlContent.length-1; i++) {
					customUrl+=urlContent[i]+'/'
				}
				customUrl+=data.destinationUrl;
				window.location = customUrl;
			}
			$("form")[1].reset();
		});
	}
});