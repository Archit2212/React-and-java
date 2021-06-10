package com.corona.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.corona.entities.Room;
import com.corona.service.IRoomService;

@RestController
@RequestMapping("/api/room/")
@CrossOrigin
public class RoomController {

	@Autowired
	IRoomService iroomService;
	
	@GetMapping("/")
	public ResponseEntity<List<Room>> findAll() {
		List<Room> list = iroomService.findAll();
		return new ResponseEntity<List<Room>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Room> findById(@PathVariable int id) {
		Room r = iroomService.findById(id);
		return new ResponseEntity<Room>(r, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Room> verifyUser(@RequestBody Room room) {
		Room r = iroomService.verifyUser(room.getId(), room.getRoomType());
		return new ResponseEntity<Room>(r, HttpStatus.OK);
	}
	
	

	@PostMapping("/")
	public ResponseEntity<Room> createRoom(@RequestBody Room room) {
		Room r = iroomService.createRoom(room);
		return new ResponseEntity<Room>(r, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Room> updateRoomById( @PathVariable int id, @RequestBody Room room) {
		Room r = iroomService.updateRoom(room);
		return new ResponseEntity<Room>(r, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteRoomById(@PathVariable int id) {
		boolean operation = iroomService.deleteById(id);
		return new ResponseEntity<Boolean>(operation, HttpStatus.OK);
	}

}
