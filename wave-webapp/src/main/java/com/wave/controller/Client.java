package com.wave.controller;


import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Client {

       public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/wave/xml";
        User user = new User();
        user.setEmail("a@a.com");
        user.setName("amit");
           Map<String, String> en = new HashMap<String, String>();
           en.put("name", "sadg");
           en.put("email", "sadg@aa.com");

   //     restTemplate.postForLocation(url, user);


        String result = restTemplate.postForObject(url, user, String.class);

        System.out.println(result);


    }
}
