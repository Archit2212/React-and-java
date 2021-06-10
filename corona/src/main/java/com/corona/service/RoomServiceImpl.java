package com.corona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.corona.entities.Room;
import com.corona.repository.RoomRepository;


@Service
public class RoomServiceImpl implements IRoomService{

	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public Room findById(int id) {
		Room r = roomRepository.findById(id).get();
		return r;
	}
	
	@Override
	public List<Room> findAll() {
		// return roomRepository.findAll();
		List <Room> r =  roomRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		
		return r;
	}

	@Override
	public Room createRoom(Room room) {
		roomRepository.save(room);
		return room;
	}

	@Override
	public boolean deleteById(int id) {
		roomRepository.deleteById(id);
		return true;
	}

	@Override
	public Room updateRoom(Room room) {

		// !GETTING FIRST AND THEN UPDATE
		roomRepository.save(room);
		
		return room;
	}

	@Override
	public Room verifyUser(int id, String roomType) {
		
//		Room room = roomRepository.findByidandroomType(id, roomType);
//		return room;
		return null;
	}

	

}
