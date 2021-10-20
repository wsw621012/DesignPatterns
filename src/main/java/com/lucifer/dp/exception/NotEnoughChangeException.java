package com.lucifer.dp.exception;

public class NotEnoughChangeException extends RuntimeException {

	private static final long serialVersionUID = -1060341300356155652L;

	public NotEnoughChangeException() {
	}

	public NotEnoughChangeException(String arg0) {
		super(arg0);
	}

	public NotEnoughChangeException(Throwable arg0) {
		super(arg0);
	}

	public NotEnoughChangeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NotEnoughChangeException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
