package com.subramanians.cricketscore;

import java.util.Scanner;

import com.subramanians.cricketscore.show.ShowView;

public class CricketScoreShower {
	public static void main(String[] args) {
		CricketScoreShower app=new CricketScoreShower();
		app.start();
	}
	
	private void start() {
		boolean run=true;
		Scanner scanner=new Scanner(System.in);
		ShowView show=new ShowView();
		while(run)
		{
		System.out.println("+---------------------------------------------------------------------+");
		System.out.println("+\t Cricket Score-Board \t+");
		System.out.println("+---------------------------------------------------------------------+");
		System.out.println(" 1.Start Match \n 2.View Previous Match \n 3.Exit ");
		int choice=scanner.nextInt();
		switch(choice) {
		case 1:
			show.getInput();
			break;
		case 2:
			show.getMatchno();
			break;
		case 3:
			run=false;
			break;
		}
		}
	}
}