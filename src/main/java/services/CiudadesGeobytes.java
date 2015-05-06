/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import apis.CiudadesAPI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Service;

/**
 *
 * @author flavio
 */
@Service
public class CiudadesGeobytes implements CiudadesAPI {

    private final static String TARGET
            = "http://gd.geobytes.com/AutoCompleteCity";

    private Client restClient;

    public CiudadesGeobytes() {
        this.restClient = ClientBuilder.newClient();
    }

    @Override
    public String findCiudadesByName(String cityName) {
        String ciudades = "[]";

        WebTarget webTarget
                = restClient.target(TARGET).queryParam("q", cityName);

        Invocation.Builder invocationBuilder
                = webTarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();

        if (response.getStatus() == 200) {
            ciudades = response.readEntity(String.class);
        }

        return ciudades;
    }

}
