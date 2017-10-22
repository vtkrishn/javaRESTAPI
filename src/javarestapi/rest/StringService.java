package javarestapi.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/rest")
@Produces(MediaType.APPLICATION_JSON)
public class StringService {
    
    @GET
    public String get(){
        String result = "{\"result\" : \"Resume\"}";
        return result;
    }
}