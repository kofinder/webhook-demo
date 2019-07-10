package com.finder.hook.exception;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public class HookNotFoundException extends BusinessException {
	private static final long serialVersionUID = 1L;

	public HookNotFoundException(final String name) {
		super("hook does not exist =====>:"+ name);
	}

	public HookNotFoundException(final Long hookId) {
		super("hook does not exist =====>:"+ hookId);
	}
}
