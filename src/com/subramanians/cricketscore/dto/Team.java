package com.subramanians.cricketscore.dto;

import java.util.HashMap;
import java.util.Map;

public class Team {
	int teamId;
	String team;
	String teamCode;
	String[][] teamMembers;
	Map<Integer,Integer> indivualScore=new HashMap<>();
	Map<Integer,String> bowledBowlersOver=new HashMap<>();
	
	public Team(int teamId,String team,String teamCode) {
		this.teamId=teamId;
		this.team=team;
		this.teamCode=teamCode;
	}

	public Map<Integer,String> getBowlersOver() {
		return bowledBowlersOver;
	}

	public void setBowlersOver(int over,String bowlerName) {
		this.bowledBowlersOver.put(over, bowlerName);
	}

	public Map<Integer,Integer> getIndivualScore() {
		return indivualScore;
	}

	public void setIndivualScore(int pos,int score) {
		this.indivualScore.put(pos, score);
	}
	public void setIndivualScore(Map<Integer,Integer> scores) {
		this.indivualScore=scores;
	}
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String[][] getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(String[][] teamMembers) {
		this.teamMembers = teamMembers;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	
}
