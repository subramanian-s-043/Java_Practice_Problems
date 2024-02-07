package com.subramanians.snakeladder;

import com.subramanians.snakeladder.getdetails.GetDetailsView;

public class SnakeLadder {
	public static void main(String[] args) {
		SnakeLadder app = new SnakeLadder();
		app.start();
	}

	private void start() {
		GetDetailsView details=new GetDetailsView();
		details.getInput();
	}
}