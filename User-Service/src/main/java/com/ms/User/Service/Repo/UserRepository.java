package com.ms.User.Service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.User.Service.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
