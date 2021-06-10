package com.corona.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.corona.entities.Room;
import com.corona.service.IRoomService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RoomController.class)
class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	// LEARNING 1 :: DUMMY OBJECT :: MOCK OBJECT
	@MockBean
	private IRoomService roomService;

	@Test
	void findRoomTest() throws Exception {
		
		Room r = new Room();
		r.setRoomStatus("AC");
		
		// LEARNING 2
		// providding the implemenation of findById method.
		// mocking the findById method on MockObject employeeService
		Mockito.when(roomService.findById(Mockito.anyInt())).thenReturn(r);
		
		mockMvc.perform(get("/api/room/1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.type").value("AC"));
	}
	
}
