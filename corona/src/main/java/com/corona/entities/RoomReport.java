package com.corona.entities;

	import java.time.LocalDate;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToOne;

	import lombok.Data;

	@Entity
	@Data
	public class RoomReport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roomReportId;
	@Column(name = "description", length = 15)
	private String description;

	@Column(name = "dateOfReport", length = 15)
	private LocalDate dateOfReport;


	@OneToOne
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room room;
	}
