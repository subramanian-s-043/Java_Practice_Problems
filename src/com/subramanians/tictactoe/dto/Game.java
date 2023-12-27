package com.subramanians.tictactoe.dto;

public class Game {
	String playerX;
	String playerO;
	char[][] game;
	
	public Game(String player1,String player2) {
		this.playerX=player1;
		this.playerO=player2;
	}

	public String getPlayer1() {
		return playerX;
	}

	public void setPlayer1(String player1) {
		this.playerX = player1;
	}

	public String getPlayer2() {
		return playerO;
	}

	public void setPlayer2(String player2) {
		this.playerO = player2;
	}

	public char[][] getGame() {
		return game;
	}

	public void setGame(char[][] game) {
		this.game = game;
	}
	
}
