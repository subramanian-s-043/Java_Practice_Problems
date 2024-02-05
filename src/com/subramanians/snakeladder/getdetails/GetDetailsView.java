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
			int[] start=new int[2];
			int[] end=new int[2];
			printMessage("Enter the Row and Column head of Snake "+(i+1)+" :");
			do {
				start[0]=scanner.nextInt();
				start[1]=scanner.nextInt();
			}while(getDetails.validatePosition(start[0],start[1]));
			printMessage("Enter the Row and Column tail of Snake "+(i+1)+" :");
			do {
				end[0]=scanner.nextInt();
				end[1]=scanner.nextInt();
			}while(getDetails.validatePosition(end[0],end[1]));
			getDetails.setSnakes(start,end);
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
			int[] start=new int[2];
			int[] end=new int[2];
			printMessage("Enter the Row and Column start of Ladder "+(i+1)+" :");
			do {
				start[0]=scanner.nextInt();
				start[1]=scanner.nextInt();
			}while(getDetails.validatePosition(start[0],start[1]));
			printMessage("Enter the Row and Column end of Ladder "+(i+1)+" :");
			do {
				end[0]=scanner.nextInt();
				end[1]=scanner.nextInt();
			}while(getDetails.validatePosition(end[0],end[1]));
			getDetails.setLadders(start,end);
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
