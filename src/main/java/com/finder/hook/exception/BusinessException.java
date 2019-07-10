package com.finder.hook.exception;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public abstract class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public BusinessException(final String message) {
		super(message);
	}

	public BusinessException(final String message, final Throwable cause) {
		super(message, cause);
		cause.printStackTrace();
	}

	public BusinessException(final Throwable cause) {
		super(cause);
		cause.printStackTrace();
	}
}
