package org.acumen.training.codes;

import java.io.File;
import java.io.IOException;

import org.acumen.training.codes.model.Employee1;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JacksonDeserialization {

	public void readXML() {
		try {
			XmlMapper mapper = new XmlMapper();
			mapper.registerModule(new JavaTimeModule());
			Employee1 doc = mapper.readValue(new File("./src/files/employee.xml"), Employee1.class);
			System.out.println(doc.getFirstname());
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
