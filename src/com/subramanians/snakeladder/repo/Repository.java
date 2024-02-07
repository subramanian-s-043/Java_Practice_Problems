package com.subramanians.snakeladder.repo;

import java.util.HashMap;
import java.util.List;

import com.subramanians.snakeladder.dto.Players;

public class Repository {
	static Repository repo;
	String[][] board;
	List<Players> numbersOfPlayers;
	HashMap<Integer, Integer> snakes=new HashMap<>();
	HashMap<Integer,Integer> ladders=new HashMap<>();
	
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

	public void setSnakes(int start, int end) {
		snakes.put(start, end);
	}

	public void setLadders(int start, int end) {
		ladders.put(start, end);
		
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

	public HashMap<Integer, Integer> getSnakes() {
		return snakes;
	}

	public HashMap<Integer, Integer> getLadders() {
		return ladders;
	}
}
