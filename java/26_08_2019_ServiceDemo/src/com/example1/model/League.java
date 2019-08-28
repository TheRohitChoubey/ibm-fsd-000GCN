package com.example1.model;

import java.io.Serializable;

public class League implements Serializable {

	private static final long serialVersionUID = -3325204298153035990L;
	private String leagueTitle;
	private int leagueYear;
	private String leagueSeason;
	public League() {
		super();
	}
	public League(String leagueTitle, int leagueYear, String leagueSeason) {
		super();
		this.leagueTitle = leagueTitle;
		this.leagueYear = leagueYear;
		this.leagueSeason = leagueSeason;
	}
	public String getLeagueTitle() {
		return leagueTitle;
	}
	public void setLeagueTitle(String leagueTitle) {
		this.leagueTitle = leagueTitle;
	}
	public int getLeagueYear() {
		return leagueYear;
	}
	public void setLeagueYear(int leagueYear) {
		this.leagueYear = leagueYear;
	}
	public String getLeagueSeason() {
		return leagueSeason;
	}
	public void setLeagueSeason(String leagueSeason) {
		this.leagueSeason = leagueSeason;
	}


}
