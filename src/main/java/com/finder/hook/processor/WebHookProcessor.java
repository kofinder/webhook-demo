package com.finder.hook.processor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import retrofit2.Callback;


/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
@Service
public class WebHookProcessor implements HookProcessor {

	@Override
	public void process(String payload, String entityName, String actionName, String tenantIdentifier, String authToken) {
		final String url = "https://d683adca.ngrok.io";
		final String contentType = "json";
		
		// something to do
		sendRequest(url, contentType, payload, entityName, actionName, tenantIdentifier, authToken);
	}
	
	
	@SuppressWarnings("unchecked")
	private void sendRequest(final String url, final String contentType,
			final String payload, final String entityName,
			final String actionName, final String tenantIdentifier,
			@SuppressWarnings("unused") final String authToken) {

		final String fineractEndpointUrl = "http://localhost:8095/api/v1/"; //System.getProperty("baseUrl");
		final WebHookService service = ProcessorHelper.createWebHookService(url);

		@SuppressWarnings("rawtypes")
		final Callback callback = ProcessorHelper.createCallback(url);
		if (contentType.equalsIgnoreCase("json") || contentType.contains("json")) {
			final JsonObject json = new JsonParser().parse(payload).getAsJsonObject();
			service.sendJsonRequest(entityName, actionName, tenantIdentifier, fineractEndpointUrl, json, callback);
		} else {
			Map<String, String> map = new HashMap<>();
			map = new Gson().fromJson(payload, map.getClass());
			service.sendFormRequest(entityName, actionName, tenantIdentifier, fineractEndpointUrl, map, callback);
		}

	}

}
