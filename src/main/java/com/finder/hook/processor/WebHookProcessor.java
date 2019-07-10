package com.finder.hook.processor;

import org.springframework.stereotype.Service;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
@Service
public class WebHookProcessor implements HookProcessor {

	@Override
	public void process(String payload, String entityName, String actionName, String tenantIdentifier,
			String authToken) {

		// something to do
	}

}
