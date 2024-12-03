package org.acumen.training.codes;

public class LetterSizeException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message = "Invalid size: [alphanumeric]";

	public LetterSizeException() {
	}

	public LetterSizeException(String message) {
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