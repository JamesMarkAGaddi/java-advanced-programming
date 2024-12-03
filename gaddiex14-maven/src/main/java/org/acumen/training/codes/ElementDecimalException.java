package org.acumen.training.codes;

public class ElementDecimalException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message = "Invalid element value: [floating-point]";

	public ElementDecimalException() {
	}

	public ElementDecimalException(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void printStackTrace() {
		System.err.println(this.message);
	}


}
