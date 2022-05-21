
$(document).ready(function(){
	(function(){
	getProductList();
	})();

	

	

	
});



// 상품 수정요청
function updateProduct(){
	var dataNum= $(event.target).data('num'); // 데이터 넘버
	console.log(dataNum);
	var file= $("#file"+dataNum).val(); // 파일 명
	
	var pno=$("input[data-name='pno']" + "input[data-num='"+dataNum+"']").val();
	var pName = $("input[data-name='pName']" + "input[data-num='"+dataNum+"']").val();
	var pTitle = $("input[data-name='pTitle']" + "input[data-num='"+dataNum+"']").val();
	var pBrand = $("input[data-name='pBrand']" + "input[data-num='"+dataNum+"']").val();
	var uniqueName = $("input[data-name='uniqueName']" + "input[data-num='"+dataNum+"']").val();
	var price = $("input[data-name='price']" + "input[data-num='"+dataNum+"']").val();
	var pCategory = $("select[data-name='p_category']").val();
	var pDetail = $("textarea[data-name='p_detail']").val();
	
	
	
	
	
	file = file.slice(file.lastIndexOf(".", file.length) + 1, file.length); //확장자명
	
	//업로드하려는 파일의 확장자를 확인하는 조건문
	
	if(file != 'jpg' && file != 'png' && file != '') {
		alert("이미지 파일 형태만 등록가능합니다 (jpg, png)");
		return;
	} else if ( /*writer == ''*/ false) {
		alert("오류");
		return;
	}	
	
	console.log("price = " + price);
	
			//비동기형식의 폼데이터 사용
	var formData = new FormData();
	formData.append("pno", pno);
	formData.append("pCategory", pCategory);
	formData.append("pName", pName);
	formData.append("price", price);
	formData.append("pBrand", pBrand);
	formData.append("uniqueName", uniqueName);
	formData.append("pTitle", pTitle);
	formData.append("pDetail", pDetail);
	
	
	if(file == '') {
		formData.append("file", new File([""], "empty"));	
	} else {			
		formData.append("file", $("#file"+dataNum)[0].files[0]);
	}
	
	$.ajax({
		type:"post",
		url:"updateProduct",
		processData: false, //키-값으로 전송되는것을 막는 옵션
		contentType: false, //default 멀티파트 폼데이터 형식으로 지정
		data: formData,
		success: function(data) {
			if(data=="success"){
				alert("성공적으로 수정되었습니다.");
				(adminpageFilterFlag == true ? searchAdminProduct() : getProductList());
				adminpageFlag=false;
				} else if(data == "idFail") {
				alert("로그인이 필요한 서비스입니다");				
			} else if(data == "fail") {
				alert("Update 실패");
			} else {
				alert("서버 문제가 발생했습니다. 관리자에게 문의하세요");
			}
		},
		error: function(status, error) {
			console.log(status, error);
			alert("등록 요청에 실패했습니다. 관리자에게 문의하세요");
		
			
		}
	})
}
	



var adminpageFlag = false;
var adminpageFilterFlag = false;

function getProductList(){

	adminpageFlag = false;
 
 	$.getJSON("getProductList", function(data){

 	writeList(data);
 	})
}


// 상품 등록 요청

$("#registProductBtn").click(function(){
	
	console.log("registProductBtn 눌림");
	var file=$("#file").val();
	var pCategory=$("#pCategory").val();
	var pName= $("#pName").val();
	var pBrand=$("#pBrand").val();
	var price=$("#price").val();
	var uniqueName=$("#uniqueName").val();
	var pTitle=$("#pTitle").val();
	var pDetail=$("#pDetail").val();
	
	console.log(pCategory+'pCategory 값');
	
	file = file.slice(file.lastIndexOf(".", file.length) + 1, file.length); //확장자명

	
	
	//업로드하려는 파일의 확장자를 확인하는 조건문
	if(file != 'jpg' && file != 'png') {
		alert("이미지 파일 형태만 등록가능합니다 (jpg, png)");
		return;
	} else if ( /*writer == ''*/ false) {
		alert("오류");
		return;
	}	
	
		//비동기형식의 폼데이터 사용
	var formData = new FormData();
	formData.append("pCategory", pCategory);
	formData.append("pName", pName);
	formData.append("price", price);
	formData.append("pBrand", pBrand);
	formData.append("uniqueName", uniqueName);
	formData.append("pTitle", pTitle);
	formData.append("pDetail", pDetail);
	
	formData.append("file", $("#file")[0].files[0]);
	
		$.ajax({
		type: "post",
		url: "registProduct",
		processData: false, //키-값으로 전송되는것을 막는 옵션
		contentType: false, //default 멀티파트 폼데이터 형식으로 지정
		data: formData,
		success: function(data) {
			if(data == "success") {
				alert("성공적으로 등록되었습니다");
				formReset();
				getProductList();
			} else if(data == "idFail") {
				alert("로그인이 필요한 서비스입니다");				
			} else if(data == "fail") {
				alert("Insert 실패");
			} else {
				alert("서버 문제가 발생했습니다. 관리자에게 문의하세요");
			}
		},
		error: function(status, error) {
			console.log(status, error);
			alert("등록 요청에 실패했습니다. 관리자에게 문의하세요");
		}
	})
	
})


//수정 화면 전환
function formChangeToUpdate(dataNum) {

	var pCategory = $("select[data-name='p_category']").val();
	console.log('pCategory 값' + pCategory);
	var selector = "span[data-num='" + dataNum +"']";
	$("#adminpageProductlist " + selector).css("display", "none");
	$("#detailModal .select-form").css("display", "none");
	    		
	selector = "input[data-num='" + dataNum + "']";
	$("div[data-num='"+dataNum+"'].update-form").css("display", "block");
	$("#adminpageProductlist " + selector).css("display", "block");
	$("#detailModal .update-form").css("display", "block");
	
	//자세히보기 내용 변경
	showDetail(dataNum);
	adminpageFlag = true;
	
	//저장버튼으로 바꾸기
	selector = "button[data-num='"+dataNum+"']";
	$(selector + ".btn-info").addClass("btn-success");
	$(selector + ".btn-info").attr('id','regist-btn');
	$(selector + ".btn-info").attr('type','button');
	$(selector + ".btn-info").html("저장");
	$(selector + ".btn-info").attr('data-state', 'updating'); //상태추가
	$(selector + ".btn-info").attr('onclick',"updateProduct()"); // 기존 이벤트 제거
	$(selector + ".btn-info").removeClass("btn-info");
	
	//삭제버튼을 취소 버튼으로 바꾸기
	$(selector + ".btn-danger").html("취소");
	$(selector + ".btn-danger").attr('onclick','cancelUpdate('+dataNum+')');
	
}

//취소 화면 전환
function cancelUpdate(dataNum) {
	//자세히보기 내용 변경
	showDetail(dataNum);
	adminpageFlag = false;
	
	var selector = "span[data-num='" + dataNum +"']";
	$("#adminpageProductlist " + selector).css("display", "block");
	$("#detailModal .select-form").css("display", "block");
	    		
	selector = "input[data-num='" + dataNum + "']";
	$("div[data-num='"+dataNum+"'].update-form").css("display", "none");
	$("#adminpageProductlist " + selector).css("display", "none");
	$("#detailModal .update-form").css("display", "none");
	
	
	//수정버튼으로 바꾸기
	selector = "button[data-num='"+dataNum+"']"
	$(selector + ".btn-success").addClass("btn-info");
	$(selector + ".btn-success").html("수정");
	$(selector + ".btn-success").attr('data-state', 'cancel');
	$(selector + ".btn-success").attr('onclick','formChangeToUpdate('+dataNum+')');
	$(selector + ".btn-success").removeClass("btn-success");
	
	//취소버튼을 삭제버튼으로 바꾸기
	$(selector + ".btn-danger").html("삭제");
	$(selector + ".btn-danger").attr('onclick','deleteProduct()');
	
}




function writeList(data){

	var strAdd="";
		for(var i = 0; i < data.length; i++) {               	
           strAdd += '<tr><input type="hidden" data-name="pno" data-num="' + i + '" value="'+data[i].pno+'">';
           strAdd += '<td class="selector"><input type="checkbox" name="productSelector" id="" data-pno="'+data[i].pno+'"></td>';
           strAdd += '<td class="thumb-img"><div><div class="product-thumbnail"><img id="updateFileImg'+i+'" src="../resources/product-img/'+data[i].p_imgAddr+'"></div><div class="update-form update-img" data-num="'+i+'"><label class="btn btn-default file-label" for="file'+i+'">이미지 수정</label><input type="file" id="file'+i+'" data-name="img" onchange="readUpdateURL('+i+');"></div></div></td>';
           strAdd += '<td><span data-num="'+i+'">'+data[i].pName+ '</span><input type="text" data-num="'+i+'" data-name="pName" class="form-contorl update-form update-name" value="'+data[i].pName+'"></td>';
           strAdd += '<td><span data-num="'+i+'">'+data[i].pTitle+ '</span><input type="text" data-num="'+i+'" data-name="pTitle" class="form-contorl update-form update-title" value="'+data[i].pTitle+'"></td>';
           strAdd += '<td><span data-num="'+i+'">'+data[i].pBrand+ '</span><input type="text" data-num="'+i+'" data-name="pBrand" class="form-contorl update-form update-brand" value="'+data[i].pBrand+'"></td>';
           strAdd += '<td><span data-num="'+i+'">'+data[i].uniqueName+ '</span><input type="text" data-num="'+i+'" data-name="uniqueName" class="form-contorl update-form update-uniquename" value="'+data[i].uniqueName+'"></td>';
           strAdd += '<td><span data-num="'+i+'">'+data[i].price+ '</span><input type="text" data-num="'+i+'" data-name="price" class="form-contorl update-form update-price" value="'+data[i].price+'"></td>';
           strAdd += '<td><span>'+data[i].regdate+'</span></td>';
           strAdd += '<td><button data-toggle="modal" data-target="#detailModal" onclick="showDetail('+i+');">자세히보기</button></td>';
           strAdd += '<input type="hidden" data-num="'+i+'" value="'+data[i].pCategory+'">';
           strAdd += '<input type="hidden" data-num="'+i+'" value="'+data[i].pTitle+'">';
           strAdd += '<input type="hidden" data-num="'+i+'" value="'+data[i].pDetail+'">';
           strAdd += '<td>';
           strAdd += '<div class="product-data-btn">';

           strAdd += '<button class="btn btn-info btn-block" data-num="'+i+'" onclick="formChangeToUpdate('+i+');">수정</button>';
           strAdd += '<button class="btn btn-danger btn-block" data-num="'+i+'" onclick="deleteProduct('+i+');" data-pno="'+data[i].pno+'" >삭제</button>';

           strAdd += '</div>';
           strAdd += '</td>';
           strAdd += '</tr>';
	
	}
	
	$("#adminpageProductlist").html(strAdd);
}

//상품상세 자세히보기
function showDetail(dataNum) {    		
	var updateDataNum = $("button[data-state='updating']").data("num");
	if(adminpageFlag == true) {
		if(updateDataNum != dataNum) {
			adminpageFlag == false;
			cancelUpdate(updateDataNum);
		}
	}
	
	var selector = "input[data-num='" + dataNum + "']input[type='hidden']";
	var data = $(selector);
	console.dir(data);
	$(".adminpage-detailmodal-pno").children('span').html(data[0].value); //상품번호
	
	$(".adminpage-detailmodal-category > .select-form").children('span').html(data[1].value); //카테고리
	
	
	$(".adminpage-detailmodal-category > .update-form").children('select').val(data[1].value).prop("selected", true);
	
	$(".adminpage-detailmodal-detailtitle > .select-form").children('span').html(data[2].value); //상세이름
	$(".adminpage-detailmodal-detailtitle > .update-form").children('input').val(data[2].value);
	
	$(".adminpage-detailmodal-detail > .select-form").children('span').html(data[3].value); //상세설명
	$(".adminpage-detailmodal-detail > .update-form").children('textarea').val(data[3].value);

}

//사이드바
$(".adminpage-regist-btn").click(function(){
    $(".product-manage-area").css("display","none")
    $(".product-regist-area").css("display","block");
})
$(".adminpage-manage-btn").click(function() {
    $(".product-manage-area").css("display","block")
    $(".product-regist-area").css("display","none");
})
$(".adminpage-logout-btn").click(function() {
	location.href = "adminLogout";
})
$(".adminpage-chat-btn").click(function() {
	location.href = "adminchat";
})
$(".adminpage-management-btn").click(function() {
	location.href = "adminpage";
})





//사이드바 끝

//상품 선택해제
$("#uncheckedBtn").click(function() {
	$("input[name='productSelector']:checked").prop("checked", false);
})

//자바 스크립트 파일 미리보기 기능
function readURL(input) {
   	if (input.files && input.files[0]) {
   		
       	var reader = new FileReader(); //비동기처리를 위한 파읽을 읽는 자바스크립트 객체
       	//readAsDataURL 메서드는 컨텐츠를 특정 Blob 이나 File에서 읽어 오는 역할 (MDN참조)
    	reader.readAsDataURL(input.files[0]); 
        $(".img-inner").css("display", "block");
       	
       	reader.onload = function(event) { //읽기 동작이 성공적으로 완료 되었을 때 실행되는 익명함수
           	$('#fileImg').attr("src", event.target.result); 
           	console.log(event.target)//event.target은 이벤트로 선택된 요소를 의미
    	}
   	}
}
$("#file").change(function() {
	console.log(this);
    readURL(this); //this는 #file자신 태그를 의미
});

function formReset(){
	$("#file").val(null); // 파일
	$(".img-inner").css("display","none"); // 이미지
	$("#category").find('option:first').attr('selected','selected'); //종류
	$("#pName").val('');
	$("#pBrand").val('');
	$("#price").val('');
	$("#uniqueName").val('');
	$("#pTitle").val('');
	$("#pDetail").val('');
	
}


// 상품 삭제하기

function deleteProduct() {
	var pno = [];
	pno.push($(event.target).data('pno'));
	if(confirm("상품번호 " + pno + " 삭제하시겠습니까?")) {

		deleteRequest(pno);
		
	} else return;  		

}

function deleteRequest(pno){
	
	$.ajax({
		type: "post",
		url: "deleteProduct",
		data: {"pno":JSON.stringify(pno)},
		success: function(data) {
			if(data =='success'){
				console.log(data);
				alert('삭제 성공')
				getProductList();
			}else{
				
			}
        },
		error: function(stats, error) {
			console.log(stats, error);
			alert("삭제실패");
		}
		
	})
}


// 상품 선택 삭제 요청
function deleteCheckedProduct(){
	var checked=[];
	
		$("input[name='productSelector']:checked").each(function(i) {
		checked.push($(this).data('pno'))
	})
		if(checked.length == 0) {
		alert("선택된 항목이 없습니다")
		return;
	} else if(confirm("선택한 " + checked.length + "개의 상품을 삭제하시겠습니까?")) {
		deleteRequest(checked);
	} else {
		alert("삭제 취소 되었습니다")
		return;
	}
}


$("#file").change(function() {
	console.log(this);
    readURL(this); //this는 #file자신 태그를 의미
});



// 필터링 된  상품 요청

function searchAdminProduct(){
	var category= [];
	$("input[name='category']:checked").each(function(i){
		
		
		category.push($(this).val())
		});
		console.log(category);
		
		var minPrice=$("input[name='minPrice']").val();
		var maxPrice=$("input[name='maxPrice']").val();
		
		console.log(minPrice + " minPrice");
		console.log(maxPrice+ " maxPrice");
		
		
		var searchType= $("select[name='searchType']").val();
		var searchWord= $("input[name='searchWord']").val();
		
		console.log(searchType + " searchType");
		console.log(searchWord+" searchWord");
		
		var cri={ "searchType" : searchType,
				  "searchWord" :  searchWord,
				  "category" : category,
				  "minPrice" : minPrice,
				  "maxPrice" : maxPrice }
				  
		$.ajax({
			type: "post",
			url: "getFilteredList",
			data: JSON.stringify(cri),
			contentType:  "application/json; charset=UTF-8",
			success: function(data){
				console.log(data);
				adminpageFilterFlag = true;
				writeList(data);
				
			},
			error: function(status, error) {
			console.log(status,error);
			}
			
		})
		
	}


