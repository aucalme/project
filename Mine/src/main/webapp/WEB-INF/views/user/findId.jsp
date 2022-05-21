<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/style2.css">
<title>Document</title>
</head>
<body>
	<div id="findId">
		<div class="block">
			<h1>아이디 찾기</h1>
			<c:if test="${null eq noMsg }">
				<p>고객님의 아이디는</p>
			</c:if>
			<ul>

				<c:forEach items="${list}" var="list">

					<li>${list.userId}</li>
					<br />

				</c:forEach>
				<c:if test="${null ne noMsg }">
					<li>${noMsg }</li>
				</c:if>
			</ul>
			<c:if test="${null eq noMsg }">
				<p>입니다</p>
			</c:if>
			<hr>
			<div style="position: absolute; bottom: 200px;">
				<a href="/mine/user/userLogin"> Login </a> <a href="/mine/"><small>메인페이지</small></a>
			</div>
		</div>
	</div>
</body>
</html>