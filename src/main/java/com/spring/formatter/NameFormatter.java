package com.spring.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.spring.models.Name;

public class NameFormatter implements Formatter<Name> {

	@Override
	public String print(Name object, Locale locale) {
		return object.getFirstName()+" "+object.getLastName();
	}

	@Override
	public Name parse(String text, Locale locale) throws ParseException {
		String[] split = text.split("\\s");
		Name name = new Name();
		name.setFirstName(split[0]);
		name.setLastName(split[1]);
		return name;
	}

}
