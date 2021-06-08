package com.example.beer.dto;

import com.example.beer.domain.Beer;

import lombok.Getter;

@Getter
public class BeerResponseDto {
	
	private Long beerSeq;
	private String goodsName;
	private int unitPrice;
	private String REGUSER;
	
	public BeerResponseDto(Beer beer) {
		this.beerSeq = beer.getBeer_Seq();
		this.goodsName = beer.getGoodsName();
		this.unitPrice = beer.getUnitPrice();
		this.REGUSER = beer.getRegUser();
	}
	
}
