<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style2.css">
<title>Insert title here</title>
<script>
	var msg = "${msg}";
	if (msg != "") {
		alert(msg);
	}
</script>
</head>
<body>
	<div id="findId">
		<div class="block">
			<h1>아이디 찾기</h1>
			<p>이메일을 입력해주세요!</p>
			<form class="user" action="findId" method="post">

				<input type="email" id="userEmail" type="text"
					aria-describedby="emailHelp" name="userEmail"
					placeholder="Enter Email Address">

				<button type="submit">Find ID</button>
			</form>
			<hr>
			<a href="../user/userLogin"> Login </a> <a href="/mine"><small>메인페이지</small></a>

		</div>
	</div>
</body>
</html>