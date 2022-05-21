<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MINE -- 관리자페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"

	href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
<script
	src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/adminpage.css">

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
								<li class="adminpage-manage-btn">상품관리</li>
								<li class="adminpage-regist-btn">상품등록</li>
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


				<!-- 상품 관리-->
				<div class="col-xs-10">
					<!-- 검색 영역-->

					<div class="row flex-center">

						<div class="col-xs-12 product-manage-area">
							<div class="search-wrap">
								<div>
									<span class="manage-pagetitle">상품 관리</span>
								</div>
								<div class="search-inner">
									<table class="search-tag-table">

										<tbody>
											<tr>
												<th>종류</th>
												<td><input type="checkbox" name="category" value="TOP"><span>TOP</span>
													<input type="checkbox" name="category" value="PANTS"><span>PANTS</span>
													<input type="checkbox" name="category" value="OUTER"><span>OUTER</span>
													<input type="checkbox" name="category" value="SHOES"><span>SHOES</span>
												</td>

												<th>가격</th>
												<td><input class="form-control adminpage-searchform"
													type="number" name="minPrice"> 원 ~ <input
													class="form-control adminpage-searchform" type="number"
													name="maxPrice"> 원</td>
											</tr>
											<tr>

											</tr>
										</tbody>
									</table>
									<div class="search-line">
										<select class="form-control search-select" name="searchType">
											<option>브랜드</option>
											<option>이름</option>
										</select> <input class="form-control search-input" type="text"
											name="searchWord">
										<button class="btn btn-default search-product-btn"
											type="button" onclick="searchAdminProduct();">검색</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 검색 영역 끝-->

					<!-- 데이터 영역 시작-->

					<div class="col-xs-12 product-manage-area">
						<div class="data-wrap">
							<div class="data-inner">
								<div class="data-btn-line">
									<button class="btn btn-danger" onclick="deleteCheckedProduct()">선택삭제</button>
									<button class="btn btn-primary" id="uncheckedBtn">선택해제</button>
								</div>
								<table class="table table-hover data-table">
									<!-- sticky 될 영역-->
									<thead class="sticky-table-header">
										<th style="width: 80px;">선택</th>
										<th style="width: 122px;">이미지</th>

										<th style="width: 110px;">상품이름</th>
										<th style="width: 120px;">상품타이틀</th>
										<th style="width: 120px">상품브랜드</th>
										<th style="width: 110px;">고유번호</th>
										<th style="width: 90px;">가격</th>
										<th style="width: 110px;">등록날짜</th>
										<th style="width: 100px;">관리</th>

									</thead>
									<!-- sticky 될 영역 끝-->

									<tbody id="adminpageProductlist">

									</tbody>
								</table>

							</div>

						</div>
					</div>

					<!-- 데이터 영역 끝-->

					<!-- 상품 등록-->


					<div class="col-xs-12 product-regist-area">
						<div class="regist-wrap">
							<div class="regist-inner">
								<div>
									<span class="regist-pagetitle">상품 등록</span>
								</div>


							<!-- 	<form action="registProduct" method="post" enctype="multipart/form-data">
 -->

									<table class="table regist-table">
										<tr>
											<th>종류</th>
											<td><select class="form-control" name="pCategory"

												id="pCategory">

													<option>TOP</option>
													<option>PANTS</option>
													<option>OUTER</option>
													<option>SHOES</option>
											</select></td>
											<td class="img-td" rowspan="7">
												<div class="img-wrap">

													<div class="img-inner" style="display: none;">
														<img id="fileImg" src="#" alt="">
													</div>
													<div class="img-file-btn-box">

														<label class="btn btn-default" for="file">이미지업로드</label> <input
															type="file" id="file" name="file">

													</div>
												</div>
											</td>
										</tr>
										<tr>
											<th>이름</th>
											<td><input class="form-control" name="pName" id="pName"
												type="text"></td>
										</tr>
										<tr>
											<th>브랜드</th>
											<td><input class="form-control" name="pBrand" id="pBrand"
												type="text"></td>
										</tr>
										<tr>
											<th>가격</th>
											<td><input class="form-control" name="price" id="price"
												type="text"></td>
										</tr>
										<tr>
											<th>고유번호</th>
											<td><input class="form-control" name="uniqueName"
												id="uniqueName" type="text"></td>
										</tr>

										<tr>
											<th>상품 상세 이름</th>
											<td colspan="2"><input class="form-control"
												name="pTitle" id="pTitle" type="text" id=""></td>
										</tr>
										<tr>
											<th>상품설명</th>
											<td colspan="2"><textarea class="form-control"
													name="pDetail" id="pDetail"></textarea></td>
										</tr>
										<tr>
											<td colspan="3">

												<button class="btn btn-danger"  onclick="formReset();" >초기화</button>
												<button class="btn btn-success" id="registProductBtn"
													type="button">등록</button>
											</td>
										</tr>
									</table>
<!-- 
								</form>
 -->

							</div>
						</div>
					</div>
				</div>

				<!-- 상품등록 끝-->
			</div>
			<!-- 상품관리 끝-->






			<!-- 관리영역 끝-->
		</div>


		<!-- 자세히보기 모달 -->
		<!-- Modal -->
		<div id="detailModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-body">
						<div class="adminpage-detailmodal-pno">
							<h4>고유번호</h4>
							<span></span>
						</div>
						<div class="adminpage-detailmodal-category">
							<h4>종류</h4>
							<div class="select-form">
								<span></span>
							</div>
							<div class="update-form">
								<select class="form-control update-category"
									data-name="p_category">
									<option>TOP</option>
									<option>PANTS</option>
									<option>OUTER</option>
									<option>SHOES</option>
								</select>
							</div>
						</div>
						<div class="adminpage-detailmodal-detailtitle">
							<h4>상품 상세 이름</h4>
							<div class="select-form">
								<span></span>
							</div>
							<div class="update-form">
								<input type="text" class="form-control update-detailtitle"
									data-name="p_detailtitle">
							</div>
						</div>
						<div class="adminpage-detailmodal-detail">
							<h4>상품 상세 설명</h4>
							<div class="select-form">
								<span></span>
							</div>
							<div class="update-form">
								<textarea class="form-control update-detail"
									data-name="p_detail"></textarea>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

	<script src="${pageContext.request.contextPath }/resources/js/adminpage.js"></script>

</body>
</html>