package com.lucifer.dp.exception;

public class InitFailException extends RuntimeException {

	private static final long serialVersionUID = -2126712888419105911L;

	public InitFailException(String arg0) {
		super(arg0);
	}
	
	public InitFailException(Throwable arg0) {
		super(arg0);
	}
}
