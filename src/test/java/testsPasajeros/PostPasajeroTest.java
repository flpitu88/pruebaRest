/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsPasajeros;

import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Pasajero;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Flavio L. Pietrolati
 */
public class PostPasajeroTest {

    // FIXME: este test falla, hay que arreglarlo, retorna http 400
    // Desde Curl: curl localhost:9000/sync -H "Content-type:application/json" -X POST -d @json.txt
    @Test
    public void testPostNuevoPasajero() throws IOException {

        ClientConfig config = new ClientConfig().register(new JacksonFeature());
        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target("http://localhost:8080/pasajeros");
        
        Pasajero pasajero8 = new Pasajero("pasajero8", "apellido8", 888888, new ArrayList<Integer>());
        pasajero8.setIdUser(8);
        
        Response response = target.request()
                .post(Entity.entity(
                        pasajero8,
                        MediaType.APPLICATION_JSON_TYPE));
//        Assert.assertEquals("hola", response.getEntity().toString());
        Assert.assertEquals(201, response.getStatus());

    }

}
