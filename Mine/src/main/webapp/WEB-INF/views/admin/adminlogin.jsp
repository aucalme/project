<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>


<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
<script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/adminlogin.css">
<script
	src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
</head>
<script
	src="${pageContext.request.contextPath }/resources/js/adminlogin.js"></script>
<body>

	<section class="admin-login-form">
		<h1>MINE ADMIN</h1>
		<form action="adminSubmit" method="post">
			<div class="admin-int-area">
				<input type="text" name="adminId" id="adminId" autocomplete="off"
					required> <label for="id">ADMIN NAME</label>
			</div>
			<div class="admin-int-area">
				<input type="password" name="adminPw" id="adminPw"
					autocomplete="off" required> <label for="pw">ADMIN
					PASSWORD</label>
			</div>
				<div class="admin-int-area">
				<input type="text" name="auth" id="auth"
					autocomplete="off" required><label for="auth">Auth Num 
					</label>
			</div>
			
			<div class="admin-btn-area">
				<button type="button" onclick="authUpdate();" id="authBtn" class="authBtn">Get a verification </button>
			</div>
			
			<div class="admin-btn-area">
				<button type="submit" id="btn">LOGIN</button>
			</div>

		</form>



	</section>

	<script>
		let id = $("#adminId");
		let pw = $("#adminPw");
		let btn = $("#btn");

		$(btn).on('click', function() {
			if ($(id).val() == "") {
				$(id).next('label').addClass('warning');
				setTimeout(function() {
					$('label').removeClass('warning');
				}, 1500);
			} else if ($(pw).val() == "") {
				$(pw).next('label').addClass('warning');
				setTimeout(function() {
					$('label').removeClass('warning');
				}, 1500);
			}
		});
		
		var msg="${msg}";
		if(msg != ""){
			alert(msg);
		};
		
		console.log(msg);
		
		var message="${message}";
		
		if(message!=""){
			alert(message);
		}
		
	</script>

</body>
</html>