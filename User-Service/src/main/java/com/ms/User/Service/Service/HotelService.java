package com.ms.User.Service.Service;

import com.ms.User.Service.Entity.Hotel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("HOTEL-SERVICE")
@Service
public interface HotelService {

    @GetMapping("/hotel/hotelById/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

   
}
