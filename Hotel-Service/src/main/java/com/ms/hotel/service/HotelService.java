package com.ms.hotel.service;

import java.util.List;

import com.ms.hotel.entity.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	Hotel getById(String hotelId);
	
	List<Hotel> findAll();
}
