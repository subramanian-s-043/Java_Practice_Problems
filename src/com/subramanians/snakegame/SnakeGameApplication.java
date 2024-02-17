package com.subramanians.snakegame;

import com.subramanians.snakegame.appcomponents.GameFrame;

public class SnakeGameApplication {
	
	public static void main(String[] args) {
		SnakeGameApplication app = new SnakeGameApplication();
		app.start();
	}

	private void start() {
		// TODO Auto-generated method stub
		new GameFrame();
	}
}
