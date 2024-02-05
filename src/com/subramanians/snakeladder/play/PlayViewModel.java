package com.subramanians.snakeladder.play;

import java.util.List;
import java.util.Random;
import com.subramanians.snakeladder.dto.Players;
import com.subramanians.snakeladder.repo.Repository;

public class PlayViewModel {
	PlayView playView;
	Repository repo;
	boolean isPlaying = true;
	int index=0;
	String[][] board;
	List<Players> numberOfPlayers=null;
	Players currentPlayer=null;
	
	public PlayViewModel(PlayView playView) {
		this.playView=playView;
		this.repo=Repository.getInstance();
	}

	public String getCurrentPlayer() {
		if(numberOfPlayers==null)
		{
			this.board=repo.getBoard();
			this.numberOfPlayers=repo.getNumberOfPlayers();
		}
		currentPlayer = numberOfPlayers.get(index++);
		if(index == numberOfPlayers.size()-1){
			index=0;
		}
		return currentPlayer.getName();
	}

	public void rollDice() {
		Random random=new Random();
		int dice = random.nextInt(6) + 1;
		int currPos = currentPlayer.getCurrPos();
		playView.printMessage(currentPlayer.getName()+" rolled a "+dice);
		int change=changePos(currPos,dice);
		if(change >= board.length * board.length)
		{
			isPlaying=false;
			showWin();
		}
	}
	
	private int changePos(int currPos, int dice) {
		int changedPos=currPos+dice;
		if(currPos==0)
		{
			currentPlayer.setCurrPos(changedPos);
			return changedPos;
		}else {
			int row= (changedPos)-1 / board.length;
			int col= (changedPos)-1 % board.length;
			if(board[row][col].equals(""))
			{
				currentPlayer.setCurrPos(changedPos);
				playView.printMessage(currentPlayer.getName()+" moves from "+currPos+" to "+(changedPos));
			}else {
				String[] obs = board[row][col].split(" ");
				if(obs[0].equals("H"))
				{
					changedPos=((Integer.valueOf(obs[1])*board.length) + Integer.valueOf(obs[2])) + 1;
					currentPlayer.setCurrPos(changedPos);
					playView.printMessage("Snake Bitten!!"+currentPlayer.getName()+" moves from "+currPos+" to "+(changedPos));
					return changedPos;
				}else {
					changedPos=((Integer.valueOf(obs[1])*board.length) + Integer.valueOf(obs[2])) + 1;
					currentPlayer.setCurrPos(changedPos);
					playView.printMessage("There is a Ladder!!"+currentPlayer.getName()+" moves from "+currPos+" to "+(changedPos));
					return changedPos;
				}
			}
		}
		return 0;
	}

	private void showWin() {
		playView.printMessage(getCurrentPlayer()+"Wins the Match!!.");
	}
}
