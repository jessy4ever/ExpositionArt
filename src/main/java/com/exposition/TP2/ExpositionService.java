package com.exposition.TP2;

import jakarta.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://service.exposition.com/", name = "ExpositionService")

public interface ExpositionService {
    String getNomExposition();
    OeuvreDTO getOeuvreById(String id);
    List<OeuvreDTO> getOeuvres();
}