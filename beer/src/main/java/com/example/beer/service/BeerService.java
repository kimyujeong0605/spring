package com.example.beer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.beer.domain.Beer;
import com.example.beer.dto.*;
import com.example.beer.repo.BeerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeerService {
	@Autowired
	private final BeerRepository beerRepository;
	
	/** 맥주 제품 조회 */
	@Transactional
	public List<BeerResponseDto> findAll(){
		return beerRepository.findAll()
							 .stream()
							 .map(BeerResponseDto::new)
							 .collect(Collectors.toList());
	}
	
	/** 맥주 제품 등록*/
	@Transactional
	public Long save(BeerSaveRequestDto beerSaveRequestDto) {
	    System.out.println("ㅠㅠ : "+beerSaveRequestDto.getGoodsName());
		return beerRepository.save(beerSaveRequestDto.toEntity())
							 .getBeer_Seq();
	}
	
	/** 맥주 제품 수정*/
	@Transactional
	public Long update(Long beerSeq, BeerUpdateRequestDto beerUpdateRequestDto) {
		Beer beer = beerRepository.findById(beerSeq)
								  .orElseThrow(() -> new IllegalAccessError("[beerSeq=" + beerSeq + "] 해당 제품이 존재하지 않습니다."));
		beer.update(beerUpdateRequestDto.getGoodsName(), beerUpdateRequestDto.getUnitPrice());
		
		return beerSeq;
								  
	}
	
	/** 맥주 제품 삭제*/
	public void delete(Long beerSeq) {
		Beer beer = beerRepository.findById(beerSeq)
				  .orElseThrow(() -> new IllegalAccessError("[beerSeq=" + beerSeq + "] 해당 제품이 존재하지 않습니다."));
		beerRepository.delete(beer);
	}
	
}
