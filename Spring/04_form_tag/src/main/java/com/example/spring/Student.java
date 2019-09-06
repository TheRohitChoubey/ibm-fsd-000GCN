package com.example.spring;

import java.util.*;

public class Student {
	private String firstName, lastName;
	LinkedHashMap<String, String> countryOptions;
	LinkedHashMap<String, String> languageOptions;
	private String country, language;
	LinkedHashMap<String, String> osList;
	String[] os;

	public Student() {
		super();
		this.countryOptions = new LinkedHashMap<String, String>();
		this.countryOptions.put("WI", "West Indies");
		this.countryOptions.put("IND", "India");
		this.countryOptions.put("RSA", "South Africa");

		this.languageOptions = new LinkedHashMap<String, String>();
		this.languageOptions.put("1", "C#");
		this.languageOptions.put("2", "C++");
		this.languageOptions.put("3", "Java");

		this.osList = new LinkedHashMap<String, String>();
		this.osList.put("1", "Linux");
		this.osList.put("2", "Window");
		this.osList.put("3", "Kali");
	}

	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = countryOptions.get(country);
	}

	public LinkedHashMap<String, String> getLanguageOptions() {
		return languageOptions;
	}

	public void setLanguageOptions(LinkedHashMap<String, String> languageOptions) {
		this.languageOptions = languageOptions;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = languageOptions.get(language);
	}

	public LinkedHashMap<String, String> getOsList() {
		return osList;
	}

	public void setOsList(LinkedHashMap<String, String> osList) {
		this.osList = osList;
	}

	public String[] getOs() {
		return os;
	}

	public void setOs(String[] os) {
		this.os = os;
	}

}
