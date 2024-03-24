package com.ms.rating.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.rating.entity.Ratings;
import com.ms.rating.repo.RatingRepo;
import com.ms.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Ratings saveRatings(Ratings ratings) {

		String random = UUID.randomUUID().toString();
		ratings.setRatingId(random);
		return this.ratingRepo.save(ratings);
	}

	@Override
	public List<Ratings> getAllRatings() {

		return this.ratingRepo.findAll();
	}

	@Override
	public List<Ratings> getRatingsByUserId(String userID) {
		List<Ratings> ratings =  this.ratingRepo.findByUserId(userID);
		
		System.out.println("AYA tha yaha to");
		if (ratings.isEmpty() || ratings == null)
			throw new com.ms.rating.exception.ResourceNotFoundException(
					"Rating Details not found with User Id " + userID);
		return ratings;
	}

	@Override
	public List<Ratings> getRatingsByHotelId(String hotelID) {
		List<Ratings> ratings = this.ratingRepo.findByHotelId(hotelID);
		if (ratings.isEmpty() || ratings == null)
			throw new com.ms.rating.exception.ResourceNotFoundException(
					"Rating Details not found with Hotel Id " + hotelID);
		return ratings;
	}

}
