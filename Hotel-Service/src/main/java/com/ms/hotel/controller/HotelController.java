package com.ms.hotel.controller;

import java.util.Arrays;
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

import com.ms.hotel.entity.Hotel;
import com.ms.hotel.repo.HotelRepo;
import com.ms.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
//
//	Hotel hotel1 = new Hotel("erfgre","sdfvd","ghreghgf","dfgfd");
//	Hotel hotel2 = new Hotel("erfgre","sdfvd","ghreghgf","dfgfd");
//	Hotel hotel3 = new Hotel("erfgre","sdfvd","ghreghgf","dfgfd");
//	Hotel hotel4 = new Hotel("erfgre","sdfvd","ghreghgf","dfgfd");
//	
	@Autowired
	private HotelService service;
	
	@Autowired
	private HotelRepo hotelRepo;
	
	@PostMapping("/createHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
	
		return new ResponseEntity<Hotel>(this.service.createHotel(hotel),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/hotelById/{hotelId}")
	public ResponseEntity<Hotel> hotelById(@PathVariable String hotelId){
		
		return new ResponseEntity<Hotel>(this.service.getById(hotelId),HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllHotel")
	public ResponseEntity<List<Hotel>> getAllHotel(){
	//	Hotel [] hh = new Hotel [] {hotel1,hotel2,hotel3,hotel4};
	//	List<Hotel> records = Arrays.asList(hh);
		
		//return new ResponseEntity<List<Hotel>>(records,HttpStatus.OK);
		return new ResponseEntity<List<Hotel>>(this.hotelRepo.findAll(),HttpStatus.OK);
	}

	
}
