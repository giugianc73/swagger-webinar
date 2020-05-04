package com.smeup.swagger.webinar.api;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;

import com.smeup.swagger.webinar.openapi.OpenAPI;


@ApplicationScoped
@ApplicationPath("api")
public class SwaggerApplication extends javax.ws.rs.core.Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(SwaggerResource.class);		
		s.add(OpenAPI.class);
		return s;
	}
}
