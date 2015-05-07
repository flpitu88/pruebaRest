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
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Flavio L. Pietrolati
 */
public class PostPasajeroTest {

    @Test
    public void testPostNuevoPasajero() throws IOException {
        Pasajero pasajero8 = new Pasajero("pasajero8", "apellido8", 888888, new ArrayList());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pasajero8);
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("http://localhost:8080/pasajeros");
        Response response = target.request().accept(MediaType.APPLICATION_JSON)
                .post(Entity.entity(json, MediaType.APPLICATION_JSON), Response.class);
        System.out.println(response.readEntity(String.class));
        Assert.assertEquals(201, response.getStatus());
    }

}
