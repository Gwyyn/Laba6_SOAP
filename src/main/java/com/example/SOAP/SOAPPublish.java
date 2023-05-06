package com.example.SOAP;

import com.example.learning.LearningServiceImpl;

import javax.xml.ws.Endpoint;

public class SOAPPublish {
    public static void main(String[] args) {

        Endpoint endpoint = Endpoint.create(new LearningServiceImpl());
        endpoint.publish("http://localhost:8085/LearningService");

        System.out.println("LearningService is published!");
    }
}
