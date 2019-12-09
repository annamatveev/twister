package com.example.twister;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.util.ArrayList;

@Path("/getWordSkeleton")
public class HelloWorld {

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response sayHtmlHello(@QueryParam( "word" ) String word) {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String nameParam = queryParams.getFirst("word");
        ArrayList<String> perms = Confusable.getConfusables(nameParam);
        GenericEntity<ArrayList<String>> entity = new GenericEntity<ArrayList<String>>(perms) {};
        return Response.ok(entity).build();
    }

}