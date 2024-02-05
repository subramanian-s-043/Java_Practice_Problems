package com.subramanians.snakeladder.repo;

import java.util.List;

import com.subramanians.snakeladder.dto.Players;

public class Repository {
	static Repository repo;
	String[][] board;
	List<Players> numbersOfPlayers;
	
	public static Repository getInstance() {
		if(repo==null)
		{
			repo=new Repository();
		}
		return repo;
	}

	public void createBoard(int board) {
		this.board=new String[board][board];
	}

	public String[][] getBoard() {
		return board;
	}

	public void setSnakes(int[] start, int[] end) {
		board[start[0]][start[1]]="H "+String.valueOf(end[0])+" "+String.valueOf(end[1]);
	}

	public void setLadders(int[] start, int[] end) {
		board[start[0]][start[1]]="L "+String.valueOf(end[0])+" "+String.valueOf(end[1]);
		
	}

	public void setPlayers(List<Players> numberOfPlayers) {
		this.numbersOfPlayers=numberOfPlayers;
	}
	
	public void setBoard(String[][] board) {
		this.board=board;
	}
	
	public List<Players> getNumberOfPlayers(){
		return numbersOfPlayers;
	}
}
