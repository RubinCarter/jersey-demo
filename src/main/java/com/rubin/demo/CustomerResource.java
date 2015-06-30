package com.rubin.demo;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class CustomerResource {

    private static final Map<String, Customer> customers = new HashMap<>();
    static {
        customers.put("001", new Customer("name1", 1, "addr1"));
        customers.put("002", new Customer("name2", 2, "addr2"));
        customers.put("003", new Customer("name3", 3, "addr3"));
        customers.put("004", new Customer("name4", 4, "addr4"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response add(@BeanParam Customer customer, String name1) {
        customers.put(customer.getName(), customer);
        System.out.println(name1 + "xxx");
        return Response.status(500).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Collection<Customer> getCustomers() {
        return customers.values();
    }

    @GET
    @Path("{id: [0-9]*}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Customer getCustomer(@PathParam("id") String id) {
        return customers.get(id);
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public boolean deleteCustomer(@PathParam("id") String id) {
        if(customers.containsKey(id)) {
            customers.remove(id);
            return true;
        }else{
            return false;
        }
    }

}