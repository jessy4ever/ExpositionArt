# Amélioration TP1 – Validation XML, XPath & Web Service SOAP

**Projet : Exposition d’Art – SOA / XML / SOAP**
**Technologies : Java · Maven · JAX-WS (Jakarta) · XML/XSD · XPath**

---

## Description du projet

Ce projet représente l’amélioration du **TP1 d’Architecture SOA**, où j'ai transformé une simple validation XML/XPath en un **Web Service SOAP complet**, tout en gardant un fonctionnement propre côté XML.

Il comporte trois volets :

1. **Validation XML ↔ XSD**
2. **Interrogation XPath**
3. **Exposition d’un service SOAP (Jakarta JAX-WS)**
4. **Génération automatique et statique du WSDL**

L’objectif est de simuler un mini-système d’exposition d’art permettant :
✔ de valider les données de l’exposition
✔ d’interroger le document XML
✔ d’exposer les œuvres via un Web Service
✔ de consommer le service depuis un client Java

---

## Structure du projet

```
ExpositionArt/
├── pom.xml                        # Maven configuration (Java 17, Jakarta WS, Xerces)
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── exposition/
│   │   │           ├── TP1/
│   │   │           │   └── ValidationXPath.java
│   │   │           │
│   │   │           └── TP2/
│   │   │               ├── ExpositionWS.java
│   │   │               ├── OeuvreDTO.java
│   │   │               ├── ServeurExposition.java
│   │   │               ├── ExpositionService.java
│   │   │               ├── ClientExposition.java
│   │   │               └── WSDLExporter.java
│   │   │
│   │   └── resources/
│   │       ├── TP1/
│   │       │   ├── exposition.xml
│   │       │   └── exposition.xsd
│   │       │
│   │       └── TP2/
│   │           └── wsdl/
│   │               └── exposition.wsdl
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── exposition/
│                   ├── TP1/
│                   │   └── ValidationXPathTest.java
│                   └── TP2/
│                       └── ClientExpositionTest.java
└── README.md
```

---

## Fonctionnalités

### 1. Validation XML ↔ XSD

Le système vérifie automatiquement si **exposition.xml** respecte bien **exposition.xsd**.

---

### 2. Interrogation XPath

Le programme liste :

* tous les titres des œuvres
* les œuvres créées après une certaine année
* les artistes
* etc.


---

### 3. Web Service SOAP

Le service SOAP expose :

* `getNomExposition()`
* `getOeuvres()`
* `getOeuvreById(id)`
* `getOeuvresRecentes(annee)`
* `validateXML()`
* `queryXPath(expression)`


---

### 4. WSDL

Le projet contient :

* **Un WSDL statique** (fichier `exposition.wsdl`)
* **Un WSDL généré automatiquement** par JAX-WS


---

### 5. Scripts de test JUnit

J'ai fait :

* **Test client SOAP**

---

## Exécution du projet

### **1. Compiler**

```
mvn clean install
```

### **2. Lancer le serveur SOAP**

```
mvn exec:java -Dexec.mainClass="com.exposition.TP2.ServeurExposition"
```

Le service sera disponible sur :

```
http://localhost:8080/expo?wsdl
```

### **3. Lancer les tests**

```
mvn test
```

---

## Endpoints du Web Service

Exemples avec SoapUI / Postman SOAP :

✔ `getOeuvres()`
✔ `getOeuvreById("O1")`
✔ `validateXML()`
✔ `queryXPath("//oeuvre/titre")`


---

## Architecture générale

```
   XML/XSD ----> Validation ----+
                                |
                                |-----> Web Service SOAP ---> Client Java
                                |
   XPath  ----> Interrogations -+
```

---

## Auteur

**Yasmine Abbes**
LSI3 · SOA 

