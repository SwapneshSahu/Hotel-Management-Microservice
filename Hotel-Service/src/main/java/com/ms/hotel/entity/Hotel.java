package com.ms.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="micro_hotel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
	
	@Id
	private String hotelId;
	private String name;
	private String location;
	private String about;

}
