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
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/join.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/footer.css">
<script src="https://kit.fontawesome.com/fd06a08b1d.js"
	crossorigin="anonymous"></script>
<title>myPage</title>
</head>
<body>
<body>
	<header>
		<div>
			<h1 class="logo">
				<a href="/mine/">MINE</a>
			</h1>
			<input type="text" id="search" name="search"> <a href="#"><i
				class="fa-solid fa-magnifying-glass"></i></a>

			<ul class="headlist">
				<li><a href="#">LOGOUT</a></li>
				<li><a href="#">MYPAGE</a></li>
				<li><a href="#">CART</a></li>
			</ul>
			<div class="menu">
				<ul class="productlist">
					<li><a href="#">TOP</a>
						<ul class="sublist">
							<li><a href="#">반팔 티셔츠</a></li>
							<li><a href="#">긴팔 티셔츠</a></li>
							<li><a href="#">민소매 티셔츠</a></li>
							<li><a href="#">셔츠/블라우스</a></li>
							<li><a href="#">피케/카라 티셔츠</a></li>
							<li><a href="#">맨투맨/스웨트셔츠</a></li>
							<li><a href="#">후드 티셔츠</a></li>
							<li><a href="#">니트/스웨터</a></li>
						</ul></li>
					<li><a href="#">PANTS</a>
						<ul class="sublist">
							<li><a href="#">데님 팬츠</a></li>
							<li><a href="#">코튼 팬츠</a></li>
							<li><a href="#">슈트 팬츠/슬랙스</a></li>
							<li><a href="#">트레이닝/조거팬츠</a></li>
							<li><a href="#">숏팬츠</a></li>
							<li><a href="#">레깅스</a></li>
							<li><a href="#">점프슈트</a></li>
							<li><a href="#">기타 바지</a></li>
						</ul></li>
					<li><a href="#">OUTER</a>
						<ul class="sublist">
							<li><a href="#">후드집업</a></li>
							<li><a href="#">블루종/MA-1</a></li>
							<li><a href="#">레더/라이더스 재킷</a></li>
							<li><a href="#">무스탕/퍼</a></li>
							<li><a href="#">슈트/블레이저 재킷</a></li>
							<li><a href="#">카디건</a></li>
							<li><a href="#">겨울 싱글 코트</a></li>
							<li><a href="#">겨울 더블 코트</a></li>
							<li><a href="#">겨울 기타 코트</a></li>
							<li><a href="#">롱패딩/롱헤비 아우터</a></li>
							<li><a href="#">숏패딩/숏헤비 아우터</a></li>
							<li><a href="#">헌팅 재킷</a></li>
						</ul></li>
					<li><a href="#">SHOES</a>
						<ul class="sublist">
							<li><a href="#">구두</a></li>
							<li><a href="#">로퍼</a></li>
							<li><a href="#">힐/펌프스</a></li>
							<li><a href="#">플랫 슈즈</a></li>
							<li><a href="#">블로퍼</a></li>
							<li><a href="#">샌들</a></li>
							<li><a href="#">슬리퍼</a></li>
							<li><a href="#">기타 신발</a></li>
							<li><a href="#">모카신/보트 슈즈</a></li>
							<li><a href="#">부츠</a></li>
						</ul></li>
					<li><a href="#">EVENT</a>
						<ul class="sublist">
							<li><a href="#">BENEFIT</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</header>
	<section>
		<div>
			<p class="mypage">
				SHOPPING BAG<br>
				<small>장바구니</small>
			</p>
		</div>
		<div class="cart">
			<h3>장바구니 상품</h3>
			<hr>
			<table>
				<thead>
					<tr>
						<th>선택</th>
						<th>사진</th>
						<th>상품정보</th>
						<th>수량</th>
						<th>가격</th>
						<th>배송비</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartList }" var="list">
						<form action="cartDelete">
							<input type="text" name="pno" value="${list.pno }" style="display: none;">
						<tr>
							<td><input type="checkbox" /></td>
							<td><div class="img"><img  src="../resources/product-img/${list.p_imgAddr }"></div></td>
							<td>${list.pName }</td>
							<td><input type="number" value="1">
							<button>변경</button></td>
							<td>${list.price }</td>
							<td>무료배송</td>
							<td><button>삭제</button></td>
						</tr>
						</form>
					</c:forEach>
				</tbody>
			</table>
			<p>* 쇼핑백에 담긴 상품은 30일간 보관됩니다</p>
			<button id="buybtn">선택상품 주문하기</button>
		</div>
	</section>
	<aside class="quick-area">
		<ul class="quick-list">
			<li><a href="#">최근 본 상품</a></li>
			<li><a href="#">
					<p>전화문의</p>
					<small>010-1111-2222</small>
			</a></li>
			<li><a href="#">
					<p>카카오톡</p>
					<small>1:1상담</small>
			</a></li>
			<li><a href="#">오시는길</a></li>
			<li><a href="#"><i class="fa-solid fa-circle-chevron-up"></i></a></li>
			<li><a href="#scrollbottom"><i
					class="fa-solid fa-circle-chevron-down"></i></a></li>
		</ul>
	</aside>
	<footer class="footer">
		<div>
			<ul class="footer-info">
				<li><a href="#">HOME</a></li>
				<li><a href="#">COMPANY</a></li>
				<li><a href="#">AGREEMENT</a></li>
				<li><a href="#">PRIVACY POLICY</a></li>
				<li><a href="#">GUIDE</a></li>
			</ul>
		</div>
		<div>
			<ul class="footer-info">
				<li><a href="#">게시판</a></li>
				<li><a href="#">공지사항</a></li>
				<li><a href="#">상품문의</a></li>
				<li><a href="#">취소/교환/반품</a></li>
				<li><a href="#">배송문의</a></li>
				<li><a href="#">상품후기</a></li>
				<li><a href="#">미확인입금자명단</a></li>
				<li><a href="#">VIP전용</a></li>
			</ul>
		</div>
		<div class="footer-info">
			<ul>
				<li>(주)유기농 대표 이진호</li>
				<li>전화 1544-1544</li>
				<li>팩스 02-1234-5678</li>
				<li>경기도 광명시 *** *** *** 건물 (202 1) (우)10000</li>
				<li>사업자등록번호 200-00-22222</li>
				<li>개인정보관리책임자 이진호</li>
				<li>제휴문의 uginongeasynong@uginong.com</li>
			</ul>
			<ul>
				<li>KB 400000-01-200000</li>
				<li>농협 300-0000-0000-00</li>
				<li>우리 1111-111-888888</li>
				<li>신한 111-111-111111</li>
				<li>예금주 : (주)유기농</li>
			</ul>
			<p>COPYRIGHT (C) ALL RIGHTS RESERVED.</p>
		</div>
		<div id="scrollbottom"></div>
	</footer>
</body>
<script>
	let msg="${msg}"
	if(msg!=""){
		alert(msg);
		msg="";
	}
</script>
</html>