package com.subramanians.cricketscore.show;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.subramanians.cricketscore.dto.Formats;
import com.subramanians.cricketscore.dto.Match;
import com.subramanians.cricketscore.dto.Team;

public class ShowView {
	ShowViewModel showViewModel;
	
	public ShowView() {
		showViewModel=new ShowViewModel(this);
	}
	
	public void getInput() {
		Scanner scanner=new Scanner(System.in);
		showViewModel.showFormats();
		showViewModel.getTeams();
		System.out.println("Choose Format Of the Match: ");
		int option=scanner.nextInt();
		showViewModel.format(option);
		showViewModel.showTeams();
		System.out.println("Select Team A: ");
		option=scanner.nextInt();
		showViewModel.teamA(option);
		System.out.println("Select Team B: ");
		option=scanner.nextInt();
		showViewModel.teamB(option); 
		getToss(showViewModel.current); 
		getTeamChoice(showViewModel.tossWon); 
		showBatAndFiled(showViewModel.current); 
//		showViewModel.showTimer(); 
		startFirstInnings();
		showViewModel.updateRepo();
	}
	
	public void printTeams(List<Team> available) {
	    System.out.println("+------------------------------------+");
	    System.out.println("| Available Teams                   |");
	    System.out.println("+------------------------------------+");
	    System.out.println("| Option | Team Name        | Code   |");
	    System.out.println("+------------------------------------+");

	    int option = 1;
	    for (Team team : available) {
	        System.out.printf("| %-6d | %-15s | %-6s |\n", option++, team.getTeam(), team.getTeamCode());
	    }

	    System.out.println("+------------------------------------+");
	}
	
	
	public void printFormats(List<Formats> available) {
		int option=1;
        System.out.println("+" + "-".repeat(8) + "+" + "-".repeat(30) + "+" + "-".repeat(16) + "+");
        System.out.println("| Option | Format Name                  | Over-All-Overs |");
        System.out.println("+" + "-".repeat(8) + "+" + "-".repeat(30) + "+" + "-".repeat(16) + "+");
        for (Formats format : available) {
            System.out.println("| " + String.format("%-7s", option++) + "| " +
                    String.format("%-29s", format.getFormatName()) + "| " +
                    String.format("%-15s", format.getOvers()) + "|");
            System.out.println("+" + "-".repeat(8) + "+" + "-".repeat(30) + "+" + "-".repeat(16) + "+");
        }
	}
	
	public void getTeamChoice(Team team) {
		Scanner scanner=new Scanner(System.in);
		System.out.println(team.getTeam()+" is going to : ");
		System.out.println("1.Bat");
		System.out.println("2.Field");
		System.out.println("Enter the Option: ");
		int option=scanner.nextInt();
		showViewModel.setBat(option,team);
	}
	
	public void getToss(Match match) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("*********************************************************");
		System.out.println("\t Welcome to "+match.getFormat()+" Cricket Match \t");
		System.out.println("*********************************************************");
		System.out.println("A->"+match.getTeamA().getTeam()+" VS "+"B-> " + match.getTeamB().getTeam());
		System.out.println();
		System.out.println("Enter Who Won the Toss: ");
		Character toss=scanner.next().charAt(0);
		showViewModel.setToss(Character.toUpperCase(toss));
	}
	
	public void showBatAndFiled(Match match) {
		System.out.println(match.getTossWon().getTeam()+" has won the toss and elected to "+match.getTeamChoice()+" first.");
		showViewModel.printTeam(match.getTeamA());
		showViewModel.printTeam(match.getTeamB());
	}
	
	public void showCountDown(int seconds) {
		if(seconds==10) {
			System.out.println("Match Begins in......");
		}
		System.out.println(seconds);
		if(seconds==1) {
			return;
		}
	}
	
	public void printPlayers(String[][] players,String team) {
		    System.out.println("+---------------------------------------------------+");
		    System.out.printf("| %-45s |\n", team + " Players");
		    System.out.println("+---------------------------------------------------+");
		    System.out.printf("| %-21s | %-21s | %-15s |\n", "Player Name", "Player Role", "In At");
		    System.out.println("+---------------------------------------------------+");
		    for (int i = 0; i < 11; i++) {
		        System.out.printf("| %-21s | %-21s | %-12s |\n", players[i][0], players[i][1], players[i][2]);
		    }

		    System.out.println("+---------------------------------------------------+");

	}
	
	public void startFirstInnings() {
		Scanner scanner=new Scanner(System.in);
		showViewModel.setBattersAndBowlers(); //setting inital
		showViewModel.setStrikers();
		do {
			showViewModel.showBowlers();
			getBowler();
			showViewModel.startOver();
		}while(showViewModel.getcurrentOver()<showViewModel.chosenForamt.getOvers());
		
	}
	
	
	public void getBowler() {
		Scanner scanner=new Scanner(System.in);
		String option;
		System.out.println("Enter Bowler First Name: ");
		if(showViewModel.over==0) {
			option=scanner.next();
			showViewModel.setBowler(option);
		}else {
			do {
				option=scanner.next();
			}while(showViewModel.validateBowler(option));
			showViewModel.setBowler(option);
		}
	}

	public void printBowlers(String[][] players,String current) {
		int option=1;
	    System.out.println("+---------------------------------------------------+");
	    System.out.printf("| %-17s | %-12s |\n", "Player Name", "Overs-Left");
	    System.out.println("+---------------------------------------------------+");
	    for (int i = 0; i < players.length; i++) {
	    	if(current!="" && players[i][0].equals(current))
	    		System.out.printf("| %-17s | %-12s |\n",  players[i][0], "Bowled Prev.Over");
	    	else
	    		System.out.printf("| %-17s | %-12s |\n",  players[i][0], players[i][2]);
	    }

	    System.out.println("+---------------------------------------------------+");
		
	}

	public void overStart(String currentBowler, String currentBatter, String nonStriker, int over,int runs,int wickets,int extras) {
		System.out.println("+--------------------------------------------+");
		System.out.println("|                Cricket Scoreboard           |");
		System.out.println("+--------------------------------------------+");
		System.out.println("| Last Bowled       | Current Batter | Non-Striker |");
		System.out.println("+--------------------------------------------+");
		System.out.printf("| %-17s | %-15s | %-11s |\n", currentBowler, currentBatter, nonStriker);
		System.out.println("+--------------------------------------------+");
		System.out.printf("| Overs: %d                                  |\n", over-1);
		System.out.println("+--------------------------------------------+");
		System.out.println("|  Runs  |  Wickets  |  Extras  |  Total  |");
		System.out.println("+--------------------------------------------+");
		System.out.printf("|   %d    |    %d      |    %d     |    %d    |\n", runs, wickets, extras, runs);
		System.out.println("+--------------------------------------------+");

	}

	public void printRun(int over,int ball, int runs, int wicket, int extras, String currentBatter, String strikers, int striker, int nonStriker, Map<Integer, Integer> indivualScore) {
        System.out.println("+-----------------------------------------------------------------------------------------------------+");
        System.out.println("|                      Scorecard                                                                      |");
        System.out.println("+-----------------------------------------------------------------------------------------------------+");
        System.out.printf(" | Overs: %-2s | Runs: %-3d | Wickets: %-2d | Extras: %-3d |%n", over+"."+ball, runs, wicket, extras);
        System.out.println("+---------------------+----------------------+--------------------------------------------------------+");
        System.out.printf(" | Current Batter      | Striker (%s)         | Non-Striker (%s) |%n", currentBatter, strikers);
        System.out.println("+---------------------+----------------------+--------------------------------------------------------+");
        System.out.printf("| %-20s | %-20d | %-14d |%n", "Individual Scores",indivualScore.get(striker), indivualScore.get(nonStriker));
        System.out.println("+------------------------------------------------------------------------------------------------------+");	
	}
	
	public void getScore(int balls,int over) {
		Scanner scanner=new Scanner(System.in);
		String run;
		System.out.println("(If It is Wide, No-ball or Wicket give WD-->wide , NB-->No ball & W--> Wicket)");
		System.out.println("Enter "+over+"."+balls+" run: ");
		do {
			run=scanner.next();
		}while(showViewModel.validateScore(run));
		showViewModel.addScore(run,balls,over);
	}
	
	public void printInnings(int matchTarget, int wicket,Match current) {
		System.out.println(current.getCurrBat().getTeam() +" has scored "+ (matchTarget-1) +" and "+current.getCurrField().getTeam() +" taken "+wicket + " wickets.");
		System.out.println("Second Innings Begins in......");
	}

	public void printWon(Match won) {
		if(won.getWon().getTeam().equals(won.getCurrField().getTeam())) {
			System.out.println(won.getWon().getTeam() +" Won By "+ Math.abs(won.getTeamBScore()-won.getTeamAScore()) + " runs");	
		}else {
			System.out.println(won.getWon().getTeam() +" Won By "+ showViewModel.wicket + " wickets");
		
		}
		
	}

	public void printSummary() {
		System.out.println("+-----------------------------------------------------+");
		System.out.println("\t "+ showViewModel.current.getTeamA().getTeam()+" Score-Card \t");
		System.out.println("+-----------------------------------------------------+");
		String[][] teamMembers=showViewModel.current.getTeamA().getTeamMembers();
	    System.out.printf("| %-19s | %-15s |\n", "Player Name", "Scored");
	    System.out.println("+---------------------------------------------------+");
	    for (int i = 0; i < 11; i++) {
	    	if(showViewModel.teamA.getIndivualScore().containsKey(Integer.valueOf(teamMembers[i][2])))
	    	{
	    		System.out.printf("| %-19s | %-17s |\n", teamMembers[i][0], showViewModel.current.getTeamA().getIndivualScore().get(Integer.valueOf(teamMembers[i][2])));
	    	}else {
	    		System.out.printf("| %-19s | %-17s |\n", teamMembers[i][0], "Not Batted");
	    	}
	    }
	    System.out.println("+---------------------------------------------------+");
		System.out.println("\t "+ showViewModel.current.getTeamB().getTeam()+" Score-Card \t");
		System.out.println("+-----------------------------------------------------+");
		teamMembers=showViewModel.current.getTeamB().getTeamMembers();
	    System.out.printf("| %-19s | %-15s |\n", "Player Name", "Scored");
	    System.out.println("+---------------------------------------------------+");
	    for (int i = 0; i < 11; i++) {
	    	if(showViewModel.teamB.getIndivualScore().containsKey(Integer.valueOf(teamMembers[i][2])))
	    	{
	    		System.out.printf("| %-19s | %-17s |\n", teamMembers[i][0], showViewModel.current.getTeamB().getIndivualScore().get(Integer.valueOf(teamMembers[i][2])));
	    	}else {
	    		System.out.printf("| %-19s | %-17s |\n", teamMembers[i][0], "Not Batted");
	    	}
	    }
	    System.out.println("+---------------------------------------------------+");
	    showViewModel.printWin();
	}
	
	public void showError(String msg) {
		System.out.println(msg);
	}

	public void getMatchno() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Match-No: ");
		int option=scanner.nextInt();
		showViewModel.getMatch(option);
		
	}
	
}
