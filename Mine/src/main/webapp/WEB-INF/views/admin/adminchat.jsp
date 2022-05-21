<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tonight -- 관리자페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
<script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/adminpage.css">
</head>
<body>
	<section class="adminpage-section">
		<div class="container adminpage-container">
			<div class="row">
				<!-- 어드민 사이드메뉴 영역 -->
				<div class="col-xs-2">
					<aside>
						<div>
							<div class="aside-menu-title">상품</div>
							<ul>
								<li class="adminpage-management-btn">상품관리</li>
							</ul>

							<div class="aside-menu-title">문의</div>
							<ul>
								<li>문의목록</li>
							</ul>
							<div class="aside-menu-title">실시간 상담</div>
							<ul>
								<li class="adminpage-chat-btn">채팅방 목록</li>
							</ul>
							<div class="aside-menu-title">계정메뉴</div>
							<ul>
								<li class="adminpage-logout-btn">로그아웃</li>
							</ul>
						</div>
					</aside>
				</div>
				<!-- 어드민 사이드메뉴 영역 끝-->

				<!-- 관리영역 시작-->


				<!-- 채팅관리-->
				<div class="col-xs-10">
					<!-- 채팅방 목록 영역-->
					<div class="row">
						<div class="col-xs-12">
							<table class = "table table-striped adminchat-chatlist">
								<thead>
									<tr>
										<th>채팅방번호</th>
										<th>채팅생성시각</th>
										<th>유저ID</th>
										<th>입장버튼</th>
									</tr>
								</thead>
								
								<tbody>
									<c:forEach var="room" items="${rooms }">
										<tr>
											<td>${room.roomId }</td>
											<td>${room.createDate }</td>
											<td>${room.name }</td>
											<td>
												<button type="button" class="btn btn-primary joinBtn" data-roomid="${room.roomId }">상담 참여</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- 채팅방 목록 끝-->

				</div>
				<!-- 채팅관리 끝-->






				<!-- 관리영역 끝-->
			</div>
		</div>
	</section>
	
	<script>
		$(".joinBtn").click(function() {
			var adminVO = "<c:out value='${sessionScope.adminVO}'/>"
			console.log(adminVO);
			if(false/*userVO == null*/) {
				alert("로그인 후 가능합니다");
				return;
			}
			var roomId = $(this).data("roomid")
			var pop = window.open("../chat/"+roomId,"pop","width=510,height=730, scrollbars=no, resizable=no")
		})
	
	</script>
	
	<script src="${pageContext.request.contextPath }/resources/js/adminpage.js"></script>
</body>
</html>