package org.acumen.training.codes;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}
}
