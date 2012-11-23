package com.mycompany.jaxrs.service;

import com.mycompany.model.Features;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * REST service to manipulate Karaf features
 */
@Path("/")
public interface FeaturesRestService {
    /**
     * Returns an explicit collection of all features in XML format in response to HTTP GET requests.
     * @return the features retrieved
     */

    @GET
    @Path("/features")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Features getFeatures() throws Exception;
}