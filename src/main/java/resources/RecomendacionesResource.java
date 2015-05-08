/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import apis.RecomendacionesAPI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Recomendacion;

/**
 *
 * @author Flavio L. Pietrolati
 */
@Path("/recomendaciones")
@Produces(MediaType.APPLICATION_JSON)
public class RecomendacionesResource {
    
    private final RecomendacionesAPI srvRecom;
    
    @Inject
    public RecomendacionesResource(RecomendacionesAPI recsrv){
        this.srvRecom = recsrv;
    }
    
    @GET
    @Path("{userId}")
    @Produces("application/json")
    public List<Recomendacion> getRecomendacionesDelUsuario(@PathParam("userId") String id){
        return srvRecom.getRecomendacionesDeUsario(Integer.parseInt(id));
    }
    
}
