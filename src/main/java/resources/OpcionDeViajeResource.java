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
import com.google.appengine.repackaged.org.joda.time.format.DateTimeFormat;
import com.google.appengine.repackaged.org.joda.time.format.DateTimeFormatter;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import model.OpcionDeViaje;

/**
 *
 * @author flavio
 */
@Path("/opcionDeViaje")
@Produces(MediaType.APPLICATION_JSON)
public class OpcionDeViajeResource {

    private final OpcionViajeAPI srvOpcViajes;

    @Inject
    public OpcionDeViajeResource(OpcionViajeAPI opViajeService) {
        this.srvOpcViajes = opViajeService;
    }

    @GET
    @Produces("application/json")
    // Ejemplo: http://localhost:8080/opcionDeViaje?aeroOrigen=MIA&aeroDestino=BUE&fechaIda=11/11/2015&fechaVuelta=11/12/2015
    public List<OpcionDeViaje> findOpcionesDeViaje(
            @QueryParam("aeroOrigen") String aeroOrigen, // iata code refactor
            @QueryParam("aeroDestino") String aeroDestino, // iata code refactor
            @QueryParam("fechaIda") String fechaIda, // refactor a date time
            @QueryParam("fechaVuelta") String fechaVuelta // refactor a datetime
    ) {

        // tener en cuenta el formato en la UI por el momento
        DateTimeFormatter fmt = DateTimeFormat
                .forPattern("dd/MM/yyyy");

        return this.srvOpcViajes
                .findOpcionesDeViaje(
                        aeroOrigen,
                        aeroDestino,
                        fmt.parseDateTime(fechaIda),
                        fmt.parseDateTime(fechaVuelta));

    }
}
