/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Pasajero;
import apis.PasajerosAPI;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

/**
 *
 * @author Flavio L. Pietrolati
 */
@Path("/pasajeros")
@Produces(MediaType.APPLICATION_JSON)
public class PasajeroResource {

    private final PasajerosAPI pjSrv;

    @Inject
    public PasajeroResource(PasajerosAPI passgService) {
        this.pjSrv = passgService;
    }

    @GET
    @Produces("application/json")
    public List<Pasajero> getPasajeros() {
        return pjSrv.getListado();
    }

    /**
     * Probar mediante un test si esta bien este metodo. De alguna manera tiene
     * que tomar los datos del usuario a crear.
     *
     * @param psj
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response guardarPasajero(Pasajero psj) {
        pjSrv.crearPasajero(psj);
        return Response.status(201)
                .entity("Creado nuevo pasajero " + psj.getIdUser())
                .build();
    }

}
