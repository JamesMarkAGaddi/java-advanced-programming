package org.acumen.training.codes;

import java.io.File;
import java.time.LocalDate;

import org.acumen.training.codes.model.Profile;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class JAXBMarshal {

	public void createXML() {

		Profile profile = new Profile();
		profile.setId(101);
		profile.setFirstName("James");
		profile.setLastName("Mark");
		profile.setSalary(55000.00);
		profile.setBirthday(LocalDate.of(2001, 10, 15));

		try {
			JAXBContext context = JAXBContext.newInstance(Profile.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(profile, new File("./src/files/profile.xml"));

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
