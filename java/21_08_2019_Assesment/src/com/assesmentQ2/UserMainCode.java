package com.assesmentQ2;

import java.util.regex.Pattern;

public class UserMainCode {
	
	private static final Pattern[] pattern = new Pattern[4];
	 
	static {
	    pattern[0] = Pattern.compile(".*[A-Z].*");
	    pattern[1] = Pattern.compile(".*[a-z].*");
	    pattern[2] = Pattern.compile(".*\\d.*");
	    pattern[3] = Pattern.compile(".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*");
	}
	
	public static boolean checkPassword(String pass) {
	    boolean inMatch = true;
	    if(pass.length() < 8) {
	    	return false;
	    }
	    for (Pattern i : pattern) {
	        if (!i.matcher(pass).matches()) {
	            inMatch = false;
	        }
	    }
	    return inMatch;
	}
}
