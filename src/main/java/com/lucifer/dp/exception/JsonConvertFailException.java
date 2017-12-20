package com.lucifer.dp.exception;

public class JsonConvertFailException extends RuntimeException {

	private static final long serialVersionUID = 3381254468572553751L;

	public JsonConvertFailException() {
	}

	public JsonConvertFailException(String arg0) {
		super(arg0);
	}

	public JsonConvertFailException(Throwable arg0) {
		super(arg0);
	}

	public JsonConvertFailException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public JsonConvertFailException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
