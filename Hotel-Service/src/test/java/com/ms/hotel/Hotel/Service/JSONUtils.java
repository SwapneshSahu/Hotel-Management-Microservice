package com.ms.hotel.Hotel.Service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {

	 public static String listToJsonString(List<?> list) throws JsonProcessingException {
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.writeValueAsString(list);
	    }
}
