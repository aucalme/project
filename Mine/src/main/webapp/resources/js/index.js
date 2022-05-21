$(document).ready(
		function() {

			var pno = $(".detail-pno")[0].innerText;

			sellcount();
			recommandReviews();
			chartList();
			genderList();
			var age18 = 0;
			var age23 = 0;
			var age28 = 0;
			var age33 = 0;
			var age39 = 0;
			var age40 = 0;

			function chartList() {

				$.ajax({
					type : "post",
					url : "../chart/chartList",
					data : {
						"pno" : pno
					},
					success : function(data) {
						console.log(data);
						age18 = data[0];
						age23 = data[1];
						age28 = data[2];
						age33 = data[3];
						age39 = data[4];
						age40 = data[5];
						console.log("age28 = " + age28);
						ageMake(age18, age23, age28, age33, age39, age40);
					},
					error : function(status, error) {
						console.log(status);
						console.log(error);
					}
				})
			}
			function genderList() {
				$.ajax({
					type : "post",
					url : "genderList",
					data : {
						"pno" : pno
					},
					success : function(data) {
						console.log(data);
						genderMake(data[0], data[1])
					},
					error : function(status, error) {
						console.log(status);
						console.log(error);
					}

				})
			}
			function sellcount() {

				$.ajax({
					type : "post",
					url : "../chart/sellCount",
					data : {
						"pno" : pno
					},
					success : function(data) {
						console.log("sell Count data = " + data);
						$(".sellCount")[0].innerHTML = data;

					},
					error : function(status, error) {
						console.log(error);
					}
				})

			}

			function recommandReviews() {

				$.ajax({
					type : "post",
					url : "../chart/recommandReviews",
					data : {
						"pno" : pno
					},
					success : function(data) {
						$(".recommandReviews")[0].innerHTML = data;
					},
					error : function(data) {

					}
				})
			}

			// 차트 만들기

			function ageMake(age18, age23, age28, age33, age39, age40) {

				new Chart(document.getElementById("age-chart"),
						{
							type : 'bar',
							data : {
								labels : [ "~18세", "19~23세", "24~28세",
										"29~33세", "34~39세", "40세~" ],
								datasets : [ {
									label : "명",
									backgroundColor : [ "#0052A5", "#0052A5",
											"#0052A5", "#0052A5", "#0052A5",
											"#0052A5" ],
									data : [ age18, age23, age28, age33, age39,
											age40 ]
								} ]
							},
							options : {
								responsive : false,
								legend : {
									display : false
								},
								title : {
									display : true,
									text : '연령'
								}
							}
						});

			}

			function genderMake(male, female) {

				new Chart(document.getElementById("gender-chart"), {
					type : 'doughnut',
					data : {
						labels : [ "남성", "여성" ],
						datasets : [ {
							label : "명",
							backgroundColor : [ "#4e6dd1", "#d472bf" ],
							data : [ male, female ]
						} ]
					},
					options : {
						responsive : false,
						title : {
							display : true,
							text : '성별'
						}
					}
				});
			}

		})
