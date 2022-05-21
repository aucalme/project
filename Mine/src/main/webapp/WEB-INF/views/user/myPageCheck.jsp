<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/mypage.css">

    <script src="https://kit.fontawesome.com/fd06a08b1d.js" crossorigin="anonymous"></script>
    <title>myPageCheck</title>
</head>
<body>
    <header>
        <div>
            <h1 class="logo"><a href="/mine/">MINE</a></h1>
            <input type="text" id="search" name="search">
            <a href="#"><i class="fa-solid fa-magnifying-glass"></i></a>
            
                <ul class="headlist">
                    <li><a href="#">LOGOUT</a></li>
                    <li><a href="#">MYPAGE</a></li>
                    <li><a href="#">CART</a></li>
                </ul>
            <div class="menu">
                <ul class="productlist">
                    <li><a href="#">TOP</a></li>
                    <li><a href="#">PANTS</a></li>
                    <li><a href="#">OUTER</a></li>
                    <li><a href="#">SHOES</a></li>
                    <li><a href="#">EVENT</a></li>
                </ul>
            </div>
        </div>
    </header>
    <section>
        <div class="jb-container">
            <div class="jb-item">
                <h2>비밀번호 재확인</h2>
                <p>회원님의 안전한 개인정보 보호를 위해 <br> 비밀번호를 다시 한번 확인합니다.</p>
                <form action="myPageCheck" method="post">
                    <input type="password" name="password" placeholder="비밀번호를 입력해주세요." minlength="8">
                    <input type="submit" value="확인">
                </form>
            </div>
          </div>

    </section>
    <footer class="footer">        

        <div>
        <ul class="footer-info">
            <li><a href="#">회사소개</a></li>
            <li><a href="#">이용약관</a></li>
            <li><a href="#">이메일문의</a></li>
            <li><a href="#">개인정보취급방침</a></li>
            <li><a href="#">사업자정보확인</a></li>
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
        </div>
        <div id="scrollbottom"></div>
    </footer>
</body>
</html>