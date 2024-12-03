package org.acumen.training.codes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//sax cannot create, read only XML file
//event-driven kaya sya ang fastest parser ng xml
public class SAXReader {
	private List<Employee> employees;
	private Employee employee;
	private static final String EMPLOYEE = "employee";
	private static final String ID = "id";
	private boolean isId = false;
	private static final String FIRST_NAME = "firstname";
	private boolean isFName = false;
	private static final String LAST_NAME = "lastname";
	private boolean isLName = false;
	private static final String SALARY = "salary";
	private boolean isSalary = false;

	public void readXML(String filename) {

		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = parserFactory.newSAXParser();
			File file = new File(filename);
			parser.parse(file, new XMLContentParseHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private class XMLContentParseHandler extends DefaultHandler {

		@Override
		public void startDocument() throws SAXException {
			System.out.println("Start of document parsing");
			employees = new ArrayList<Employee>();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			System.out.println("tag: %s".formatted(qName)); // localnmae may prefix so kapag may uri ka na dun mo
															// gamitin
			if (qName.equalsIgnoreCase(EMPLOYEE)) {
				// kapag nakita na employee yung tag(based sa final) dun sya magsstart magbasa
				// ng document
				employee = new Employee();
			}

			if (qName.equalsIgnoreCase(ID)) {
				isId = true;
			}

			if (qName.equalsIgnoreCase(FIRST_NAME)) {
				isFName = true;
			}

			if (qName.equalsIgnoreCase(LAST_NAME)) {
				isLName = true;
			}

			if (qName.equalsIgnoreCase(SALARY)) {
				isSalary = true;
			}
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			StringBuilder stringBuilder = new StringBuilder();
			for (int count = start; count < start + length; count++) {
				stringBuilder.append(ch[count]);
			}
//			System.out.println(stringBuilder.toString());
			if (isId) {
				employee.setId(Integer.parseInt(stringBuilder.toString()));
			}

			if (isFName) {
				employee.setFirstname(stringBuilder.toString());
			}
			if (isLName) {
				employee.setLastname(stringBuilder.toString());
			}
			if (isSalary) {
				employee.setSalary(Double.parseDouble(stringBuilder.toString()));
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("tag: %s".formatted(qName)); // localnmae may prefix so kapag may uri ka na dun mo
															// gamitin
			// gamitin
			if (qName.equalsIgnoreCase(EMPLOYEE)) {
				employees.add(employee);
				employee = null;
			}

			if (qName.equalsIgnoreCase(ID)) {
				isId = false;
			}
			if (qName.equalsIgnoreCase(FIRST_NAME)) {
				isFName = false;
			}
			if (qName.equalsIgnoreCase(LAST_NAME)) {
				isLName = false;
			}
			if (qName.equalsIgnoreCase(SALARY)) {
				isSalary = false;
			}

		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("End of document parsing");
			System.out.println(employees.toString());
			employees = null;
		}

	}
}