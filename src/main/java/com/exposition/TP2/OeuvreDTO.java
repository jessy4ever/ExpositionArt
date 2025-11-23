package com.exposition.TP2;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OeuvreDTO {
    private String id;
    private String titre;
    private String artiste;
    private String technique;
    private String style;
    private int anneeCreation;

    public OeuvreDTO() {}

    public OeuvreDTO(String id, String titre, String artiste, String technique, String style, int anneeCreation) {
        this.id = id;
        this.titre = titre;
        this.artiste = artiste;
        this.technique = technique;
        this.style = style;
        this.anneeCreation = anneeCreation;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getArtiste() { return artiste; }
    public void setArtiste(String artiste) { this.artiste = artiste; }

    public String getTechnique() { return technique; }
    public void setTechnique(String technique) { this.technique = technique; }

    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }

    public int getAnneeCreation() { return anneeCreation; }
    public void setAnneeCreation(int anneeCreation) { this.anneeCreation = anneeCreation; }
}
