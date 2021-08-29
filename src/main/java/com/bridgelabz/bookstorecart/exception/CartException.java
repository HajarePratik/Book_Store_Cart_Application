package com.bridgelabz.bookstorecart.exception;

import org.springframework.http.HttpStatus;

public class CartException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CartException(String message)
	{
		super(message);
	}
	public CartException(int statusCode, String statusmessage)
	{
		super(statusmessage);
	}
	public CartException(String string, HttpStatus ok, Object object, String string2) {
		// TODO Auto-generated constructor stub
	}
	

	

}
