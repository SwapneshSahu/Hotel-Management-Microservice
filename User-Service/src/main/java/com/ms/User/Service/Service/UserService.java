package com.ms.User.Service.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.User.Service.Entity.User;

@Service
public interface UserService {

	//user operations

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId

    User getUser(String userId);

    //TODO: delete
    //TODO: update
}
