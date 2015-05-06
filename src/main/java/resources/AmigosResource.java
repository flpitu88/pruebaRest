/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import apis.PasajerosAPI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Pasajero;

/**
 *
 * @author flavio
 */
@Path("/amigos")
@Produces(MediaType.APPLICATION_JSON)
public class AmigosResource {
    
    private final PasajerosAPI pjSrv;

    @Inject
    public AmigosResource(PasajerosAPI passgService) {
        this.pjSrv = passgService;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public List<Pasajero> getAmigosDeUsuario(@PathParam("id") String id) {
        return pjSrv.getAmigosDePasajero(Integer.parseInt(id));
    }
    
}
