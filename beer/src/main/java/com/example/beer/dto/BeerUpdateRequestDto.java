package com.example.beer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class BeerUpdateRequestDto {
	
	private String goodsName;
	private int unitPrice;
	
	@Builder
	public BeerUpdateRequestDto(String goodsName, int unitPrice){
		this.goodsName = goodsName;
		this.unitPrice = unitPrice;
	}
}
