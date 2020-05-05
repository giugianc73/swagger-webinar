package com.smeup.swagger.webinar.api;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Path("services")
public class SwaggerResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerResource.class);	

	@Path("/simpleListGet")
	@GET
	public void simpleListGet(@Context HttpServletRequest requestHttp, @Context HttpServletResponse responseHttp) {
		responseHttp.setStatus(HttpServletResponse.SC_OK);
		responseHttp.setContentType("application/json");
		
		try {
			responseHttp.getWriter().print(getSimpleList());
			responseHttp.flushBuffer();	
		} catch (IOException e) {
				responseHttp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			LOGGER.error("", e);
		}
	}

	@Path("/simpleNameGet/{id}")
	@GET
	public void simpleNameGet(@PathParam(value = "id") String id, @Context HttpServletRequest requestHttp, @Context HttpServletResponse responseHttp) {
		responseHttp.setStatus(HttpServletResponse.SC_OK);
		responseHttp.setContentType("application/json");
		
		try {
			responseHttp.getWriter().print(getSimpleId(id));
			responseHttp.flushBuffer();	
		} catch (IOException e) {
				responseHttp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			LOGGER.error("", e);
		}
	}

	@Path("/simpleNameQueryGet")
	@GET
	public void simpleNameQueryGet(@Context HttpServletRequest requestHttp, @Context HttpServletResponse responseHttp) {
		responseHttp.setStatus(HttpServletResponse.SC_OK);
		responseHttp.setContentType("application/json");
		
		String id = requestHttp.getParameter("id");
		if(id==null) {
			id = "";
		}
		
		try {
			responseHttp.getWriter().print(getSimpleId(id));
			responseHttp.flushBuffer();	
		} catch (IOException e) {
				responseHttp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			LOGGER.error("", e);
		}
	}
	
	@Path("/simpleListPost")
	@POST
	public void simpleListPost(@Context HttpServletRequest requestHttp, @Context HttpServletResponse responseHttp) {
		responseHttp.setStatus(HttpServletResponse.SC_OK);
		responseHttp.setContentType("application/json");
		
		try {
			responseHttp.getWriter().print(getSimpleList());
			responseHttp.flushBuffer();	
		} catch (IOException e) {
				responseHttp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			LOGGER.error("", e);
		}
	}

	@Path("/simpleNamePost/{id}")
	@POST
	public void simpleNamePost(@PathParam(value = "id") String id, @Context HttpServletRequest requestHttp, @Context HttpServletResponse responseHttp) {
		responseHttp.setStatus(HttpServletResponse.SC_OK);
		responseHttp.setContentType("application/json");
		
		try {
			responseHttp.getWriter().print(getSimpleId(id));
			responseHttp.flushBuffer();	
		} catch (IOException e) {
				responseHttp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			LOGGER.error("", e);
		}
	}
	
	@Path("/simpleNameQueryPost")
	@POST
	public void simpleNameQueryPost(@Context HttpServletRequest requestHttp, @Context HttpServletResponse responseHttp) {
		responseHttp.setStatus(HttpServletResponse.SC_OK);
		responseHttp.setContentType("application/json");
		
		String id = requestHttp.getParameter("id");
		if(id==null) {
			id = "";
		}
		
		try {
			responseHttp.getWriter().print(getSimpleId(id));
			responseHttp.flushBuffer();	
		} catch (IOException e) {
				responseHttp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			LOGGER.error("", e);
		}
	}

	
	private JsonObject getSimpleList() {
		Map<String, String> map = createMap(); 
		
        JsonArray jArray = new JsonArray();
		JsonObject jResponse = new JsonObject();

		for(Entry<String, String> record : map.entrySet()) {
			JsonObject jObject = new JsonObject();
	        jObject.addProperty("name", record.getKey());
	        jObject.addProperty("car", record.getValue());
			jArray.add(jObject);
		}
		
		jResponse.add("names", jArray);
		
		return jResponse;
	}

	private JsonObject getSimpleId(String id) {
		String value = createMap().get(id); 
		JsonObject jObject = new JsonObject();
		if(value != null) {
	        jObject.addProperty("name", id);
	        jObject.addProperty("car", value);
		}
        return jObject;
	}
	
	private Map<String, String> createMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("Giuliano", "Scenic");
		map.put("Francesco", "Fiesta");
		map.put("Giovanni", "Touran");

		return map;
	}
}