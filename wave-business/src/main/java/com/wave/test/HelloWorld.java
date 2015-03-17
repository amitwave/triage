package com.wave.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: amit
 * Date: 30/11/2013
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */
@Component
public class HelloWorld {

    @Autowired
    //@Qualifier("hello2")
    HelloWorldHelperI helloWorldHelper;

    @Autowired
    @Qualifier("helloWorldHelper")
    HelloWorldHelperI helloWorldHelper2;



    public void sayHello(String name) {
        System.err.println("\n=============Hello ==== " + name);
        helloWorldHelper.helloWorld(name);
        helloWorldHelper2.helloWorld(name);
    }

}
