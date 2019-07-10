package com.finder.hook.exception;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public class HookTemplateNotFoundException extends BusinessException {
	private static final long serialVersionUID = 1L;
	
	public HookTemplateNotFoundException(final String name) {
		super("Template with name =========>:" + name);
	}

	public HookTemplateNotFoundException(final Long templateId) {
		super("Template with id =========>:" + templateId);
	}
}
