package org.acme.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.base.types.StringType;

@Path("/parameters")
public class ParametersResource {

    public static final String URI_STRING_TYPE_PATH = "/stringTypePath";
    public static final String URI_STRING_TYPE_QUERY = "/stringTypeQuery";


    @Path(URI_STRING_TYPE_PATH + "/{stringValue}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String stringTypePath(@PathParam("stringValue") final StringType stringValue) {
        return stringValue.getValue();
    }


    @Path(URI_STRING_TYPE_QUERY)
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String stringTypeQuery(@QueryParam("stringValue") final StringType stringValue) {
        return stringValue.getValue();
    }
}
