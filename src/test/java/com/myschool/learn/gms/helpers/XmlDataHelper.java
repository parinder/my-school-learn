package com.myschool.learn.gms.helpers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;

public class XmlDataHelper {

    public static Document getXmlDocument(String xmlResourcePath) {
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(classLoader.getResource(xmlResourcePath).getFile());
            FileInputStream fileInputStream = new FileInputStream(file);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fileInputStream);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getNodeValue(Document document, String path) {
        try {
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile(path);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            Node node = nodes.item(0); // assumes there is one node
            return node.getTextContent();
        } catch (Exception ex) {
            return "";
        }
    }

    public static void setNodeAttribute(Document document, String path, String attribute ,String attributeValue) {
        try {
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile(path);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            Node node = nodes.item(0);
            Element eElement = (Element) node;
            eElement.setAttribute(attribute, attributeValue);;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void setNodeValue(Document document, String path, String value) {
        try {
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile(path);
            NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            Node node = nodes.item(0);
            node.setTextContent(value);
        } catch (Exception ex) {
            // do nothing???
        }
    }

    public static String getString(Document doc) {
        try {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString();
        } catch (TransformerException ex) {
            return null;
        }
    }
}