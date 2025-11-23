package com.exposition.TP1;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import java.io.File;

public class ValidationXPath {

    public static void main(String[] args) {
        try {
            // --- VALIDATION XML/XSD ---
            File xmlFile = new File("src/main/resources/exposition.xml");
            File xsdFile = new File("src/main/resources/exposition.xsd");

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            System.out.println("Le fichier XML est valide selon le schema XSD !");

            // --- INTERROGATION XPATH ---
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            System.setProperty("javax.xml.xpath.XPathFactory:http://java.sun.com/jaxp/xpath/dom", "org.apache.xpath.jaxp.XPathFactoryImpl");
            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();

            // 1. Lister tous les titres d’œuvres
            XPathExpression expr1 = xpath.compile("//oeuvre/titre");
            var titres = (org.w3c.dom.NodeList) expr1.evaluate(doc, XPathConstants.NODESET);
            System.out.println("\nTitres des oeuvres :");
            for (int i = 0; i < titres.getLength(); i++) {
                System.out.println(" - " + titres.item(i).getTextContent());
            }

            // 2. Lister les œuvres créées après 2023
            XPathExpression expr2 = xpath.compile("//oeuvre[anneeCreation>2023]/titre");
            var modernes = (org.w3c.dom.NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
            System.out.println("\nOeuvres recentes :");
            for (int i = 0; i < modernes.getLength(); i++) {
                System.out.println(" - " + modernes.item(i).getTextContent());
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
