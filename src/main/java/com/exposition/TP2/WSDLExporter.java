package com.exposition.TP2;

import jakarta.xml.ws.Endpoint;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WSDLExporter {
    public static void main(String[] args) throws Exception {
        String wsdlFile = "src/main/resources/TP2/wsdl/exposition.wsdl";
        String address = "http://localhost:8000/ws/exposition";

        Endpoint endpoint = Endpoint.create(new ExpositionWS());
        try (OutputStream out = new FileOutputStream(wsdlFile)) {
            endpoint.publish(address);
            System.out.println("WSDL généré dans : " + wsdlFile);
        }
    }
}
