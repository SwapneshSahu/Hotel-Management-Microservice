package com.ms.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.hotel.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {

}
