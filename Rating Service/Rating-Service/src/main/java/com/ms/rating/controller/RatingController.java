package com.ms.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.rating.entity.Ratings;
import com.ms.rating.service.RatingService;




@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService service;
	
	
	@PostMapping("/createRatings")
	public ResponseEntity<Ratings> createRatings(@RequestBody Ratings rating){
	
		return new ResponseEntity<Ratings>(this.service.saveRatings(rating),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/getAllRating")
	public ResponseEntity<List<Ratings>> getAllRatings(){
		
		return new ResponseEntity<List<Ratings>>(this.service.getAllRatings(),HttpStatus.OK);
	}


	@GetMapping("/ratingsByUserId/{userId}")
	public ResponseEntity<List<Ratings>> ratingsByUserId(@PathVariable String userId){
		
		return new ResponseEntity<List<Ratings>>(this.service.getRatingsByUserId(userId),HttpStatus.OK);
	}

	@GetMapping("/ratingsByHotelId/{hotelId}")
	public ResponseEntity<List<Ratings>> ratingsByHotelId(@PathVariable String hotelId){
		
		return new ResponseEntity<List<Ratings>>(this.service.getRatingsByHotelId(hotelId),HttpStatus.OK);
	}
	
}
