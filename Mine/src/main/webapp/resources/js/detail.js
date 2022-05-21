$(document).ready(function() {
	(function() {
		getRecommandList();
	})();
})

function recommandInsert() {
	let pno = $("#pno").val();
	let gender = $("#gender").val();
	let height = $("#height").val();
	let weight = $("#weight").val();
	let reviews = $("#reviews").val();
	let pSize = $("#pSize").val();

	console.log(pno);
	console.log(height);
	console.log(weight);
	console.log(reviews);
	console.log(gender);
	console.log(pSize);

	$.ajax({
		type : "post",
		url : "recommand",
		data : {
			"pno" : pno,
			"gender" : gender,
			"height" : height,
			"weight" : weight,
			"reviews" : reviews,
			"pSize" : pSize
		},
		success : function(data) {
			console.log("recommand :" + data);
			if (data == "success") {
				alert("추천하기 성공하였습니다.");
				getRecommandList();
				
			} else {
				alert("추천하기 실패하였습니다.");
			}
		},
		error : function(error) {
			console.log(error);

		}

	})
}

function getRecommandList() {
	let pno = $("#pno").val();
	console.log(pno);
	$.ajax({
		type : "get",
		url : "getRecommandList",
		data : {
			"pno" : pno
		},
		success : function(data) {
			writeList(data);
		},
		error : function(data) {
			console.log(data);
		}
	})
}

function writeList(data) {

	let strAdd = "";

	if (data.length > 0) {

		for (var i = 0; i < data.length; i++) {

			strAdd += '<li>';
			strAdd += '<p class="size-content">';
			strAdd += '<strong>[회원추천]</strong> (' + data[i].gender + ' ' + data[i].height
					+ '<strong>cm</strong>/' + data[i].weight + '<strong>kg</strong>) 기준 ' + data[i].reviews
					+ ' <strong>네이비 ' + data[i].pSize + ' Size   구매</strong>   ';
			strAdd += '</p>';
			strAdd += '<p class="size-date">';
			strAdd += '<span>  ' + data[i].recommandDate + '</span>';
			strAdd += '</p>';
			strAdd += '</li>';
		}
	} else {
		strAdd += '<li>';
		strAdd += '<p class="size-content">';
		strAdd += '<strong> 조건에 맞는 데이터가 없습니다.</strong>';
		strAdd += '</p>';
	}
	$(".size-recommand-content").html(strAdd);
}
