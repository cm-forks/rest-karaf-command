package com.mycompany.jaxrs.service;

import com.mycompany.model.Contexts;
import com.mycompany.model.Features;
import com.mycompany.model.Routes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * REST service to manage Camel Contexts and Routes
 */
@Path("/")
public interface CamelRestService {

    @GET
    @Path("/contexts")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Contexts getContexts() throws Exception;

    @GET
    @Path("/routes")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Routes getRoutes() throws Exception;

}
