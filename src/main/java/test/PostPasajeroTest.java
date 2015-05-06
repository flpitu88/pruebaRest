/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Flavio L. Pietrolati
 */
public class PostPasajeroTest extends JerseyTest {

//    @Override
//    protected Application configure() {
//        this.enable(TestProperties.LOG_TRAFFIC);
//        this.enable(TestProperties.DUMP_ENTITY);
//        return new ResourceConfig(PasajeroResource.class);
//    }

    @Test
    public void testPostNuevoPasajero() {
        String payload = "\r\n{\r\n\"query\": \"google \",\r\n\"rows\": 50,\r\n\"return_docs\": true,\r\n\"is_facet\": true\r\n}"; //this is escapped json string in single line
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target("http://localhost:8080/pasajeros");
        Response response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(payload, MediaType.APPLICATION_JSON), Response.class);
//                    processresponse(response); //This could be any method which processes your json response and gets you your desired data.
        System.out.println(response.readEntity(String.class));
        Assert.assertTrue(true);
    }

}
