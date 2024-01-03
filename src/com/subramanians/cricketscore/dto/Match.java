package com.subramanians.cricketscore.dto;

import java.util.List;

public class Match {
	int matchId;
	int over;
	String format;
	Team teamA;
	Team teamB;
	int teamAScore;
	int teamBScore;
	int teamAWickets;
	int teamBWickets;
	Team won;
	List<Over> eachOver;
	String description;
	Team tossWon;
	String teamChoice;
	String status;
	Team currBat;
	Team currField;
	
	public Match(int matchId,int over,Team teamA,Team teamB,String format) {
		this.matchId=matchId;
		this.over=over;
		this.teamA=teamA;
		this.teamB=teamB;
		this.format=format;
	}
	public List<Over> getEachOver() {
		return eachOver;
	}
	public void setEachOver(List<Over> eachOver) {
		this.eachOver = eachOver;
	}
	public String getTeamChoice() {
		return teamChoice;
	}
	public void setTeamChoice(String teamChoice) {
		this.teamChoice = teamChoice;
	}
	public int getTeamAWickets() {
		return teamAWickets;
	}
	public void setTeamAWickets(int teamAWickets) {
		this.teamAWickets = teamAWickets;
	}
	public int getTeamBWickets() {
		return teamBWickets;
	}
	public void setTeamBWickets(int teamBWickets) {
		this.teamBWickets = teamBWickets;
	}
	public int getOver() {
		return over;
	}
	public void setOver(int over) {
		this.over = over;
	}
	public String getFormat() {
		return format;
	}
	public Team getCurrBat() {
		return currBat;
	}
	public void setCurrBat(Team currBat) {
		this.currBat = currBat;
	}
	public Team getCurrField() {
		return currField;
	}
	public void setCurrField(Team currField) {
		this.currField = currField;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Team getTeamA() {
		return teamA;
	}
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	public Team getTeamB() {
		return teamB;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Team getTossWon() {
		return tossWon;
	}
	public void setTossWon(Team tossWon) {
		this.tossWon = tossWon;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
	public int getTeamAScore() {
		return teamAScore;
	}
	public void setTeamAScore(int teamAScore) {
		this.teamAScore = teamAScore;
	}
	public int getTeamBScore() {
		return teamBScore;
	}
	public void setTeamBScore(int teamBScore) {
		this.teamBScore = teamBScore;
	}
	public Team getWon() {
		return won;
	}
	public void setWon(Team won) {
		this.won = won;
	}
	
}
