/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetings;

import org.springframework.stereotype.Service;
 
import java.util.Arrays;
 
@Service
public class GreetingService {
    public Iterable<Greeting> getEnglishGreetings() {
        return Arrays.asList(
            new Greeting("Hi"),
            new Greeting("Hello"),
            new Greeting("Yo"));
    }
}
