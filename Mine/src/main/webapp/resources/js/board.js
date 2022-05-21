$(document).ready(function(){
	
	var categoryName='TOP';
	var pNum=1;
	var searchName=null;
	$('.side-category').click(function(){
		pNum=1;
		categoryName=$(this)[0].innerHTML;
		console.log("categoryName = " + categoryName);
		getList(pNum,categoryName,searchName );
		
	});
	getList(pNum,categoryName,searchName );
	
	$(".pagination" ).click(function(){
		event.preventDefault();
		
		console.log(event.target);
		pNum=event.target.dataset.pagenum;
		console.log(pNum);
		
		getList(pNum, categoryName,searchName);
	})

	$(".searchBtn").click(function(){
		searchName=$(".search-input").val();
		
		console.log('searchName = ' +searchName);
		getList(pNum, categoryName,searchName);
	
})
	
	
	
});


function getList(pageNum, category, searchName){
	var sendData={
		"pageNum": pageNum,
		"category": category,
		"searchName": searchName
	}

	
	$.ajax({
		type: "get",
		url :"board/getList",
		dataType: "json",
		contentType :"application/json; charset=UTF-8",
		data : sendData,
		success: function(data){
			console.log(data);
			enterData(pageNum, data);
		},
		error: function(error){
			console.log(error);
		}
			})
}

function enterData(pageNum, data){
	var strAdd="";
	
	if(data.list.length==0){
		strAdd = "<li style='text-align:center; font-size:17px;'>조건에 맞는 데이터가 없습니다.</li>";
		$(".main-board").html(strAdd);
	}else{
		$.each(data.list, function(i, el){
				strAdd+='<li>';
				strAdd+='<img src="resources/product-img/'+el.p_imgAddr+'" alt="">';
				strAdd+='<h2>'+el.pName+'</h2>';
				strAdd+='<h3> "★★★☆☆ " <span class="red">2REIVIEW(S)</span> <br /> "'+el.price+'"원 </h3>';
				strAdd+='<div class="hover-content">';
				strAdd+='<a href="board/detail?pno='+el.pno+'">'+el.pCategory+'(상세)</a>';

				strAdd+='</div>';
			strAdd+='</li>';
		})
		$(".main-board").html(strAdd);
	}
	
	var pageVO=data.pageVO;
	var pageAdd="";
	
	console.log(pageVO);
	// 페이지네이션 처리
			if(pageVO.prev) pageAdd+= '<li class="page-item"><a class="page-link" data-pagenum='+(pageVO.startPage-1)+' href="#">Previous</a></li>';
			for(var i=pageVO.startPage; i<(pageVO.endPage)+1; i++){
				pageAdd+='<li class="page-item"><a class="page-link" data-pagenum="'+i+'" href="#">'+i+'</a></li>';
			}
			if(pageVO.next) pageAdd+='<li class="page-item"><a class="page-link" data-pagenum='+(pageVO.endPage+1)+' href="#">Next</a></li>';
			
	$(".pagination").html(pageAdd);

	
}// end enterData

