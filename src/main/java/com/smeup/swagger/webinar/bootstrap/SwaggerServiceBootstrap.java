package com.smeup.swagger.webinar.bootstrap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@Singleton
public class SwaggerServiceBootstrap {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerServiceBootstrap.class);
	
	@PostConstruct
	public void init() {
		LOGGER.info("Startup");
	}
	
	@PreDestroy
	public void destroy() {
		LOGGER.info("Shutdown");
	}
}
