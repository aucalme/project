<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>detail</title>


<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/detail.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css">
<script src="https://kit.fontawesome.com/fd06a08b1d.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<div>
			<h1 class="logo">
				<a href="../">MINE</a>
			</h1>
			<input type="text" id="search" name="search"> <a href="#"><i
				class="fa-solid fa-magnifying-glass"></i></a>

			<ul class="headlist">
				<c:if test="${empty loginUserId}">
					<li><a href="user/userLogin">LOGIN</a></li>
					<li><a href="user/userJoin">JOIN</a></li>
				</c:if>
				<c:if test="${not empty loginUserId}">
					<li><a href="user/logout">LOGOUT</a></li>
				</c:if>
				<li><a href="user/myPage">MYPAGE</a></li>
				<li><a href="user/cart">CART</a></li>
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


	<!-- detail -->
	<section class="detail-content">
		<div class="detail-top"></div>
		<div class="detail-container">
			<div class="detail-left">
				<div class="detail-category">
					<a href="#"><small>상의</small></a>><a href="#"><small>후드티셔츠</small></a>
				</div>
				<div class="detail-badge">한정 판매</div>
				<strong>${ProductVO.pName }</strong>
				<div class="detail-img-container">
					<div class="detail-bigImg">
						<img
							src="${pageContext.request.contextPath }/resources/product-img/${ProductVO.p_imgAddr }"
							alt="">
						<div class="detail-pno" style="display: none">${ProductVO.pno }</div>
					</div>
				</div>
				<div>
					<p class="detail-text">
						<strong>${ProductVO.pDetail}</strong>
					</p>
				</div>
				<div class="detail-size">
					<h2>size-info</h2>
					<span>사이즈정보</span>
					<div class="detail-size-content">
						<div>
							<a href="">구매내역 실측 선택</a>
						</div>
						<div>
							<a href="">실측 직접입력</a>
						</div>
						<div>
							<a href="">측정법</a>
						</div>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">cm</th>
							<th scope="col">총장</th>
							<th scope="col">어깨너비</th>
							<th scope="col">가슴단면</th>
							<th scope="col">소매길이</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">S</th>
							<td>66.5</td>
							<td>54</td>
							<td>60</td>
							<td>61</td>
						</tr>
						<tr>
							<th scope="row">M</th>
							<td>68.5</td>
							<td>56</td>
							<td>62.5</td>
							<td>62</td>
						</tr>
						<tr>
							<th scope="row">L</th>
							<td>70.5</td>
							<td>58</td>
							<td>65</td>
							<td>63</td>
						</tr>
						<tr>
							<th scope="row">XL</th>
							<td>72.5</td>
							<td>60</td>
							<td>67.5</td>
							<td>64</td>
						</tr>
					</tbody>
				</table>
			</div>



			<div class="detail-right">
				<!-- info -->
				<div class="detail-info">
					<div class="detail-info-top">
						<p class="only">단독 상품</p>
						<p class="only-text">MINE에서만 단독 판매하는 상품입니다.</p>
						<hr>
					</div>
					<h4>Product info 제품정보</h4>
					<div class="detail-info">
						<ul>
							<li><p>브랜드 / 품번</p> <span><strong>
										${ProductVO.pBrand } / ${ProductVO.uniqueName }</strong></span></li>
							<li><p>시즌</p> <a href="#"><i
									class="fa-solid fa-circle-question"></i></a> / 성별 <span><strong>2021
										S/S / 남 여</strong></span></li>
							<li><p>조회수(1개월</p>) <span><strong>${ProductVO.views }
										회 이상</strong></span></li>
							<li><p>누적판매(1년)</p> <span><strong><span class="sellCount"></span> 개이상(결제완료-반품)</strong></span></li>

							<li><p>좋아요</p> <span><strong>${ProductVO.pLike }</strong></span></li>

							<li><p>
									구매 후기 <a href="#"><i class="fa-solid fa-circle-question"></i></a>
								</p> <span><strong> 후기 <span class="recommandReviews"></span> 개 </strong></span></li>
						</ul>
					</div>
					<hr>
					<div class="detail-option">
						<div class="detail-option-cont">
							<select name="option1" id="option1">
								<option value="옵션선택">옵션선택</option>
								<option value="네이비">네이비</option>
							</select> <select name="option2" id="option2">
								<option value="옵션선택">옵션선택</option>
								<option value="S">S</option>
								<option value="M">M</option>
								<option value="L">L</option>
							</select>
						</div>
					</div>
					<hr>
					<hr>
					<!-- 구매버튼 -->
					<div class="box-buy-btn">
						<div class="buy-btn">
							<form action="paymentPage">
								<input name="pno" value="${ProductVO.pno }"	style="display: none;">
							    <input name="userId" value="${loginUserId }" style="display: none;">
								<button>바로구매</button>
							</form>
							<form action="cartInsert">
								<input name="pno" value="${ProductVO.pno }"
									style="display: none;">
								<button>장바구니</button>
							</form>
						</div>
						<div class="mylike-btn"></div>
						<div class="cart-btn"></div>
					</div>
					<hr>
					<div class="size-recommand">
						<strong>사이즈 추천</strong>
						<p class="box_recommand_size">구매고객/브랜드 관계자 추천 내역으로 MINE에서는 이를
							보증하지 않습니다. 참고용으로만 활용하시기 바랍니다.</p>

					</div>
					<!-- 옵션 -->
					<div class="size-recommand-option">
						<ul class="size-recommand-content">

						</ul>
					</div>
					<div>
						<!-- <form action="recommand"> -->
						<input type="text" value="${ProductVO.pno }" name="pno" id="pno"
							style="display: none;"> <select name="gender" id="gender">
							<option value="">성별</option>
							<option value="남자">남자</option>
							<option value="여자">여자</option>
						</select> <input type="number" name="height" id="height" placeholder="키">cm
						<input type="number" name="weight" id="weight" placeholder="몸무게">kg
						<select name="reviews" id="reviews">
							<option value="작음">작음</option>
							<option value="적당함">적당함</option>
							<option value="큼">큼</option>
						</select> <select name="pSize" id="pSize">
							<option value="s">S</option>
							<option value="m">M</option>
							<option value="l">L</option>
							<option value="xl">XL</option>
						</select>
						<button type="button" class="recbtn" onclick="recommandInsert();">추천하기</button>
						<!-- </form> -->
					</div>
					<hr>
					<!-- 차트영역 -->
					<div id="chart-div">
						<canvas id="age-chart" width="337" height="264"
							style="display: inline-block;"></canvas>
						<canvas id="gender-chart" width="337" height="264"
							style="display: inline-block;"></canvas>
					</div>


					<!-- 다른 제품 -->
					<div class="explain-product"></div>
				</div>


			</div>
		</div>
	</section>
	<aside class="quick-area">
		<ul class="quick-list">
			<li><a href="#">최근 본 상품</a></li>
			<li><a href="#">
					<p>전화문의</p> <small>010-1111-2222</small>
			</a></li>
			<li><a href="#">
					<p>카카오톡</p> <small>1:1상담</small>
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
</html>