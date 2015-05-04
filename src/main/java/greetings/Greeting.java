/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetings;

import com.fasterxml.jackson.annotation.JsonValue;
 
public class Greeting {
    private final String text;
 
    public Greeting(String text) {
        this.text = text;
    }
 
    @JsonValue
    public String getText() {
        return text;
    }
}
