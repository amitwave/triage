package com.wave.test;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: amit
 * Date: 30/11/2013
 * Time: 12:57
 * To change this template use File | Settings | File Templates.
 */
@Component
public class HelloWorldHelper implements HelloWorldHelperI {

    public void helloWorld(String name){
        System.err.println("\n\nHello world helper " + name);
    }
}
