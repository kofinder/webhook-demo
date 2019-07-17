package com.finder.hook.processor;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.finder.hook.domain.Hook;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
@Service
public class HookProcessorProvider implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext( final ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public HookProcessor getProcessor(final Hook hook) {
		return this.applicationContext.getBean("webHookProcessor", WebHookProcessor.class);
	}
}
