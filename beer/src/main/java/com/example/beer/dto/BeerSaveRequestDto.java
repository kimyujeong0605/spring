package com.example.beer.dto;

import com.example.beer.domain.Beer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BeerSaveRequestDto {
	private String goodsName;
	private int unitPrice;
	private String regUser;
	
	@Builder
	public BeerSaveRequestDto(String goodsName,int unitPrice,String regUser) {
		this.goodsName = goodsName;
		this.unitPrice = unitPrice;
		this.regUser = regUser;
		
	}
	
	public Beer toEntity() {
		return Beer.builder()
					.goodsName(goodsName)
					.unitPrice(unitPrice)
					.regUser(regUser)
					.build();
	}

}
