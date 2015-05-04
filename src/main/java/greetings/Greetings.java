/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetings;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/greetings")
@Produces(MediaType.APPLICATION_JSON)
public class Greetings {
    private final GreetingService greetingService;
 
    @Inject
    public Greetings(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
 
    @GET
    public Response getGreetings() {
        return Response
            .ok(greetingService.getEnglishGreetings())
            .build();
    }
}
