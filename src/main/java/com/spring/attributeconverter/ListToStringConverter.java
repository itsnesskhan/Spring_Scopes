package com.spring.attributeconverter;

import javax.persistence.AttributeConverter;

public class ListToStringConverter implements AttributeConverter<String[], String> {

	@Override
	public String convertToDatabaseColumn(String[] attribute) {
		return attribute == null ? null : String.join(",", attribute);
	}

	@Override
	public String[] convertToEntityAttribute(String dbData) {
		String[] emptyArray = {};
		return dbData== null? emptyArray : dbData.split(",");
	}

}
