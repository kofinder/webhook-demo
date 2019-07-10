package com.finder.hook.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public class HookEvent extends ApplicationEvent {

	private static final long serialVersionUID = -31542921191218018L;

	private final String payload;
	private final String token;

	public HookEvent(HookEventSource source, final String payload, final String token) {
		super(source);
		this.payload = payload;
		this.token = token;
	}

	public final String getPayload() {
		return payload;
	}

	public final String getToken() {
		return token;
	}

}
