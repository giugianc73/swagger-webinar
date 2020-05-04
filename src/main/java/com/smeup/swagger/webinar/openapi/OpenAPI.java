package com.smeup.swagger.webinar.openapi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@ApplicationScoped
@Path("services/openapi.yaml")
@Produces(MediaType.TEXT_PLAIN)
public class OpenAPI {

	private Template template;

	@PostConstruct
	public void init() {

		final Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setClassForTemplateLoading(this.getClass(), "/");

		Template template = null;
		try {
			template = configuration.getTemplate("openapi.yaml");
			setTemplate(template);
		} catch (final IOException e) {
			throw new Error(e);
		}
	}

	@GET
	public Response getOpenApiYAML(@Context final HttpServletRequest request) {

		final Template template = getTemplate();

		final StreamingOutput stream = new StreamingOutput() {
			public void write(final OutputStream os) throws IOException, WebApplicationException {
				final Writer writer = new BufferedWriter(new OutputStreamWriter(os));
				try {
					final Map<String, Object> root = new HashMap<String, Object>();
					final String apiURL = request.getRequestURL().toString().replace("openapi.yaml", "");
					root.put("apiURL", apiURL);
					template.process(root, writer);
				} catch (final TemplateException e) {

					throw new Error(e);
				}
			}
		};

		return Response.ok(stream).build();
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(final Template template) {
		this.template = template;
	}
}