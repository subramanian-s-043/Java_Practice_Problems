package com.subramanians.tictactoe;

import java.util.Scanner;

import com.subramanians.tictactoe.game.GameView;

public class TicTacToe {
	public static void main(String[] args) {
		TicTacToe application=new TicTacToe();
		application.start();
	}
	private void start() {
		boolean run=true;
		while(run)
		{
			GameView app=new GameView();
			Scanner scanner=new Scanner(System.in);
			System.out.println("+-------------------------------------------------------------+");
			System.out.println("\t Tic-Tac-Toe \t");
			System.out.println("+-------------------------------------------------------------+");
			System.out.println(" 1.Start Game \n 2.Exit Game ");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1: 
				app.getPlayers();
				break;
			case 2:
				System.out.println("Game Exited Successfully");
				run=false;
				break;
			}	
		}
	}
}
