function findPwCheck(){
	
	let userId=$("#userId").val();
	let userEmail=$("#userEmail").val();
	
	$.ajax({
		type:"get",
		url:"findPwCheck",
		data:{
			"userId":userId,
			"userEmail":userEmail
			
		},
		success:function(data){
			if(data=='success'){
				alert("아이디와 이메일이 확인되었습니다.");
				$(".authInput").css("display","block");
				$(".authSendBtn").css("display","block");
				$(".authBtn").css("display","block");
				$(".findPwBtn").css("display", "none");
				$(".idInput").css("display","none");
				$(".emailInput").css("display","none");
			}else{
				alert("아이디와 이메일을 확인하세요.");
			}
		},
		error:function(error){
			console.log(error);
		}
	})
	
}
function ranNumber(n){
	let str='';
	for(let i=0; i<n; i++){
		str+= Math.floor(Math.random() *10);
	}
	return str;
}

function authUpdate(){

	let userEmail=$("#userEmail").val();
	let userId=$("#userId").val();
	console.log(userEmail);
	alert("인증번호 메일이 발송되었습니다");
	var ranNum= ranNumber(6);
	console.log(ranNum);
	$.ajax({
		type:"post",
		url: "updateAuth",
		data: {"ranNum": ranNum,
			"userEmail": userEmail,
			"userId": userId},
		success: function(data){
		console.log(data);
		
		},
		error: function(error){
		console.log(error);
		}
	})
}	

function authCheck(){
	let authNum=$("#authNumber").val();
	let userId=$("#userId").val();
	$.ajax({
		type:"post",
		url:"authCheck",
		data:{"authNum": authNum,
			  "userId": userId},
			success:function(data){
				if(data=='fail'){
					alert("인증이 실패하였습니다.");
				
				}else{
				registPw(userId);
				}
			}
			  ,
			  error:function(error){
				 
			  }
		
	})
}

function registPw(userId){

 let ranNum=ranNumber(9);
 
 
 $.ajax({
 	type:"post",
 	url:"registPw",
 	data:{"userId":userId,
 		  "ranNum":ranNum},
 	success:function(data){
 		alert("당신의 비밀번호는 "+ data+"입니다.");
 		$(location).attr("href","/mine/");
 	},
 	error:function(error){
 	 alert("인증이 실패하였습니다.");
 	}
 })
}