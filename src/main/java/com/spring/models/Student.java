package com.spring.models;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.annotations.Age;
import com.spring.attributeconverter.ListToJsonConvertor;

@Component("student")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Entity
@Table(name = "db_user")
public class Student {

	@Id
	@Column(name = "user_id")
	private int id;

//	@Value("Nasser")
	private Name name;

	private String email;

	private String password;

//	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	private String gender;
	
	@Age(lower = 13,upper = 30)
	private Integer age;
	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	private String country;

	@Convert(converter = ListToJsonConvertor.class)
//	@Column(columnDefinition = "json")
	private String[] hobbies;

	@Autowired
	@Transient
	private Address address;

	private String profile;

	public String getGender() {
		return gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getCountry() {
		return country;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student() {
		super();
		System.out.println("student initialized");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dob=" + dob
				+ ", gender=" + gender + ", country=" + country + ", hobbies=" + Arrays.toString(hobbies) + ", address="
				+ address + "]";
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
