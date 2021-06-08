package com.example.beer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beer.dto.BeerResponseDto;
import com.example.beer.dto.BeerSaveRequestDto;
import com.example.beer.dto.BeerUpdateRequestDto;
import com.example.beer.service.BeerService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/beer")
@RestController
public class BeerController {
	private final BeerService beerService;
	
	@GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<BeerResponseDto>> findAll(){
		List<BeerResponseDto> beerResponseDtoList = beerService.findAll();
		
		return new ResponseEntity<List<BeerResponseDto>>(beerResponseDtoList, HttpStatus.OK);		
	}
	
	/* 제품 등록 */
	@PostMapping(value="", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Long> save(@RequestBody BeerSaveRequestDto beerSaveRequestDto){
		Long savedBeerSeq = beerService.save(beerSaveRequestDto);
		return new ResponseEntity<Long>(savedBeerSeq, HttpStatus.CREATED);
		
	}
	
	@PutMapping(value="/{beerSeq}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Long> update(@PathVariable("beerSeq") Long beerSeq,
									   @RequestBody BeerUpdateRequestDto beerUpdateRequestDto){
		Long updateBeerSeq = beerService.update(beerSeq,beerUpdateRequestDto);
		
		return new ResponseEntity<Long>(updateBeerSeq, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(value="/{beerSeq}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Long> update(@PathVariable("beerSeq") Long beerSeq){
		
		beerService.delete(beerSeq);
		return new ResponseEntity<Long>(beerSeq, HttpStatus.NO_CONTENT);
		
	}
}
