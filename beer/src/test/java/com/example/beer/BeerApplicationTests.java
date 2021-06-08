package com.example.beer;

import static org.assertj.core.api.Assertions.assertThat;
 
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.beer.*;
import com.example.beer.domain.Beer;
import com.example.beer.dto.BeerSaveRequestDto;
import com.example.beer.repo.BeerRepository;

 

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BeerApplicationTests {
 
    
}
