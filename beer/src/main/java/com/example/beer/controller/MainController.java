package com.example.beer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	//GetMapping : http://localhost:8080/beer/string �ּ��� resource�� �̿��ϱ����ؼ� get method�� ȣ��
	@GetMapping(value = "/beer/string")
	//@ResponseBody : ����� ���信 �״�� ���
    //                ������ �� return�� ������ �̸����� �� ������ ������Ʈ ��ο��� ã�Ƽ� ȭ�鿡 ���
	@ResponseBody
	public String BeerString() {
		return "beer";
	}
}
