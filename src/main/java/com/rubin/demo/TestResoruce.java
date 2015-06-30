package com.rubin.demo;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Singleton
public class TestResoruce {

    @POST
    @Path("/get1/{yy}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void get(MultivaluedMap<String, String> paramsMap) {
        for (Map.Entry<String, List<String>> entry : paramsMap.entrySet()) {
            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue().toArray()));
        }
    }

    @GET
    @Path("/get2/{tt}")
    public void get1(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        Map<String, Cookie> cookieMap = hh.getCookies();
        for (Map.Entry<String, List<String>> entry : headerParams.entrySet()) {
            System.out.printf("headers + " + entry.getKey() +"value" + Arrays.toString(entry.getValue().toArray()));
        }
        for (Map.Entry<String, Cookie> entry : cookieMap.entrySet()) {
            System.out.printf("cokie key " + entry.getKey()  + entry.getValue().getPath());
        }
    }

    @GET
    @Path("/get1/{dd}")
    public void get(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        for (Map.Entry<String, List<String>> entry : pathParams.entrySet()) {
            System.out.println("path: key-" + entry.getKey() + " value-" + Arrays.toString(entry.getValue().toArray()));
        }
        for (Map.Entry<String, List<String>> entry: queryParams.entrySet()){
            System.out.println("query: key-" + entry.getKey() + " value-" + Arrays.toString(entry.getValue().toArray()));
        }
    }

    @GET
    @Path("smooth")
    public void smooth(@DefaultValue("2") @QueryParam("step") Integer step) {
        System.out.println(step);
    }

}
