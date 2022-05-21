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

        <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
    <script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/join.css">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/user.js"></script>

</head>
<body>
    <section class="member-join">
        <div class="join-container">
            <form action="join" method="post">
                <div class="header-area">
                    <div class="logo">
                        <h2>
                            MINE
                        </h2>
                        <p class="text-info">
                            회원가입
                        </p>
                    </div>
                </div>
                    <div class="join-form">
                        <div class="form-set">
                            <label for="memberId" class="j-form-label">아이디</label>

                            <input type="text" id="userId" name="userId" class="j-input" placeholder="아이디 입력(5~11자)" minlength="5" maxlength="11">
                            <div class="valid">사용 가능한 아이디입니다</div>
                            <div class="invalid">이미 사용중인 아이디입니다</div>

                        </div>
                        <div class="form-set">
                            <label for="memberName" class="j-form-label">이름</label>
                            <input type="text" name="userName" class="j-input">
                        </div>
                        <div class="form-set">
                            <label for="password" class="j-form-label">비밀번호</label>
                            <input type="password" name=userPw class="j-input" placeholder="비밀번호(숫자, 영문 ,특수문자 조합 최소 8자)" minlength="8">
                            <p></p>
                        </div>
                        <div class="form-set">
                            <input type="password" name="confirmPassword" class="j-input" placeholder="비밀번호 확인" minlength="8">
                        </div>
                         <div class="form-set">
                         	<div class="gender">
	                            <label for="gender">성별</label>
	                            <input type="radio" name="gender" value="male"> 남자
	                            <input type="radio" name="gender" value="female"> 여자
                            </div>
                        </div>
                        <div class="form-set">
                            <label for="phoneNum">핸드폰번호</label>
                            <input type="text" name="userPhone" class="j-input">
                            
                        </div>
                        <div class="form-set">
                            <label for="birth">생년월일</label>
                            <input type="date" name="userBirth" class="j-input">
                        </div>
                        <div class="form-set">
                            <label for="email" class="j-form-label">이메일</label>
                            <input type="text" name="userEmail" class="j-input">
                        </div>
                        
                        <div class="form-set">
                            <label for="zipcode">우편번호</label>
                            <input type="text" name="userZipCode" class="j-input" id="zipcode" readonly>
                        </div>
                        
                        <div class="form-set">
                            <label for="address">주소</label>
                            <input type="text" name="userAddr" class="j-input" id="address" readonly>
                            <button onclick="exePost()" type="button" style="margin-top:4px;">검색</button>
                        </div>
                        <div class="form-set">
                            <label for="addressDetail">상세주소</label>
                            <input type="text" name="userAddrDetail" id="addressDetail" class="j-input">
                        </div>
                        <button type="submit" class="join-submit">가입하기</button>
                    </div>

            </form>
        </div>

    </section>
     <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    

    $(document).ready(function () {
    	$('#userId').change(function (event){
    		var params = {userId: $(this).val()};
    		$.post('./userIdCheck', params, function (response){
    			if(response == 'valid') {
    				$('.valid').show();
    				$('.invalid').hide();
    				$('.join-submit').removeAttr('disabled');
    			} else {
    				$('.valid').hide();
    				$('.invalid').show();
    				$('.join-submit').attr('disabled','true');
    			}
    		});
    	});
    });

   	function exePost() {
   	    daum.postcode.load(function() {
   	        new daum.Postcode({
   	            oncomplete: function(data) {
   	                
   	            var roadAddr = data.roadAddress; // 도로명 주소 변수
   	            var extraRoadAddr = ''; // 참고 항목 변수

   	            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
   	            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
   	            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
   	                extraRoadAddr += data.bname;
   	            }
   	            // 건물명이 있고, 공동주택일 경우 추가한다.
   	            if(data.buildingName !== '' && data.apartment === 'Y'){
   	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
   	            }
   	            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
   	            if(extraRoadAddr !== ''){
   	                extraRoadAddr = ' (' + extraRoadAddr + ')';
   	            }

   	            console.log(data)
   	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
   	            document.getElementById('zipcode').value = data.zonecode;
   	            document.getElementById("address").value = roadAddr;
   	         	document.getElementById("addressDetail").focus();

   	            var guideTextBox = document.getElementById("guide");
   	            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
   	            if(data.autoRoadAddress) {
   	                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
   	                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
   	                guideTextBox.style.display = 'block';

   	            }
	

   	            }
   	        }).open();
   	    });
   	}

   	let msg="${msg}";
   	console.log(msg);
   	if(msg!=""){
   		alert(msg);
   	}
    

    </script>
    
</body>
</html>