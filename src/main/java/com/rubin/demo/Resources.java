package com.rubin.demo;

import javax.inject.Singleton;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Singleton
@Path("/services")
public class Resources {

    @Path("/customers")
    public Class<?> getCustomerResource(@Context HttpServletRequest request,@Context ServletConfig config, @Context ServletContext context, @Context HttpServletResponse response,@Context UriInfo ui) {
        System.out.println("" + request + config + context + response);
        for (Map.Entry<String, List<String>> entry : ui.getQueryParameters().entrySet()) {
            System.out.println(entry.getKey() + Arrays.toString(entry.getValue().toArray()));
        }
        return CustomerResource.class;
    }

    @Path("/test")
    public Class<?> getTestResource() {
        return TestResoruce.class;
    }

}



