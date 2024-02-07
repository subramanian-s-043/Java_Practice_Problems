package com.subramanians.snakeladder.getdetails;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.subramanians.snakeladder.dto.Players;
import com.subramanians.snakeladder.repo.Repository;

public class GetDetailsViewModel {
	GetDetailsView getdetailsView;
	Repository repo = Repository.getInstance();
	String[][] board;
	List<Players> numberOfPlayers=new ArrayList<>();
	
	public GetDetailsViewModel(GetDetailsView getdetailsView) {
		this.getdetailsView=getdetailsView;
	}

	public boolean validateBoard(int board) {
		if(board < 3 || board > 20)
		{
			getdetailsView.showError("Enter a Valid Board Size!!");
			return true;
		}
		return false;
	}

	public void createBoard(int board) {
		repo.createBoard(board);
		this.board = repo.getBoard();
	}
	
	public boolean validateSnakes(int numberOfSnakes) {
		if(numberOfSnakes >= board.length)
		{
			getdetailsView.showError("Enter Valid Number of Snakes!!");
			return true;
		}
		return false;
	}

	public boolean validatePosition(int i) {
		if(i >= board.length * board.length)
		{
			getdetailsView.showError("Enter Valid Position: ");
			return true;
		}
		return false;
	}

	public boolean validateLadders(int numberOfLadders) {
		if(numberOfLadders >= board.length)
		{
			getdetailsView.showError("Enter Valid Number of Ladders!!");
			return true;
		}
		return false;
	}

	public void setSnakes(int start, int end) {
		repo.setSnakes(start,end);
	}

	public void setLadders(int start, int end) {
		repo.setLadders(start,end);
		
	}

	public void addPlayer(String name) {
		numberOfPlayers.add(new Players(name));
	}

	public void setPlayers() {
		repo.setPlayers(numberOfPlayers);
	}
}
