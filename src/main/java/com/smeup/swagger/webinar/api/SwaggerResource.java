package com.smeup.swagger.webinar.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

@Path("services")
public class SwaggerResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerResource.class);	


	@Path("/simpleList")
	@GET
	public void simpleList(@Context HttpServletRequest requestHttp, @Context HttpServletResponse responseHttp) {
		responseHttp.setStatus(HttpServletResponse.SC_OK);
		responseHttp.setContentType("application/json");
		final JsonObject jsonResp = new JsonObject();
		try {
			responseHttp.getWriter().print(jsonResp);
			responseHttp.flushBuffer();	
		} catch (IOException e) {
				responseHttp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			LOGGER.error("", e);
		}
	}
}
