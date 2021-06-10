package com.corona.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<RoomException> handleException(Exception e) {
		
		RoomException roomException = new RoomException();
		roomException.setMesssage(e.getMessage());
		roomException.setTimestamp(LocalDateTime.now());
		
		
		return new ResponseEntity<RoomException>(roomException, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<RoomException> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		RoomException ed = new RoomException();
		ed.setMesssage("Entity validation error!");
		ed.setErrors(errors);
		ed.setTimestamp(LocalDateTime.now());
		
		return new ResponseEntity<RoomException>(ed, HttpStatus.BAD_REQUEST);
	}
}
