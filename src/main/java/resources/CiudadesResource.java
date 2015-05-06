/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import apis.CiudadesAPI;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author flavio
 */
@Path("/ciudades")
@Produces(MediaType.APPLICATION_JSON)
public class CiudadesResource {
    
    private final CiudadesAPI srvCiudad;
    
    @Inject
    public CiudadesResource(CiudadesAPI cityServ) {
        this.srvCiudad = cityServ;
    }
    
    @GET
    @Path("{city}")
    @Produces("application/json")
    public String getCiudadesPosibles(@PathParam("city") String ciudad) {
        return srvCiudad.findCiudadesByName(ciudad);
    }
    
}
