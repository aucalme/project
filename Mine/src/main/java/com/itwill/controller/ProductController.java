package com.itwill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

//	@Autowired
//	@Qualifier("productService");

	
	
	@RequestMapping("detail")
	public String detail(@RequestParam("pno")int pno) {
		
		return "product/detail?"+pno;
	}
	

}
