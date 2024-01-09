package com.subramanians.cricketscore.show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.subramanians.cricketscore.dto.Formats;
import com.subramanians.cricketscore.dto.Match;
import com.subramanians.cricketscore.dto.Over;
import com.subramanians.cricketscore.dto.Team;
import com.subramanians.cricketscore.repo.CricketRepo;

public class ShowViewModel {
	ShowView showView;
	CricketRepo repo;
	Team teamA,teamB,tossWon;
	Formats chosenForamt;
	Match current;
	List<Team> teams=new ArrayList<>();
	List<Formats> formats=new ArrayList<>();
	List<Match> allMatches=new ArrayList<>();
	List<Over> eachOver=new ArrayList<>();
	Map<Integer,String> ballFacedByBatsmen;
	Map<Integer,Integer> runByBall;
	Map<Integer,Integer> indivualScore=new HashMap<>();
	String[][] matchBowlers=new String[5][3];
	String[][] matchBatters=new String[11][2];
	String[] strikers=new String[2];
	String lastBowled,currentBowler,currentBatter;
	int striker=0, nonStriker=0,over=0, wicket=0, runs=0, extras=0, currentBall=0, matchTarget=0, balls=6;
	byte innigs=1;
	
	public ShowViewModel(ShowView showView) {
		this.showView=showView;
		this.repo=CricketRepo.getInstance();
	}

	public void getTeams() {
		teams=repo.getAvailableTeams();   //Manage Space
		allMatches=repo.getAllMatches();
	}

	public void showTeams() {
		showView.printTeams(teams);
	}

	public void teamA(int option) {
		teamA=teams.get(option-1);
		teams.remove(option-1);
		showView.printTeams(teams);
	}

	public void teamB(int option) {
		teamB=teams.get(option-1);
		int matchId=1;
		if(allMatches.size() >= 1) {
			matchId=allMatches.size()+1;
		}
		current=new Match(matchId,chosenForamt.getOvers(),teamA,teamB,chosenForamt.getFormatName());
		repo.newMatch(current);
	}

	public Team getTeamA() {
		return teamA;
	}
	
	public Team getTeamB() {
		return teamB;
	}
	
	public void showFormats() {
		formats=repo.getAvailableFormats();
		showView.printFormats(formats);
	}

	public void format(int option) {
		chosenForamt=formats.get(option-1);
		
	}

	public void setToss(char team) {
		tossWon=null;
		if(team=='A') {
			tossWon=teamA;
			current.setTossWon(teamA);
		}else if(team=='B') {
			tossWon=teamB;
			current.setTossWon(teamB);
		}
		int index=allMatches.indexOf(current);
		allMatches.get(index).setTossWon(tossWon);
	}
	
	public void setBat(int option,Team team) {
		if(option==1) {
			if(tossWon==teamA)
			{
				current.setTeamChoice("Bat");
				current.setCurrBat(team);
				current.setCurrField(teamB);
			}else {
				current.setTeamChoice("Bat");
				current.setCurrBat(team);
				current.setCurrField(teamA);
	
			}
		}else {
			if(tossWon==teamA)
			{
				current.setTeamChoice("Field");
				current.setCurrField(team);
				current.setCurrBat(teamB);
				
			}else {
				current.setTeamChoice("Field");
				current.setCurrField(team);
				current.setCurrBat(teamA);
				
			}
		}
	}

	public void showTimer() {
		for(int i=10;i>=1;i--) {
			showView.showCountDown(i);
			if(i!=1)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		}
	}
	
	public void printTeam(Team team) {
		team.setTeamMembers(repo.getTeam(team));
		showView.printPlayers(team.getTeamMembers(),team.getTeam());
	}

	public void setBattersAndBowlers() {
		Team field=current.getCurrField();
		Team bat=current.getCurrBat();
		matchBatters=bat.getTeamMembers();
		setStrikers();
		String[][] temp=field.getTeamMembers();
		int j=0;
		for(int i=0;i<11;i++) {
			if(temp[i][1]=="Bowler" || temp[i][1].contains("Bowler")) {
				matchBowlers[j][0]=temp[i][0];
				matchBowlers[j][1]=temp[i][1];
				if(chosenForamt.getFormatName().equals("T20"))
				{
					matchBowlers[j][2]=String.valueOf(5);
				}
				else if(chosenForamt.getFormatName().equals("ODI")) {
					matchBowlers[j][2]=String.valueOf(10);
				}
				else {
					matchBowlers[j][2]=String.valueOf(20);
				}
				j++;
			}
		}
	}

	public void setStrikers() {
		if(wicket==0)
		{
			strikers[0]=matchBatters[0][0];
			currentBatter=strikers[0];
			striker=Integer.valueOf(matchBatters[0][2]);
			indivualScore.put(striker, 0);
			strikers[1]=matchBatters[1][0];
			nonStriker=Integer.valueOf(matchBatters[1][2]);
			indivualScore.put(nonStriker, 0);
		}else if(strikers[0].equals("")){
			strikers[0]=matchBatters[wicket+1][0];
			currentBatter=strikers[0];
			striker=Integer.valueOf(matchBatters[wicket+1][2]);
			indivualScore.put(striker, 0);
		}else {
			strikers[1]=matchBatters[wicket+1][0];
			currentBatter=strikers[1];
			striker=Integer.valueOf(matchBatters[wicket+1][2]);
			indivualScore.put(striker, 0);
		}
	}
	
	public void setBowler(String Bowler) {
		for(int i=0;i<matchBowlers.length;i++) {
			if(matchBowlers[i][0].contains(Bowler)) {
				currentBowler=matchBowlers[i][0];
				break;
			}
		}
	}
	
	public void showBowlers() {
		showView.printBowlers(matchBowlers,currentBowler);
	}


	public boolean validateBowler(String option) {
		if(lastBowled.contains(option)) {
			showView.showError("Bowler Bowled Last Over");
			return true;
		}else {
			return false;
		}
	}

	public void startOver() {
		do {
			showView.getScore(currentBall,over);
			if(currentBall!=6)
			{
				showView.printRun(over,currentBall,runs,wicket,extras,currentBatter,strikers[1],striker,nonStriker,indivualScore);	
			}
		}while(currentBall<balls);
		if(innigs==2 && over==chosenForamt.getOvers())
		{
			return;
		}else {
			showView.overStart(currentBowler,currentBatter,strikers[1],over,runs,wicket,extras);	
		}
		currentBall=0;
	}
	
	public boolean validateScore(String run) {
		if(run.equals("W") || run.equals("WD") || run.equals("NB")) {
			return false;
		}else if(run.equals("5") || Integer.valueOf(run)>6) {
			showView.showError("Enter Valid Score");
			return true;
		}else {
			return false;
		}
	}
	
	public void addScore(String run,int incomingBall,int incomingOver) {
		if(incomingBall==0) {
			ballFacedByBatsmen=new HashMap<>();
			runByBall=new HashMap<>();
		}
		if(run.equals("W") || run.equals("WD") || run.equals("NB")) {
			if(run.equals("WD") || run.equals("NB")) {
				extras++;
				balls++;
				runs++;
			}else {
				wicket++;
				runByBall.put(incomingBall, -1);
				current.getCurrBat().setIndivualScore(striker,indivualScore.get(striker));
				if(wicket>=10) {
					if(innigs==2) {
						currentBall=6;
						over=chosenForamt.getOvers();
						current.getCurrBat().setIndivualScore(striker,indivualScore.get(striker));
						current.getCurrBat().setIndivualScore(nonStriker,indivualScore.get(nonStriker));
						showView.printSummary();
						return;
					}else {
						changeInginngs();
					}
				}
				if(strikers[0].equals(currentBatter))
				{
					strikers[0]="";
					setStrikers();
				}else {
					strikers[1]="";
					setStrikers();
				}
			}
			currentBall++;
		}else {
			int temprun=Integer.valueOf(run);
			runs+=temprun;
			if(innigs==2 && runs>=matchTarget)
			{
				currentBall=6;
				over=chosenForamt.getOvers();
				if(current.getTeamAScore()==0)
				{
					current.setTeamAScore(runs);
				}else {
					current.setTeamBScore(runs);
				}
				current.getCurrBat().setIndivualScore(striker,indivualScore.get(striker)+temprun);
				current.getCurrBat().setIndivualScore(nonStriker,indivualScore.get(nonStriker));
				showView.printSummary();
				return;
			}
			if(indivualScore.containsKey(striker)) {
				indivualScore.put(striker, indivualScore.get(striker)+temprun);	
			}else {
				indivualScore.put(striker, temprun);
			}
			ballFacedByBatsmen.put(incomingBall, currentBatter);
			runByBall.put(incomingBall, temprun);
			if(temprun==1 || temprun==3) {
				if(currentBatter.equals(strikers[0])) {
					String temp=currentBatter;
					currentBatter=strikers[1];
					strikers[1]=temp;
					strikers[0]=currentBatter;
					int temp1=striker;
					striker=nonStriker;
					nonStriker=temp1;
				}else {
					String temp=currentBatter;
					currentBatter=strikers[0];
					strikers[1]=temp;
					strikers[0]=currentBatter;
				}
			}
			currentBall++;
		}
		if(incomingBall==balls-1) {
			balls=6;
			eachOver.add(new Over(ballFacedByBatsmen,runByBall,currentBowler));
			current.getCurrField().setBowlersOver(incomingOver, currentBowler);
			for(int i=0;i<matchBowlers.length;i++) {
				if(matchBowlers[i][0].equals(currentBowler)) {
					String changedOvers=String.valueOf(Integer.valueOf(matchBowlers[i][2])-1);
					matchBowlers[i][2]=changedOvers;
				}
			}
			if(strikers[0].equals(currentBatter)) {
				String temp=currentBatter;
				currentBatter=strikers[1];
				strikers[1]=temp;
				strikers[0]=currentBatter;
				int temp1=striker;
				striker=nonStriker;
				nonStriker=temp1;
			}else {
				String temp=currentBatter;
				currentBatter=strikers[0];
				strikers[1]=temp;
				int temp1=striker;
				striker=nonStriker;
				nonStriker=temp1;
			}
			lastBowled=currentBowler;
			currentBowler="-";
			over++;
			if(over==chosenForamt.getOvers() && innigs==1){
				changeInginngs();
			}else if(over==chosenForamt.getOvers() && innigs==2) {
				current.getCurrBat().setIndivualScore(striker,indivualScore.get(striker));
				current.getCurrBat().setIndivualScore(nonStriker,indivualScore.get(nonStriker));
				showView.printSummary();
			}
		}
	}
	
	public void changeInginngs() {
		if(current.getTeamA().equals(current.getCurrBat())) {
			current.setTeamAScore(runs);
			current.setTeamAWickets(wicket);
		}else {
			current.setTeamBScore(runs);
			current.setTeamBWickets(wicket);
		}
		current.getCurrBat().setIndivualScore(striker,indivualScore.get(striker));
		current.getCurrBat().setIndivualScore(nonStriker,indivualScore.get(nonStriker));
		matchTarget=runs+1;
		showView.printInnings(matchTarget,wicket,current);
		innigs=2;
		runs=0;
		wicket=0;
		over=0;
		Team temp=current.getCurrBat();
		current.setCurrBat(current.getCurrField());
		current.setCurrField(temp);
		setBattersAndBowlers();
		setStrikers();
//		showTimer();
		return;
	}
	
	public void printWin() {
		if(current.getWon()!=null)
		{
			showView.printWon(current);
			return;
		}
		if(current.getTeamA().equals(current.getCurrField())) {
			current.setTeamBScore(runs);
			if(current.getTeamBScore()>current.getTeamAScore()) {
				current.setWon(current.getTeamB());
			}else {
				current.setWon(current.getTeamA());
			}
		}else {
			current.setTeamAScore(runs);
			if(current.getTeamAScore()>current.getTeamBScore()) {
				current.setWon(current.getTeamA());
			}else {
				current.setWon(current.getTeamB());
			}
		}
		showView.printWon(current);
	}
	
	public int getcurrentOver() {
		return over;
	}

	public void updateRepo() {
		current.setEachOver(eachOver);
		allMatches.add(current);
		repo.updateMatch(current);
		// Logic For Saving to DB
	}

	public void getMatch(int option) {
		if(allMatches.isEmpty())
		{
			getTeams();	
		}
		current=allMatches.get(option-1);
		showView.printSummary();
	}
	
}
