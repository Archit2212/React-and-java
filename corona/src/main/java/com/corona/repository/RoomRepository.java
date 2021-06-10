package com.corona.repository;

	import org.springframework.data.jpa.repository.JpaRepository;

import com.corona.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

	// NOT BY DEFAULT
	//public Room findByidandroomType(int id, String roomType);
}
