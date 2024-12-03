package org.acumen.training.codes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.acumen.training.codes.model.Employee1;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature;

public class JacksonSerialization {

	public void createXML() {

		Employee1 employee = new Employee1();
		employee.setId(101);
		employee.setFirstname("James");
		employee.setLastname("Mark");
		employee.setSalary(55000.00);
		employee.setBirthday(LocalDate.of(2001, 10, 15));

		XmlMapper mapper = new XmlMapper();

		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(Feature.WRITE_XML_DECLARATION, true);
		try {
			mapper.writeValue(new File("./src/files/employee.xml"), employee);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
