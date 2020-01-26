package com.mawote.model.exception;

public class ContaDomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ContaDomainException(String smg) {
		super(smg);
	}

}
