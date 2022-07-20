# MINE - 의류 및 잡화 쇼핑몰 웹페이지
___
- MINE : '나의 것으로 만들어라' 라는 의미의 웹 SHOPPING MALL 프로그램
- ITWILL 교육과정 JAVA Spring 프로젝트
- 사용자 페이지 / 관리자 페이지로 구별하여 상품을 구매 또는 등록이 가능한 사이트
> 인터넷 쇼핑몰을 이용할 때 한 눈에 보기 편하도록 사용자 편의를 위해 비동기로 메뉴 이동을 하거나 관리자가 상품을 손쉽게 등록할 수 있도록 기능을 구현했습니다. MINE 프로그램을 통해서 고객과 관리자가 편하고 쉽게 구매하고 관리할 수 있었으면 좋겠습니다.

## 개발 인원 (2명)
___
- 이진호 : DB설계, 회원가입, 페이지네이션, 메인페이지, 상세페이지, 장바구니 페이지, 결제페이지, 관리자페이지
- 강민지 : UI디자인, 로그인, 회원정보수정 비밀번호 재확인, 연령/나이별 차트, 사이드바

## 개발 환경
___
<img src="https://img.shields.io/badge/Eclipse IDE-2C2255?style=for-the-badge&logo=Eclipse IDE&logoColor=white"> <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white"> <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=for-the-badge&logo=Spring&logoColor=white"> <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Visual Studio Code&logoColor=white"> <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white"> <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white"> <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white"> <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white"> <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white"> <img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white">


## 주요 기능
___
- 회원가입 : 아이디 중복확인, 비밀번호, 비밀번호 확인, 성별, 휴대폰 번호, 생년월일 달력 api 사용, 이메일, 우편번호와 주소 api 사용하여 회원정보 입력 후 회원가입하는 기능 
- 로그인/로그아웃 : 아이디와 비밀번호가 회원정보 테이블에 데이터와 일치하면 로그인하는 기능, 로그아웃 후 메인페이지 이동 
- 슬라이더 : 메인페이지에 3개의 이미지가 자동으로 바뀌며 상품사진 클릭 시 상품 상세페이지로 이동
- 페이지네이션 : 메인페이지에 총 8개의 상품 나열한 부분을 비동기로 페이지가 변경되게끔 구현
- 카테고리별 항목 표시 : TOP, PANTS, OUTER, SHOES의 네가지 카테고리 별로 비동기로 메뉴가 변경되는 기능
- 검색 : 상품명에 해당되는 내용이 들어간 키워드로 검색이 가능, 
관리자 페이지에서는 종류, 가격, 브랜드, 이름 별로 검색 가능
- 사이드바 : 페이지 상단, 하단으로 화살표 클릭시 이동
- 마이페이지(회원정보수정) : 마이페이지로 들어가려면 (로그인 된 상태에서만 가능) 비밀번호 재확인을 하고 일치 시에 페이지를 보여주며, 회원정보를 새로 입력하고 수정 버튼을 누르면 테이블에 수정된 내용이 등록됨
- 장바구니 : 장바구니에 담긴 상품을 보여주며 상품 삭제나 주문이 가능
- 결제창 : 결제 수단을 고르고 결제 창을 누르면 결제 완료 후 메인페이지로 이동 (상세페이지에 차트에 데이터가 적용됨)
- 사이즈 추천 : 성별, 키, 몸무게, 핏, 사이즈 추천을 입력 및 선택하여 추천 글을 올릴 수 있는 기능
- 차트 : 연령, 성별로 구분지어 구매한 이력을 나타내는 차트
- 관리자페이지 로그인 인증 : 관리자 테이블에 ADMINID에 맞는 이메일주소로 인증번호를 전송하고 그 인증번호를 입력하고 일치하면 로그인
- 상품등록 : 상품의 종류, 이름, 브랜드, 가격, 고유번호(품번), 상세이름, 상품 설명, 이미지를 넣어 상품을 등록하는 기능
- 상품 수정 및 삭제, 상세보기 : 상품 상세 속성을 수정할 수 있고 상품을 선택하여 선택 삭제가 가능함. 자세히보기 버튼을 누르면 모달 창으로 상품의 내용 확인 가능
