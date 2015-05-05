/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import greetings.GreetingService;
import greetings.Greetings;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        // Enable Spring DI and Jackson configuration
        register(RequestContextFilter.class);
        register(JacksonObjectMapperConfig.class);
        // Application resources
        register(Greetings.class);
        register(GreetingService.class);
    }
}
