package com.exposition.TP2;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.exposition.TP2.ExpositionService",
            targetNamespace = "http://service.exposition.com/",
            serviceName = "ExpositionService")
            
public class ExpositionWS implements ExpositionService {

    private List<OeuvreDTO> oeuvres = new ArrayList<>();

    public ExpositionWS() {
        oeuvres.add(new OeuvreDTO("O1", "Reflets de la Méditerranée", "Yasmine Abbes", "Aquarelle", "Impressionnisme", 2024));
        oeuvres.add(new OeuvreDTO("O2", "Silence d’or", "Amira Ben Salah", "Huile sur toile", "Réalisme", 2023));
        oeuvres.add(new OeuvreDTO("O3", "Danse des ombres", "Talel K.", "Acrylique", "Abstrait", 2025));
    }

    @WebMethod
    public List<OeuvreDTO> getOeuvres() {
        return oeuvres;
    }

    @WebMethod
    public String getNomExposition() {
        return "Lumières et Couleurs";
    }

    @WebMethod
    public OeuvreDTO getOeuvreById(String id) {
        return oeuvres.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }
}
