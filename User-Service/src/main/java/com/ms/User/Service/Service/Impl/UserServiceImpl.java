package com.ms.User.Service.Service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.User.Service.Entity.User;
import com.ms.User.Service.Exception.ResourceNotFoundException;
import com.ms.User.Service.Repo.UserRepository;
import com.ms.User.Service.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
    private UserRepository userRepository;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private HotelService hotelService;

   

    @Override
    public User saveUser(User user) {
        //generate  unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        //implement RATING SERVICE CALL: USING REST TEMPLATE
        return userRepository.findAll();
    }

    //get single user
    @Override
    public User getUser(String userId) {
        //get user from database with the help  of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        // fetch rating of the above  user from RATING SERVICE
        //http://localhost:8083/ratings/users/47e38dac-c7d0-4c40-8582-11d15f185fad

//        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
//        log.info("{} ", ratingsOfUser);
//        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
//        List<Rating> ratingList = ratings.stream().map(rating -> {
//            //api call to hotel service to get the hotel
//            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
//            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            // logger.info("response status code: {} ",forEntity.getStatusCode());
//            //set the hotel to rating
//            rating.setHotel(hotel);
//            //return the rating
//            return rating;
//        }).collect(Collectors.toList());
//
//        user.setRatings(ratingList);

        return user;
    }
}
