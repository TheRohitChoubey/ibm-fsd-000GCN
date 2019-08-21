package com.assesmentQ3;

public class State implements Comparable<State> {
	private String stateName;

	public State(String stateName) {
		super();
		this.stateName = stateName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public int compareTo(State s) {
		if(this.getStateName() == s.getStateName())
			return 0;/*
		else if(this.getStateName()  s.getStateName())
			return 1;
		else
			return -1;
			*/
		return 0;
	}
	
	
}
