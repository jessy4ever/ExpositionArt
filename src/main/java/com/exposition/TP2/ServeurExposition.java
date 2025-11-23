package com.exposition.TP2;

import jakarta.xml.ws.Endpoint;

public class ServeurExposition {
    public static void main(String[] args) {
        String url = "http://localhost:8000/ws/exposition";
        Endpoint.publish(url, new ExpositionWS());
        System.out.println("Service publié sur : " + url);
    }
}
