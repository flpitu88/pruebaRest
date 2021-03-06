/**
 *
 */
package services;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import apis.OpcionViajeAPI;
import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.google.appengine.repackaged.org.joda.time.format.DateTimeFormat;
import model.OpcionDeViaje;
import model.OpcionesDeViaje;
import org.springframework.stereotype.Service;

@Service
public class Despegar implements OpcionViajeAPI {

    private static final String TARGET
            = "https://api.despegar.com/v3/flights/itineraries";

    private Client restClient;

    public Despegar() {
        this.restClient = ClientBuilder.newClient();
    }

    @Override
    public List<OpcionDeViaje> findOpcionesDeViaje(String aeroOrigen,
            String aeroDestino, String fechaIda, String fechaVuelta) {

        String pattern = "dd-MM-yy";

        DateTime fIda = DateTime.parse(fechaIda, DateTimeFormat.forPattern(pattern));
        DateTime fVuelta = DateTime.parse(fechaVuelta, DateTimeFormat.forPattern(pattern));

        System.out.println("########## FECHA IDA: " + fIda.toString());
        System.out.println("########## FECHA VUELTA: " + fVuelta.toString());

//        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
        OpcionesDeViaje opcionesDeViaje = null;

        WebTarget webTarget
                = restClient.target(TARGET)
                .queryParam("site", "ar")
                .queryParam("from", aeroOrigen)
                .queryParam("to", aeroDestino)
                //                .queryParam("departure_date", fmt.print(fechaIda))
                //                .queryParam("return_date", fmt.print(fechaVuelta))
                .queryParam("departure_date", fIda)
                .queryParam("return_date", fVuelta)
                .queryParam("adults", "1");

        Invocation.Builder invocationBuilder
                = webTarget.request(MediaType.APPLICATION_JSON).header("X-ApiKey",
                        "19638437094c4892a8af7cdbed49ee43");

        Response response = invocationBuilder.get();

        if (response.getStatus() == 200) {
            opcionesDeViaje = response.readEntity(OpcionesDeViaje.class);
        }

        return opcionesDeViaje.getItems();

    }

}
