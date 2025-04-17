package org.acme.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.base.types.StringType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import static org.acme.rest.ParametersResource.URI_STRING_TYPE_PATH;
import static org.acme.rest.ParametersResource.URI_STRING_TYPE_QUERY;

@Path("/parameters")
@RegisterRestClient(configKey = "parameters")
public interface ParametersClientApi {

    @Path(URI_STRING_TYPE_PATH + "/{stringValue}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    String stringTypePath(@PathParam("stringValue") final StringType stringValue);


    @Path(URI_STRING_TYPE_QUERY)
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    String stringTypeQuery(@QueryParam("stringValue") final StringType stringValue);
}
