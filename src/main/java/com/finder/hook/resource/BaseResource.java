package com.finder.hook.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.finder.hook.service.HookService;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */

@Component
@Path("hooks")
@Scope("singleton")
public class BaseResource {
	
	@Autowired private HookService webHook;
	
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
	public String helloworld(@Context final UriInfo uriInfo,
	            @QueryParam("payload") final String payload, 
	            @QueryParam("entityName") final String entityName,
	            @QueryParam("actionName") final String actionName,
	            @QueryParam("tenantId") final String tenantIdentifier,
	            @QueryParam("authToken") final String authToken) {
		webHook.publishEvent(payload, entityName, actionName, tenantIdentifier, authToken);
		return "hello world";
	}
}
