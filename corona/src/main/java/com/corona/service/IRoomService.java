package com.corona.service;
	
import java.util.List;

import com.corona.entities.Room;

public interface IRoomService {

	public Room findById(int id);
	public List<Room> findAll();
	
	public Room createRoom(Room room);
	public Room updateRoom(Room room);
	
	public boolean deleteById(int id);
	
	public Room verifyUser(int id , String roomType);
}
