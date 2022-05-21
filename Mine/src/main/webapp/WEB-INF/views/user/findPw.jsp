<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/join.css">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script
	src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<body>
	<div class="login-body">

		<section class="member-join">
			<div class="join-container">


				<form action="findPwCheck" method="post">


					<div class="header-area">
						<div class="logo">
							<h2>MINE</h2>
							<p class="text-info">비밀번호 찾기</p>
						</div>
					</div>
					<div class="login-form">
						<div class="form-set idInput"">
							<label for="memberId" class="j-form-label">아이디</label> <input
								type="text" name="userId" class="l-input" id="userId"	placeholder="아이디 입력(5~11자)" minlength="5" maxlength="11">
						</div>
						<div class="form-set emailInput">
							<label for="memberEmail" class="j-form-label">Email</label> <input
								type="text" name="userEmail" id="userEmail" class="l-input">
						</div>
						
						<div class="form-set authInput"  style="display:none; margin-bottom:10px;">
							<label for="authNumber" class="j-form-label">Auth</label> <input
								type="text" name="authNumber" id="authNumber" class="l-input">
						</div>
						<button type="button" onclick="authUpdate();" class="authSendBtn" style="display:none; padding: 10px 0; margin-top: 80px;">인증번호 전송</button>
						<button type="button" onclick="authCheck();" class="authBtn" style="display:none; padding: 10px 0; margin-top:15px;">인증번호 입력</button>
						
						<button type="button" onclick="findPwCheck();" class="findPwBtn" style="margin-top:57px; height: 50px;" >비밀번호 찾기</button>
					</div>



				</form>
			</div>

		</section>

	
	</div>
</body>
</html>