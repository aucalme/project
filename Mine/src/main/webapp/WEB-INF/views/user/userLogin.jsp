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
<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</head>
<body>
	<div class="login-body">

		<section class="member-join">
			<div class="join-container">


				<form action="userLogin" method="post">


					<div class="header-area">
						<div class="logo">
							<h2>MINE</h2>
							<p class="text-info">로그인</p>
						</div>
					</div>
					<div class="login-form">
						<div class="form-set">
							<label for="memberId" class="j-form-label">아이디</label> <input
								type="text" name="userId" class="l-input"
								placeholder="아이디 입력(5~11자)" minlength="5" maxlength="11">
						</div>
						<div class="form-set">
							<label for="memberName" class="j-form-label">비밀번호</label> <input
								type="password" name="userPw" class="l-input">
						</div>
						<div class="login-auto">
							<div class="auto-check">
								<input type="checkbox"> <label for="autoLogin"
									class="autoLoginBtn">자동로그인</label>
							</div>
							<div class="memberFind">
								<a href="findIdView"><span>아이디 찾기</span></a> <span>|</span> <a href="findPw"><span>비밀번호
										찾기</span></a>
							</div>
						</div>

						<button type="submit" class="join-submit">로그인</button>
					</div>
					<div>
						<input type="hidden" name="url" value="${url}" />
					</div>



				</form>
			</div>

		</section>

		<script>
			var msg = "${msg}";
			if (msg != "") {
				alert(msg);
			}
		</script>
	</div>
</body>
</html>