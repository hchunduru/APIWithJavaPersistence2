package com.egen.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason="user not found")
public class UserNotFoundException extends Exception{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

}
