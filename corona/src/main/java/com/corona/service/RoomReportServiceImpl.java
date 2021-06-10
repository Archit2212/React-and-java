package com.corona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corona.entities.RoomReport;
import com.corona.exception.RoomReportException;
import com.corona.repository.RoomReportRepository;
import com.corona.service.IRoomReportService;

@Service
public class RoomReportServiceImpl implements IRoomReportService {

	@Autowired
	private RoomReportRepository roomreportRepository;
	@Override
	public  boolean createRoomReport(RoomReport roomreport) {
		// TODO Auto-generated method stub
		roomreportRepository.save(roomreport);

		return false;
	}

	@Override
	public boolean updateRoomReport(RoomReport roomreport) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RoomReport findById(int id) {
		// TODO Auto-generated method stub
		if (!roomreportRepository.existsById(id)) {
			throw new RoomReportException("Room Not Found");
		}

		RoomReport e = roomreportRepository.findById(id).get();
		return e;
	}

}
