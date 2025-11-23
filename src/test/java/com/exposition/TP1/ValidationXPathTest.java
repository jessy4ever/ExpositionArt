package com.exposition.TP1;

import org.junit.jupiter.api.Test;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ValidationXPathTest {

    @Test
    void testXmlValidAgainstXsd() {
        assertDoesNotThrow(() -> {
            File xmlFile = new File("src/main/resources/TP1/exposition.xml");
            File xsdFile = new File("src/main/resources/TP1/exposition.xsd");

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
        }, "Le fichier XML doit être valide selon le XSD");
    }

    @Test
    void testXPathExtraction() {
        assertDoesNotThrow(() -> {
            ValidationXPath.main(new String[]{});
        }, "XPath doit s'exécuter sans erreur et extraire les titres et œuvres récentes");
    }
}
