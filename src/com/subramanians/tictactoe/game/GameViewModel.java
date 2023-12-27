package com.subramanians.tictactoe.game;

import java.util.Arrays;
import com.subramanians.tictactoe.dto.Game;

public class GameViewModel {
	GameView gameView;
	Game current;
	boolean isPlayable=true;
	char[][] gameArea=new char[3][3];
	public GameViewModel(GameView gameView) {
		this.gameView=gameView;
	}
	
	public void setPlayers(String player1,String player2) {
		for(char[] area: gameArea) 
		{
			Arrays.fill(area, '-');
		}
		current=new Game(player1,player2);
	}

	public void setX(int row, int column) {
		gameArea[row][column]='X';
		if(checkCompleted()) {
			isPlayable=false;
			gameView.print();
			gameView.showError(current.getPlayer1()+" Wins");
		}else if(isFilled()) {
			isPlayable=false;
			gameView.showError("Game Draws!!");
			gameView.print();
		}else {
			gameView.print();
		}
	}

	public void setY(int row, int column) {
		gameArea[row][column]='O';
		if(checkCompleted()) {
			isPlayable=false;
			gameView.print();
			gameView.showError(current.getPlayer2()+" Wins!!");
		}else if(isFilled()) {
			isPlayable=false;
			gameView.showError("Game Draws!!");
			gameView.print();
		}else{
			gameView.print();
		}
	}
	
	public boolean validateRowAndColumn(int row,int Column) {
		if(row>=3 || Column>=3) {
			gameView.showError("Enter Valid Row And Column.......Min Row/Column Value: 0 And Max Row/Column Value: 2");
			return true;
		}else if(row<0 || Column<0) {
			gameView.showError("Enter Valid Row And Column.......Min Row/Column Value: 0 And Max Row/Column Value: 2");
			return true;
		}
		if(gameArea[row][Column]!='-') {
			gameView.showError("Already Occupied!");
			return true;
		}
		return false;
	}
	
	public boolean isFilled() {
		for(char[] t:gameArea) {
			for(char e: t) {
				if(e=='-') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkCompleted() {
		if(gameArea[0][0]=='X' && gameArea[0][1]=='X' && gameArea[0][2]=='X') {
			return true;
		}else if(gameArea[1][0]=='X' && gameArea[1][1]=='X' && gameArea[1][2]=='X') {
			return true;
		}else if(gameArea[2][0]=='X' && gameArea[2][1]=='X' && gameArea[2][2]=='X') {
			return true;
		}else if(gameArea[0][0]=='X' && gameArea[1][0]=='X' && gameArea[2][0]=='X') {
			return true;
		}else if(gameArea[0][0]=='X' && gameArea[1][1]=='X' && gameArea[2][2]=='X') {
			return true;
		}else if(gameArea[2][0]=='X' && gameArea[1][1]=='X' && gameArea[0][2]=='X') {
			return true;
		} else if(gameArea[0][1]=='X' && gameArea[1][1]=='X' && gameArea[2][1]=='X') {
			return true;
		}else if(gameArea[0][2]=='X' && gameArea[1][2]=='X' && gameArea[2][2]=='X') {
			return true;
		}else if(gameArea[0][0]=='O' && gameArea[0][1]=='O' && gameArea[0][2]=='X') {
			return true;
		}else if(gameArea[1][0]=='O' && gameArea[1][1]=='O' && gameArea[1][2]=='O') {
			return true;
		}else if(gameArea[2][0]=='O' && gameArea[2][1]=='O' && gameArea[2][2]=='O') {
			return true;
		}else if(gameArea[0][0]=='O' && gameArea[1][0]=='O' && gameArea[2][0]=='O') {
			return true;
		}else if(gameArea[0][0]=='O' && gameArea[1][1]=='O' && gameArea[2][2]=='O') {
			return true;
		}else if(gameArea[2][0]=='O' && gameArea[1][1]=='O' && gameArea[0][2]=='O') {
			return true;
		} else if(gameArea[0][1]=='O' && gameArea[1][1]=='O' && gameArea[2][1]=='O') {
			return true;
		}else if(gameArea[0][2]=='O' && gameArea[1][2]=='O' && gameArea[2][2]=='O') {
			return true;
		}
		return false;
	}
}
