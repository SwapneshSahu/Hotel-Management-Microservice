package com.ms.User.Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.User.Service.Entity.User;
import com.ms.User.Service.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
//@Slf4j
public class UserController {

	@Autowired
	private UserService userService;


	// create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	// single user get

	@GetMapping("/userId")
//	    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
//	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@RequestParam String userId) {
	//	log.info("Get Single User Handler: UserController");
//	        logger.info("Retry count: {}", retryCount);

		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	// creating fall back method for circuitbreaker

	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
//	        logger.info("Fallback is executed because service is down : ", ex.getMessage());

		ex.printStackTrace();

		User user = User.builder().email("dummy@gmail.com").name("Dummy")
				.about("This user is created dummy because some service is down").userId("141234").build();
		return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
	}

	// all user get
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}
}
