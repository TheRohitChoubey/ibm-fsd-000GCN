package com.assesmentQ3;

import java.util.*;

public class Country {
	private String name;
	List<State> stateList = new ArrayList<State>();

	public Country(String name, List<State> stateList) {
		super();
		this.name = name;
		this.stateList = stateList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<State> getStateList() {
		Collections.sort(this.stateList);
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	public void addState(String statename) {
		this.stateList.add(new State(statename));
	}

}
