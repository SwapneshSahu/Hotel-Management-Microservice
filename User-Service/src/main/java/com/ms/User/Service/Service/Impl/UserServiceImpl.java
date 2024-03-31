package com.ms.User.Service.Service.Impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ms.User.Service.Entity.Rating;
import com.ms.User.Service.Entity.User;
import com.ms.User.Service.Exception.ResourceNotFoundException;
import com.ms.User.Service.Repo.UserRepository;
import com.ms.User.Service.Service.HotelService;
import com.ms.User.Service.Service.RatingService;
import com.ms.User.Service.Service.UserService;
import com.ms.User.Service.Config.WebClientConfig;
import com.ms.User.Service.Entity.Hotel;

//@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RatingService ratingService;

	@Autowired
	private WebClientConfig webClientConfig;
	
	private static String RATING_SERVICE_URL = "http://localhost:8082/rating/ratingsByUserId/";
	private static String HOTEL_SERVICE_URL = "http://localhost:8083/hotel/hotelById/";

	// private final WebClient webClient ;

	 public UserServiceImpl(HotelService hotelService) {
		  this.hotelService = hotelService ;
		}

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		// generate unique userid
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// implement RATING SERVICE CALL: USING REST TEMPLATE
		return userRepository.findAll();
	}

	// get single user
	@Override
	public User getUser(String userId) {
		// get user from database with the help of user repository
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
		WebClient dynamicClient;
		// try {
//		dynamicClient = webClientConfig.getWebClient().mutate().baseUrl(RATING_SERVICE_URL).build();
//
//		Rating[] ratingsOfUser = dynamicClient.get().uri(uriBuilder -> uriBuilder.path(user.getUserId()).build())
//				.retrieve().bodyToMono(Rating[].class).block();

		List<Rating> ratings = ratingService.getRating(userId);
				//Arrays.stream(ratingsOfUser).toList();

		//List<Rating> ratingList = 
			ratings.stream().map(rating -> {
				Hotel  hotel = hotelService.getHotel(rating.getHotelId());
//			WebClient dynamicClien = webClientConfig.getWebClient().mutate().baseUrl(HOTEL_SERVICE_URL).build();
//			Hotel hotel = dynamicClien.get().uri(uriBuilder -> uriBuilder.path(rating.getHotelId()).build()).retrieve()
//					.bodyToMono(Hotel.class).block();
		// logger.info("response status code: {} ",forEntity.getStatusCode());
			// set the hotel to rating
			rating.setHotel(hotel);

			return rating;
		}).collect(Collectors.toList());

		//System.out.println("Print hua " + ratingsOfUser.length);

		user.setRatings(ratings);

//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return user;
	}

}
