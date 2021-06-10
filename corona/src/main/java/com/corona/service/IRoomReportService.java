package com.corona.service;

	import com.corona.entities.RoomReport;

	public interface IRoomReportService {
		public boolean createRoomReport(RoomReport roomreport) ;
		
		public boolean updateRoomReport(RoomReport roomreport);
		
		public RoomReport findById(int id);

	}
