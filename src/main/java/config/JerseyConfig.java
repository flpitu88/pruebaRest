/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import resources.Greetings;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import resources.AmigosResource;
import resources.CiudadesResource;
import resources.OpcionDeViajeResource;
import resources.PasajeroResource;

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        
        // Enable Spring DI and Jackson configuration
        register(RequestContextFilter.class);
        register(JacksonFeature.class);
        // Application resources
        register(Greetings.class);
        register(PasajeroResource.class);
        register(AmigosResource.class);
        register(OpcionDeViajeResource.class);
        register(CiudadesResource.class);
    }
}
