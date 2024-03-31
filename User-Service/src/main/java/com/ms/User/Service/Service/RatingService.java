package com.ms.User.Service.Service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.User.Service.Entity.Rating;

@FeignClient("RATING-SERVICE")
@Service
public interface RatingService {

	
	 @GetMapping("/rating/ratingsByUserId/{userId}")
	 List<Rating> getRating(@PathVariable("userId") String userId);

}
