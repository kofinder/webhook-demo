package com.finder.hook.event;

import java.io.Serializable;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public class HookEventSource implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String entityName;
	private final String actionName;

	public HookEventSource(final String entityName, final String actionName) {
		this.entityName = entityName;
		this.actionName = actionName;
	}

	public final String getEntityName() {
		return entityName;
	}

	public final String getActionName() {
		return actionName;
	}

}
