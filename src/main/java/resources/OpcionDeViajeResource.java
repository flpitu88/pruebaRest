/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import apis.OpcionViajeAPI;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import model.OpcionDeViaje;

/**
 *
 * @author flavio
 */
@Path("/opciondeviaje")
@Produces(MediaType.APPLICATION_JSON)
public class OpcionDeViajeResource {

    private final OpcionViajeAPI srvOpcViajes;

    @Inject
    public OpcionDeViajeResource(OpcionViajeAPI opViajeService) {
        this.srvOpcViajes = opViajeService;
    }

    @GET
    @Produces("application/json")
    public List<OpcionDeViaje> consultaOpcionesDeViaje(
            @QueryParam("aeroOrigen") String aeroOrigen, // iata code refactor
            @QueryParam("aeroDestino") String aeroDestino, // iata code refactor
            @QueryParam("fechaIda") String fechaIda, // refactor a date time
            @QueryParam("fechaVuelta") String fechaVuelta // refactor a datetime
    ) {
        
        return this.srvOpcViajes
                .findOpcionesDeViaje(
                        aeroOrigen,
                        aeroDestino,
                        fechaIda,
                        fechaVuelta);

    }

}
