package org.acumen.training.codes;

public class InvalidSizeException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message = "Array size cannot be negative";

	public InvalidSizeException() {
	}

	public InvalidSizeException(String message) {
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
