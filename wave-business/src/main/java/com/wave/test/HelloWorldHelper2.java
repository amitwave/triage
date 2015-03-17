package com.wave.test;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: amit
 * Date: 30/11/2013
 * Time: 12:57
 * To change this template use File | Settings | File Templates.
 */
@Component("hello2")
public class HelloWorldHelper2 implements HelloWorldHelperI {

    public void helloWorld(String name){
        System.err.println("\n\nHello world helper 2 " + name);
    }
}
