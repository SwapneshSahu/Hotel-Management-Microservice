package com.ms.hotel.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.hotel.entity.Hotel;
import com.ms.hotel.repo.HotelRepo;
import com.ms.hotel.service.HotelService;


@Service 
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		
		String random = UUID.randomUUID().toString();
		hotel.setHotelId(random);
		// TODO Auto-generated method stub
		return this.hotelRepo.save(hotel);
	}

	@Override
	public Hotel getById(String hotelId) {
		// TODO Auto-generated method stub
		
		Optional<Hotel> hotel = this.hotelRepo.findById(hotelId);
				//.orElseThrow(() -> new ResourceNotFoundException("Hotel Details not found with Id " + hotelId));
		return hotel.get();
	}

	@Override
	public List<Hotel> findAll() {
		// TODO Auto-generated method stub
		return this.hotelRepo.findAll();
	}

}
