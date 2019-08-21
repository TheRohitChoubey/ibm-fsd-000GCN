package com.assesmentQ3;

public class State {
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

	public String[] sortState(String[] s) {
		int j;
		boolean flag = true; // will determine when the sort is finished
		String temp;

		while (flag) {
			flag = false;
			for (j = 0; j < s.length - 1; j++) {
				if (s[j].compareToIgnoreCase(s[j + 1]) > 0) { // ascending sort
					temp = s[j];
					s[j] = s[j + 1]; // swapping
					s[j + 1] = temp;
					flag = true;
				}
			}
		}
		
		return s;
	}

}
