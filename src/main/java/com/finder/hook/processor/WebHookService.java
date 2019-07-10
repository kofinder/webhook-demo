package com.finder.hook.processor;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public interface WebHookService {

	final static String ENTITY_HEADER = "x-finder-entity";
	final static String ACTION_HEADER = "x-finder-action";
	final static String TENANT_HEADER = "x-finder-id";
	final static String ENDPOINT_HEADER = "x-finder-endpoint";
	final static String API_KEY_HEADER = "x-fineract-api-key";

	// Ping
	@GET("/")
	Response sendEmptyRequest();

	// Template - Web
	@POST("/")
	void sendJsonRequest(@Header(ENTITY_HEADER) String entityHeader,
			@Header(ACTION_HEADER) String actionHeader,
			@Header(TENANT_HEADER) String tenantHeader,
			@Header(ENDPOINT_HEADER) String endpointHeader,
			@Body String result, Callback<Response> callBack);

	@FormUrlEncoded
	@POST("/")
	void sendFormRequest(@Header(ENTITY_HEADER) String entityHeader,
			@Header(ACTION_HEADER) String actionHeader,
			@Header(TENANT_HEADER) String tenantHeader,
			@Header(ENDPOINT_HEADER) String endpointHeader,
			@FieldMap Map<String, String> params, Callback<Response> callBack);
}
