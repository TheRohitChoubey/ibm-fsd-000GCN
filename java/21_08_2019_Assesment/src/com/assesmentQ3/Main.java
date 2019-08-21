package com.assesmentQ3;

import java.util.*;
import java.util.Map.Entry;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static Map<String, ArrayList<State>> countryState = new HashMap<String, ArrayList<State>>();
	private static List<Country> li = new ArrayList<Country>();
	private static List<State> sortState = new ArrayList<State>();
	private static String state, country;

	public static void addCountry(String data) {
		int ind = data.indexOf('|');
		state = data.substring(ind + 1, data.length());
		country = data.substring(0, ind);
		if (countryState.get(country) == null) {
			countryState.put(country, new ArrayList<State>());
		}
		countryState.get(country).add(new State(state));
	}

	public static void main(String[] args) {

		System.out.println("Enter total input :");
		int input = scanner.nextInt();

		for (int i = 0; i < input; i++) {
			String data = scanner.next();
			addCountry(data);
		}

		for (Entry<String, ArrayList<State>> ee : countryState.entrySet()) {
			String key = ee.getKey();
			List<State> values = ee.getValue();
			li.add(new Country(key, values));
		}

		for (int i = 0; i < li.size(); i++) {
			sortState = li.get(i).getStateList();
			System.out.println(li.get(i).getName());
			for (int j = 0; j < sortState.size(); j++) {
				System.out.println("--" + sortState.get(j).getStateName());
			}
		}

		System.out.println("Enter New Country|state to be added : ");
		String data = scanner.next();
		int ind = data.indexOf('|');
		state = data.substring(ind + 1, data.length());
		country = data.substring(0, ind);

		boolean flag = false;
		for (int i = 0; i < li.size(); i++) {
			if (country.equals(li.get(i).getName())) {
				li.get(i).addState(state);
				flag = true;
				break;
			}
		}

		if (flag == true) {
			for (int i = 0; i < li.size(); i++) {
				sortState = li.get(i).getStateList();
				System.out.println(li.get(i).getName());
				for (int j = 0; j < sortState.size(); j++) {
					System.out.println("--" + sortState.get(j).getStateName());
				}
			}
		} else {
			System.out.println("Country Not Found !");
		}

	}

}
