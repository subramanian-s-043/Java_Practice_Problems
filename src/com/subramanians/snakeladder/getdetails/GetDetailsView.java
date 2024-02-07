package com.subramanians.snakeladder.getdetails;

import java.util.Scanner;

import com.subramanians.snakeladder.play.PlayView;

public class GetDetailsView {
	GetDetailsViewModel getDetails;
	
	public GetDetailsView() {
		getDetails = new GetDetailsViewModel(this);
	}
	
	public void getInput() {
		getBoardDetails();
		getSnakeDetails();
		getLadderDetails();
		getPlayerDetails();
		PlayView game=new PlayView();
		game.start();
	}
	
	private void getBoardDetails() {
		Scanner scanner=new Scanner(System.in);
		printMessage("Enter the size of Board: ");
		int board;
		do {
			board=scanner.nextInt();
		}while(getDetails.validateBoard(board));
		getDetails.createBoard(board);
	}
	
	private void getSnakeDetails() {
		Scanner scanner = new Scanner(System.in);
		printMessage("Enter Number of Snakes: ");
		int numberOfSnakes;
		do {
			numberOfSnakes=scanner.nextInt();
		}while(getDetails.validateSnakes(numberOfSnakes));
		for(int i=0;i<numberOfSnakes;i++)
		{
			int startpos;
			int endpos;
			printMessage("Enter the head of Snake "+(i+1)+" :");
			do {
				startpos=scanner.nextInt();
			}while(getDetails.validatePosition(startpos));
			printMessage("Enter the tail of Snake "+(i+1)+" :");
			do {
				endpos=scanner.nextInt();
			}while(getDetails.validatePosition(endpos));
			getDetails.setSnakes(startpos,endpos);
		}
	}
	
	private void getLadderDetails() {
		Scanner scanner = new Scanner(System.in);
		printMessage("Enter Number of Ladders: ");
		int numberOfLadders;
		do {
			numberOfLadders=scanner.nextInt();
		}while(getDetails.validateLadders(numberOfLadders));
		for(int i=0;i<numberOfLadders;i++)
		{
			int startpos;
			int endpos;
			printMessage("Enter the start of Ladder "+(i+1)+" :");
			do {
				startpos=scanner.nextInt();
			}while(getDetails.validatePosition(startpos));
			printMessage("Enter the end of Ladder "+(i+1)+" :");
			do {
				endpos=scanner.nextInt();
			}while(getDetails.validatePosition(endpos));
			getDetails.setLadders(startpos,endpos);
		}		
	}
	
	private void getPlayerDetails() {
		Scanner scanner = new Scanner(System.in);
		printMessage("Enter Number Of Players: ");
		int numberOfPlayers=scanner.nextInt();
		for(int i=0;i<numberOfPlayers;i++)
		{
			printMessage("Enter the Name of Player "+(i+1)+" : ");
			String name=scanner.next();
			getDetails.addPlayer(name);
		}
		getDetails.setPlayers();
	}
	
	public void printMessage(String msg) {
		System.out.println(msg);
	}
	
	public void showError(String err) {
		System.out.println(err);
	}
}
