package org.acumen.training.codes;

import java.io.File;
import java.io.IOException;

import org.acumen.training.codes.model.Login;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJSONSerial {

	public void createJSON() {
		
		Login login = new Login();
		login.setId(101);
		login.setUserName("Maria");
		login.setPassWord("clara");
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("./src/files/login.json"), login);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
