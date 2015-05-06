/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import greetings.Greeting;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GreetingService {

    public List<Greeting> getEnglishGreetings() {
        return Arrays.asList(
                new Greeting("Hi"),
                new Greeting("Hello"),
                new Greeting("Yo"));
    }
}
