package com.exposition.TP2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.Service;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientExpositionTest {

    private static final String URL_SERVICE = "http://localhost:8000/ws/exposition";

    @BeforeAll
    static void startServer() {
        // On démarre le serveur pour le test
        Endpoint.publish(URL_SERVICE, new ExpositionWS());
    }

    @Test
    void testGetExpositionName() throws Exception {
        URL wsdlURL = new URL(URL_SERVICE + "?wsdl");
        QName SERVICE_NAME = new QName("http://service.exposition.com/", "ExpositionService");
        Service service = Service.create(wsdlURL, SERVICE_NAME);

        ExpositionService proxy = service.getPort(ExpositionService.class);

        String nomExposition = proxy.getNomExposition();
        assertEquals("Lumières et Couleurs", nomExposition, "Le nom de l'exposition doit correspondre");
    }

    @Test
    void testGetOeuvreById() throws Exception {
        URL wsdlURL = new URL(URL_SERVICE + "?wsdl");
        QName SERVICE_NAME = new QName("http://service.exposition.com/", "ExpositionService");
        Service service = Service.create(wsdlURL, SERVICE_NAME);

        ExpositionService proxy = service.getPort(ExpositionService.class);

        OeuvreDTO oeuvre = proxy.getOeuvreById("O3");
        assertEquals("Danse des ombres", oeuvre.getTitre());
        assertEquals(2025, oeuvre.getAnneeCreation());
    }
}
