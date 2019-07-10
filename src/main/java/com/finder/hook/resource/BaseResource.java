package com.finder.hook.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */

@Component
@Path("hooks")
@Scope("singleton")
public class BaseResource {
	
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
	public String helloworld() {
		return "hello world";
	}
}
