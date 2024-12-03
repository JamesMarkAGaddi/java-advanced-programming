package org.acumen.training.codes;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FlightsCreation {

	public void createFlightListXML() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Create the document
			Document doc = builder.newDocument();

			// Root element: flightlist
			Element root = doc.createElement("flightlist");
			doc.appendChild(root);

			// Flight 1
			Element flight1 = createFlightElement(doc, "1", "BOS", "SJU");
			appendPassengerDates(doc, flight1);
			root.appendChild(flight1);

			// Flight 2
			Element flight2 = createFlightElement(doc, "2", "SFO", "JFK");
			appendPassengerDates(doc, flight2);
			root.appendChild(flight2);

			// Flight 3
			Element flight3 = createFlightElement(doc, "3", "NYC", "MRY");
			appendPassengerDates(doc, flight3);
			root.appendChild(flight3);

			// Transformation to XML
			TransformerFactory transformerFactory = TransformerFactory.newDefaultInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult("./src/files/flightlist.xml");
			transformer.transform(source, result);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	private Element createFlightElement(Document doc, String number, String origin, String dest) {
		Element flight = doc.createElement("flight");
		flight.setAttribute("number", number);
		flight.setAttribute("origin", origin);
		flight.setAttribute("dest", dest);
		return flight;
	}

	private void appendPassengerDates(Document doc, Element flight) {
		// First date passengers
		Element passengers1 = doc.createElement("passengers");
		passengers1.setAttribute("date", "12-4-2012");
		flight.appendChild(passengers1);
		passengers1.appendChild(createPassengerElement(doc, "Laura", "1A"));
		passengers1.appendChild(createPassengerElement(doc, "Anna", "1B"));

		// Second date passengers
		Element passengers2 = doc.createElement("passengers");
		passengers2.setAttribute("date", "12-5-2012");
		flight.appendChild(passengers2);
		passengers2.appendChild(createPassengerElement(doc, "Tatiana", "1C"));
		passengers2.appendChild(createPassengerElement(doc, "Candy", "1D"));
	}

	private Element createPassengerElement(Document doc, String name, String seat) {
		Element passenger = doc.createElement("passenger");
		passenger.setAttribute("name", name);
		passenger.setAttribute("seat", seat);
		return passenger;
	}
}
