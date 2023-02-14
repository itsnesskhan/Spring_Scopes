package com.spring.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component("appBean")
@ApplicationScope
public class ApplicationScopeBean {
	
	@Value("NessCo.Foundation")
	private String name;
	
	

	public ApplicationScopeBean() {
		System.out.println("app scope intiialized");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
