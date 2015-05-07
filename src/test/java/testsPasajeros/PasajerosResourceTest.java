/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsPasajeros;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Pasajero;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author flavio
 */
public class PasajerosResourceTest {

    @Test
    public void testGetListaDePasajeros() {
        ClientConfig config = new ClientConfig().register(new JacksonFeature());
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("http://localhost:8080/pasajeros");
        final Invocation.Builder invocationBuilder = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        Assert.assertTrue(response != null);
        List<Pasajero> lista = response.readEntity(new GenericType<List<Pasajero>>() {});
        Assert.assertEquals(7, lista.size());
        Assert.assertTrue(response.getStatusInfo().getStatusCode() == 200);
    }

    @Test
    public void testGetPasajero() {
        ClientConfig config = new ClientConfig().register(new JacksonFeature());
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("http://localhost:8080/pasajeros/1");       
        final Invocation.Builder invocationBuilder = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        Pasajero pass = response.readEntity(new GenericType<Pasajero>() {});
        Assert.assertEquals(1, pass.getIdUser());
        Assert.assertEquals(200, response.getStatusInfo().getStatusCode());
    }

}
