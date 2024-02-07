package com.subramanians.snakeladder.play;

import java.util.Scanner;

public class PlayView {
	PlayViewModel playViewModel;
	
	public PlayView() {
		this.playViewModel=new PlayViewModel(this);
	}
	
	public void start() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Minimum Number Of Moves required to complete the game: "+playViewModel.getMinSteps());
//		while(playViewModel.isPlaying)
//		{
//			printMessage("Player "+playViewModel.getCurrentPlayer()+" turn: ");
//			printMessage("Enter to Roll the Dice !!");
//			scanner.nextLine();
//			playViewModel.rollDice();
//		}
	}
	
	public void printMessage(String msg) {
		System.out.println(msg);
	}
}
