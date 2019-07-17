package com.finder.hook;

import java.net.UnknownHostException;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.finder.hook.resource.BaseApiResource;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */
@Configuration
public class JerseyConfiguration extends ResourceConfig{
	
	@Value("${spring.jersey.application-path:/}")
    private String apiPath;
	
	@Autowired
    public JerseyConfiguration() throws UnknownHostException {
        register(BaseApiResource.class);
        configureSwagger();
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }

    public void configureSwagger() {
        this.register(ApiListingResource.class);
        BeanConfig config = new BeanConfig();
        config.setTitle("hookfinder");
        config.setDescription("finder webhook example");
        config.setVersion("1.0.0");
        config.setBasePath(this.apiPath);
        config.setSchemes(new String[] { "http", "https" });
        config.setResourcePackage("com.finder.hook");
        config.setScan(true);
    }
}
