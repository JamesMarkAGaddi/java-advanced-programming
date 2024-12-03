package org.acumen.training.codes;

import java.io.File;

import org.acumen.training.codes.model.Profile;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class JAXBUnmarshal {

	public void readXML() {

		try {
			JAXBContext context = JAXBContext.newInstance(Profile.class);
			Unmarshaller parse = context.createUnmarshaller();
			Profile profile = (Profile) parse.unmarshal(new File("./src/files/profile.xml"));
			System.out.println(profile.getFirstName());
			System.out.println(profile.getBirthday());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
