package com.ddlab.rnd.exception;

public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = -1337476553418583443L;

	public BadRequestException(String message) {
		super(message);
	}
}
