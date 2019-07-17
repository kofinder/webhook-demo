package com.finder.hook.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finder.hook.domain.Hook;
import com.finder.hook.event.HookEvent;
import com.finder.hook.event.HookEventSource;
import com.finder.hook.processor.HookProcessor;
import com.finder.hook.processor.HookProcessorProvider;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
@Service
public class HookFinderListener implements HookListener {
	
	private final HookProcessorProvider hookProcessorProvider;
	
	@Autowired
	public HookFinderListener(final HookProcessorProvider hookProcessorProvider) {
		this.hookProcessorProvider = hookProcessorProvider;
		
	}

	@Override
	public void onApplicationEvent(HookEvent event) {
		final HookEventSource hookEventSource = event.getSource();
        final String entityName = hookEventSource.getEntityName();
        final String actionName = hookEventSource.getActionName();
        final String payload = event.getPayload();
        final Hook hook = new Hook();
        final HookProcessor processor = this.hookProcessorProvider.getProcessor(hook);
        processor.process(payload, entityName, actionName, null, null);
	}

}
