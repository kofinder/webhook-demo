package com.finder.hook.service;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.finder.hook.event.HookEvent;
import com.finder.hook.event.HookEventSource;

@Service
public class HookService {
	private final ApplicationContext applicationContext;
	
	public HookService(final ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public void publishEvent(String payload, String entityName, String actionName, String tenantIdentifier, String authToken) {
		final HookEventSource hookEventSource = new HookEventSource(entityName, actionName);
		final HookEvent applicationEvent = new HookEvent(hookEventSource, payload, authToken);
		applicationContext.publishEvent(applicationEvent);
	}
}
