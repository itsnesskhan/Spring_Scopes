package com.spring.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Scope("prototype")
public class Address {

//	@Value("gol choraha")
	private String streetName;
	
//	@Value("indore")
	private String city;
	
//	@Value("mp")
	private String state;
	
	

	public Address() {
		super();
		System.out.println("address initalized");
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", city=" + city + ", state=" + state + "]";
	}

}
