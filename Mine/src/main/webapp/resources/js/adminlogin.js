function ranNumber(n){
	let str='';
	for(let i=0; i<n; i++){
		str+= Math.floor(Math.random() *10);
	}
	return str;
}


function authUpdate(){

	alert("인증번호 메일이 발송되었습니다");
	var ranNum= ranNumber(6);
	console.log(ranNum);
	$.ajax({
		type:"post",
		url: "updateAuth",
		data: {"ranNum": ranNum},
		success: function(data){
		console.log(data);
		
		},
		error: function(error){
		console.log(error);
		}
	})
	
	
	
	
$(".authBtn").click(function(){
	console.log("asfdsfa");

	console.log("왜 안되냐");
	alert("메일이 발송되었습니다");
})
}

