package com.exposition.TP2;

import jakarta.xml.ws.Service;
import java.net.URL;
import javax.xml.namespace.QName;
import java.util.List;

public class ClientExposition {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8000/ws/exposition?wsdl");
        // namespace must match @WebService targetNamespace, localPart is the serviceName
        QName qname = new QName("http://service.exposition.com/", "ExpositionService");

        Service service = Service.create(url, qname);
        ExpositionService ws = service.getPort(ExpositionService.class);

        List<OeuvreDTO> oeuvres = ws.getOeuvres();
        System.out.println("Liste des oeuvres :");
        for (OeuvreDTO o : oeuvres) {
            System.out.println(o.getTitre() + " par " + o.getArtiste());
        }
    }
}
