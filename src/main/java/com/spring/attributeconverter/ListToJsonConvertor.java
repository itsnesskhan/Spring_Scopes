package com.spring.attributeconverter;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListToJsonConvertor implements AttributeConverter<String[], String> {
	
	 static final ObjectMapper mapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(String[] attribute) {
		if (attribute==null) {
			return null;
		}
		try {
			return mapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String[] convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		try {
			return mapper.readValue(dbData, String[].class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
