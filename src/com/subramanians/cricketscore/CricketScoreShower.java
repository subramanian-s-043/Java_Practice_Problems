package com.subramanians.cricketscore;

import com.subramanians.cricketscore.show.ShowView;

public class CricketScoreShower {
	public static void main(String[] args) {
		CricketScoreShower app=new CricketScoreShower();
		app.start();
	}
	
	private void start() {
		ShowView show=new ShowView();
		show.getInput();
	}
}