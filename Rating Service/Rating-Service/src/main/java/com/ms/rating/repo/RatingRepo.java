package com.ms.rating.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.rating.entity.Ratings;

@Repository
public interface RatingRepo extends JpaRepository<Ratings, String> {
	
	
	public List<Ratings> findByUserId(String userID);
	
	public List<Ratings> findByHotelId(String hotelID);
	

}
