package com.example.beer.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity // jpa entity
@Getter // Goods 필드값이 getter 자동생성
@NoArgsConstructor // 인자없는 생성자 자동으로 생성
@AllArgsConstructor
@Table(name = "GOODSINFO") //'GOODSINFO'테이블과 매핑

public class Beer {
	@Id //PrimaryKey
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "beer_Seq")
	private Long beer_Seq;
	
	@Column(name = "goodsName",nullable = false)
	private String goodsName;
	
	@Column(name = "unitPrice",nullable = false)
	private int unitPrice;
	
	@Column(name = "regUser")
	private String regUser;
	
	@Builder
	public Beer(String goodsName,int unitPrice,String regUser ) {
		this.goodsName = goodsName;
		this.unitPrice = unitPrice;
		this.regUser = regUser;
	}
	
	public void update(String goodsName,int unitPrice ) {
		this.goodsName = goodsName;
		this.unitPrice = unitPrice;
	}
}
