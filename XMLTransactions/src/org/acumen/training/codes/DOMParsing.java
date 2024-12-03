package org.acumen.training.codes;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParsing {

	private void walkDOMTree(Node node) {

		switch (node.getNodeType()) {
		case Node.DOCUMENT_NODE:
			System.out.println("start of the parsing");
			NodeList nodes = node.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Node element = nodes.item(i);
				walkDOMTree(element);
			}
			break;
		case Node.ELEMENT_NODE:
			String element = node.getNodeName();
			System.out.println("element: %s".formatted(element));
			nodes = node.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Node elem = nodes.item(i);
				// for attributes
				NamedNodeMap atts = elem.getAttributes();
				for (int j = 0; j < atts.getLength(); j++) {
					Node att = atts.item(i);
					walkDOMTree(att);
				}
				walkDOMTree(elem);
			}
			break;
		case Node.TEXT_NODE:
			String text = node.getNodeValue();
			System.out.println("element: %s".formatted(text));
			break;
		}
	}

	public void readXML() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("./src/files/savings.xml"));
			doc.getDocumentElement().normalize();
			walkDOMTree(doc);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
