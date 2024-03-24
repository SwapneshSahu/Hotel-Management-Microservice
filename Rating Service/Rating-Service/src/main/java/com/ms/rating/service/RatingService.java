package com.ms.rating.service;

import java.util.List;

import com.ms.rating.entity.Ratings;



public interface RatingService {
	
	Ratings saveRatings(Ratings ratings);
	
	List<Ratings> getAllRatings();
	
	List<Ratings> getRatingsByUserId(String userID);
	
	List<Ratings> getRatingsByHotelId(String hotelID);

	//Delete or Update ka bnana hai
}
