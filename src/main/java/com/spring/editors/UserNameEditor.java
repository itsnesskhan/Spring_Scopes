package com.spring.editors;

import java.beans.PropertyEditorSupport;

import com.spring.models.Name;

public class UserNameEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		Name name = (Name)getValue();
		return name.getFirstName()+" "+name.getLastName();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] split = text.split("\\s");
		Name name = new Name();
		name.setFirstName(split[0]);
		name.setLastName(split[1]);
		setValue(name);
	}

}
