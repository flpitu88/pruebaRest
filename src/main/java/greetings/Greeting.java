/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greetings;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {

    @JsonProperty("text")
    private String text;

    public Greeting() {
    }

    public Greeting(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
