package com.finder.hook.listener;

import org.springframework.context.ApplicationListener;

import com.finder.hook.event.HookEvent;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public interface HookListener extends ApplicationListener<HookEvent> {}
