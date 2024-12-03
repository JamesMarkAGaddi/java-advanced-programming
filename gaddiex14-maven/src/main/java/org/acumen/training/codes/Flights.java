package org.acumen.training.codes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Flights {

    public record Passenger(String name, String seat, String destination, String date) {}

    public Map<Integer, List<Passenger>> listPassengers() {
        TreeMap<Integer, List<Passenger>> flightPassengers = new TreeMap<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("./src/org/acumen/training/codes/itemc/flightlist.xml"));
            doc.getDocumentElement().normalize();

            NodeList flightList = doc.getElementsByTagName("flight");

            for (int i = 0; i < flightList.getLength(); i++) {
                Node flightNode = flightList.item(i);
                if (flightNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element flightElement = (Element) flightNode;

                    int flightNumber = Integer.parseInt(flightElement.getAttribute("number"));
                    String destination = flightElement.getAttribute("dest");

                    List<Passenger> passengersForFlight = new ArrayList<>();

                    NodeList passengersList = flightElement.getElementsByTagName("passengers");

                    for (int j = 0; j < passengersList.getLength(); j++) {
                        Element passengersElement = (Element) passengersList.item(j);
                        String date = passengersElement.getAttribute("date");

                        NodeList passengerList = passengersElement.getElementsByTagName("passenger");

                        for (int k = 0; k < passengerList.getLength(); k++) {
                            Element passengerElement = (Element) passengerList.item(k);
                            String name = passengerElement.getAttribute("name");
                            String seat = passengerElement.getAttribute("seat");

                            Passenger passenger = new Passenger(name, seat, destination, date);
                            passengersForFlight.add(passenger);
                        }
                    }

                    flightPassengers.put(flightNumber, passengersForFlight);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return Collections.unmodifiableMap(flightPassengers);
    }

    // Print details of all passengers for each flight
    public void printPassengerDetails(Map<Integer, List<Passenger>> passengers2) {
        for (var entry : passengers2.entrySet()) {
            int flightNumber = entry.getKey();
            List<Passenger> passengers = entry.getValue();

            for (Passenger passenger : passengers) {
                System.out.printf("Flight %d to %s - Passenger: %s, Seat: %s, Date: %s.%n",
                        flightNumber, passenger.destination(), passenger.name(), passenger.seat(), passenger.date());
            }

            System.out.println();  
        }
    }
}
