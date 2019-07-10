package com.finder.hook.domain;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public class Hook {
	private String name;
	private Boolean isActive;

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Boolean getIsActive() {
		return isActive;
	}

	public final void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
