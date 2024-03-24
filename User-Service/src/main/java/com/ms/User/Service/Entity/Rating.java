package com.ms.User.Service.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Rating {

	 private String ratingId;
	    private String userId;
	    private String hotelId;
	    private  int rating;
	    private  String feedback;
	//    private Hotel hotel;
}
