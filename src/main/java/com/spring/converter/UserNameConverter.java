package com.spring.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.models.Name;

public class UserNameConverter implements Converter<String, Name>{

	@Override
	public Name convert(String source) {
		String[] split = source.split("\\s");
		Name name = new Name();
		name.setFirstName(split[0]);
		name.setLastName(split[1]);
		return name;
	}

}
