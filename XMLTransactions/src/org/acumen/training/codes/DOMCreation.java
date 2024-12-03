package org.acumen.training.codes;

import java.io.StringWriter;
import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMCreation {

	public void createXML() {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			// create elements
			Document docu = builder.newDocument();
			Element root = docu.createElement("savings");
			docu.appendChild(root);

			// create elements
			Element accountId = docu.createElement("accountId");
			accountId.setTextContent("ABC123");
			root.appendChild(accountId);

			// create elements
			Element accountName = docu.createElement("accountName");
			accountName.setTextContent("Juan Luna");
			root.appendChild(accountName);

			// create elements
			Element amount = docu.createElement("amount");
			amount.setTextContent("10000.00");
			root.appendChild(amount);
			// create elements
			Element age = docu.createElement("age");
			age.setTextContent("50");
			root.appendChild(age);

			// create elements
			Element dateOpened = docu.createElement("dateOpened");
			dateOpened.setTextContent(LocalDate.of(2020, 10, 10).toString());
			root.appendChild(dateOpened);

			// transformation
			TransformerFactory factory2 = TransformerFactory.newDefaultInstance();
			Transformer transformer = factory2.newTransformer();
			DOMSource source = new DOMSource(docu);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult("./src/files/savings.xml");
			transformer.transform(source, result);

			System.out.println(writer.toString());

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

}
