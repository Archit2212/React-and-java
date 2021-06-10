package com.corona.exception;


import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;


@Data
public class RoomException {

	private String messsage;
	private LocalDateTime timestamp;
	private List<String> errors;
}
