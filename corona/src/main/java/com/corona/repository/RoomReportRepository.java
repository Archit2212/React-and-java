package com.corona.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.corona.entities.RoomReport;

	@Repository
	public interface RoomReportRepository extends JpaRepository<RoomReport, Integer> {

	}
