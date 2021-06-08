package com.example.beer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.beer.domain.Beer;
public interface BeerRepository extends JpaRepository<Beer , Long>{

}
