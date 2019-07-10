package com.finder.hook.processor;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public interface HookProcessor {
	void process(String payload, String entityName, String actionName, String tenantIdentifier, String authToken);
}
