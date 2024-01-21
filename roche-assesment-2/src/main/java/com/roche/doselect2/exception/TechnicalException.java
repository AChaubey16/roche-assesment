package com.roche.doselect2.exception;

import org.springframework.http.HttpStatus;

public class TechnicalException extends Exception {

	private static final long serialVersionUID = 1L;
	
    private HttpStatus errorcode;
	
	private String description;
	
	public HttpStatus getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(HttpStatus errorcode) {
		this.errorcode = errorcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TechnicalException(HttpStatus errorcode, String description) {
		super();
		this.errorcode = errorcode;
		this.description = description;
	}

	public TechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	

}
