package com.example.beer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	//GetMapping : http://localhost:8080/beer/string 주소의 resource를 이용하기위해서 get method로 호출
	@GetMapping(value = "/beer/string")
	//@ResponseBody : 결과를 응답에 그대로 출력
    //                미지정 시 return에 지정된 이름으로 된 파일을 프로젝트 경로에서 찾아서 화면에 출력
	@ResponseBody
	public String BeerString() {
		return "beer";
	}
}
