package com.ms.hotel.Hotel.Service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ms.hotel.controller.HotelController;
import com.ms.hotel.entity.Hotel;
import com.ms.hotel.repo.HotelRepo;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest
class HotelServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;
	
	ObjectMapper objectmapper = new ObjectMapper();
	ObjectWriter objectWriter = objectmapper.writer();
	
	
	@Mock
	private HotelRepo hotelRepo;
	
	@InjectMocks
	private HotelController hotelController;
	
	Hotel hotel1 = new Hotel("erfgre","sdfvd","ghreghgf","dfgfd");
	Hotel hotel2 = new Hotel("erfgre","sdfvd","ghreghgf","dfgfd");
	Hotel hotel3 = new Hotel("erfgre","sdfvd","ghreghgf","dfgfd");
	Hotel hotel4 = new Hotel("erfgre","sdfvd","ghreghgf","dfgfd");
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
	}
	
	@Test
	public void getAllRecorde()throws Exception {
		Hotel [] hh = new Hotel [] {hotel1,hotel2,hotel3,hotel4};
		List<Hotel> records = Arrays.asList(hh);
		
		//when(hotelRepo.findAll()).thenReturn(records);
		
		String jsonString = JSONUtils.listToJsonString(records);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/hotel/getAllHotel"))
        .andExpect(status().isOk())
        .andExpect(content().json(jsonString));
		
		/* mockMvc.perform((RequestBuilder) ((ResultActions) MockMvcRequestBuilders
					.get("/hotel/getAllHotel")
				    .contentType(MediaType.APPLICATION_JSON))
			        .andExpect(MockMvcResultMatchers.status().isOk())
			        .andExpect(JsonPath())
			    );*/
	
		
	}

	
	
				

	
	
	/*  // Set up the expected output
    String expectedOutput = "{\"id\":1,\"name\":\"John\",\"age\":30}";

    // Make the API call and store the response
    String apiResponse = APICaller.get("http://example.com/api/users/1");

    // Use assertEquals to check that the response is what we expected
    assertEquals(expectedOutput, apiResponse);*/
	
	
}
