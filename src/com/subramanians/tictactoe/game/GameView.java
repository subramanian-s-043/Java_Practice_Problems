package com.subramanians.tictactoe.game;

import java.util.Scanner;

public class GameView {
	GameViewModel gameViewModel;
	
	public GameView() {
		gameViewModel=new GameViewModel(this);
	}
	
	public void getPlayers() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Who is going to Play 'X' ?");
		String player1=scanner.next();
		System.out.println("Enter Who is going to Play 'O' ?");
		String player2=scanner.next();
		gameViewModel.setPlayers(player1,player2);
		print();
		startGame();
	}
	
	public void startGame() {
		Scanner scanner=new Scanner(System.in);
		int row=0,column=0;
		while(gameViewModel.isPlayable) {
			System.out.println(gameViewModel.current.getPlayer1()+"- X - turn!!");
			do {
				System.out.println("Enter the Row And Column: (space-separated)");
				row=scanner.nextInt();
				column=scanner.nextInt();
			}while(gameViewModel.validateRowAndColumn(row, column));
			gameViewModel.setX(row,column);
			if(gameViewModel.isPlayable) {
			System.out.println(gameViewModel.current.getPlayer2()+"- O - turn!!");
			do {
				System.out.println("Enter the Row And Column: (space-separated)");
				row=scanner.nextInt();
				column=scanner.nextInt();
			}while(gameViewModel.validateRowAndColumn(row, column));
				System.out.println("Enter the Row And Column (space-separated)");
				gameViewModel.setY(row,column);	
			}
		}
	}
	
	public void print() {
	    char[][] gameArea = gameViewModel.gameArea;
	    System.out.println("+----------------------------------------------+");
	    for (int i = 0; i < gameArea.length; i++) {
	        for (int j = 0; j < gameArea[i].length; j++) {
	            System.out.print(gameArea[i][j]);
	            if (j < gameArea[i].length - 1) {
	                System.out.print(" | ");
	            }
	        }
	        System.out.println();
	        if (i < gameArea.length - 1) {
	            for (int k = 0; k < gameArea[i].length - 1; k++) {
	                System.out.print("----");
	            }
	            System.out.println();
	        }
	    }
	    System.out.println("+----------------------------------------------+");
	}
	public void showError(String msg) {
		System.out.println(msg);
	}
}
