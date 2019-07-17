package com.finder.hook.processor;

import java.util.Map;

import com.google.gson.JsonObject;
import com.squareup.okhttp.Response;

import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
public interface WebHookService {

	final static String ENTITY_HEADER = "x-finder-entity";
	final static String ACTION_HEADER = "x-finder-action";
	final static String TENANT_HEADER = "x-finder-id";
	final static String ENDPOINT_HEADER = "x-finder-endpoint";
	final static String API_KEY_HEADER = "x-finder-api-key";

	// Ping
	@GET("/")
	Response sendEmptyRequest();

	// Template - Web
	@POST("/hook")
	void sendJsonRequest(@Header(ENTITY_HEADER) String entityHeader,
			@Header(ACTION_HEADER) String actionHeader,
			@Header(TENANT_HEADER) String tenantHeader,
			@Header(ENDPOINT_HEADER) String endpointHeader,
			@Body JsonObject json, 
			Callback<Response> callback);

	@FormUrlEncoded
	@POST("/hook")
	void sendFormRequest(@Header(ENTITY_HEADER) String entityHeader,
			@Header(ACTION_HEADER) String actionHeader,
			@Header(TENANT_HEADER) String tenantHeader,
			@Header(ENDPOINT_HEADER) String endpointHeader,
			@FieldMap Map<String, String> params, 
			Callback<Response> callback);
}
