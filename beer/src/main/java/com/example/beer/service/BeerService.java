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
	
	/** ���� ��ǰ ��ȸ */
	@Transactional
	public List<BeerResponseDto> findAll(){
		return beerRepository.findAll()
							 .stream()
							 .map(BeerResponseDto::new)
							 .collect(Collectors.toList());
	}
	
	/** ���� ��ǰ ���*/
	@Transactional
	public Long save(BeerSaveRequestDto beerSaveRequestDto) {
	    System.out.println("�Ф� : "+beerSaveRequestDto.getGoodsName());
		return beerRepository.save(beerSaveRequestDto.toEntity())
							 .getBeer_Seq();
	}
	
	/** ���� ��ǰ ����*/
	@Transactional
	public Long update(Long beerSeq, BeerUpdateRequestDto beerUpdateRequestDto) {
		Beer beer = beerRepository.findById(beerSeq)
								  .orElseThrow(() -> new IllegalAccessError("[beerSeq=" + beerSeq + "] �ش� ��ǰ�� �������� �ʽ��ϴ�."));
		beer.update(beerUpdateRequestDto.getGoodsName(), beerUpdateRequestDto.getUnitPrice());
		
		return beerSeq;
								  
	}
	
	/** ���� ��ǰ ����*/
	public void delete(Long beerSeq) {
		Beer beer = beerRepository.findById(beerSeq)
				  .orElseThrow(() -> new IllegalAccessError("[beerSeq=" + beerSeq + "] �ش� ��ǰ�� �������� �ʽ��ϴ�."));
		beerRepository.delete(beer);
	}
	
}
