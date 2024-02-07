package com.subramanians.snakeladder.play;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import com.subramanians.snakeladder.dto.Players;
import com.subramanians.snakeladder.repo.Repository;

public class PlayViewModel {
	PlayView playView;
	Repository repo;
	boolean isPlaying = true;
	String[][] board;
	int index=0;
	HashMap<Integer,Integer> snakes;
	HashMap<Integer,Integer> ladders;
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
			this.snakes=repo.getSnakes();
			this.ladders=repo.getLadders();
		}
		currentPlayer = numberOfPlayers.get(index++);
		if(index == numberOfPlayers.size()){
			index=0;
		}
		return currentPlayer.getName();
	}

	public void rollDice() {
		Random random=new Random();
		int dice = random.nextInt(6) + 1;
		int currPos = currentPlayer.getCurrPos();
		playView.printMessage(currentPlayer.getName()+" rolled a "+dice);
		int change = currPos + dice;
		if(isSnake(change))
		{
			currentPlayer.setCurrPos(snakes.get(change));
			playView.printMessage("Snake Bitten!!"+currentPlayer.getName()+" moves from "+currPos+" to "+(snakes.get(change)));
		}else if(isLadder(change)) {
			currentPlayer.setCurrPos(ladders.get(change));
			playView.printMessage("There is a Ladder!!"+currentPlayer.getName()+" moves from "+currPos+" to "+(ladders.get(change)));
		}else {
			currentPlayer.setCurrPos(change);
			playView.printMessage(currentPlayer.getName()+" moves from "+currPos+" to "+(change));
		}
		if(change >= board.length * board.length)
		{
			isPlaying=false;
			showWin();
		}
	}
	
	private boolean isLadder(int change) {
		if(ladders.containsKey(change))
		{
			return true;
		}
		return false;
	}

	private boolean isSnake(int change) {
		if(snakes.containsKey(change))
		{
			return true;
		}
		return false;
	}

	private void showWin() {
		playView.printMessage(currentPlayer.getName()+"Wins the Match!!.");
	}
	public int getMinSteps()
	{
		Queue<int[]> minPath = new LinkedList<>();
		boolean[] isVisited=new boolean[board.length+1];
		minPath.offer(new int[]{0,0});
		while(!minPath.isEmpty())
		{
			int[] curr=minPath.poll();
			int pos = curr[0];
			int move = curr[1];
			for(int i=1;i<=6;i++)
			{
				int nextPos = pos + i;
				if(ladders.containsKey(nextPos))
				{
					nextPos = ladders.get(nextPos);
				}
				if(nextPos == board.length)
				{
					return move+1;
				}
				if((!isVisited[nextPos])&&(!snakes.containsKey(nextPos) || nextPos > board.length))
				{
					minPath.offer(new int[] {nextPos,move+1});
					isVisited[nextPos]=true;
				}
			}
		}
		return 0;
	}
}




//private int changePos(int currPos, int dice) {
//int changedPos=currPos+dice;
//if(currPos==0)
//{
//	currentPlayer.setCurrPos(changedPos);
//	return changedPos;
//}else {
//	int row= (changedPos)-1 / board.length;
//	int col= (changedPos)-1 % board.length;
//	if(board[row][col].equals(""))
//	{
//		currentPlayer.setCurrPos(changedPos);
//		playView.printMessage(currentPlayer.getName()+" moves from "+currPos+" to "+(changedPos));
//	}else {
//		String[] obs = board[row][col].split(" ");
//		if(obs[0].equals("H"))
//		{
//			changedPos=((Integer.valueOf(obs[1])*board.length) + Integer.valueOf(obs[2])) + 1;
//			currentPlayer.setCurrPos(changedPos);
//			playView.printMessage("Snake Bitten!!"+currentPlayer.getName()+" moves from "+currPos+" to "+(changedPos));
//			return changedPos;
//		}else {
//			changedPos=((Integer.valueOf(obs[1])*board.length) + Integer.valueOf(obs[2])) + 1;
//			currentPlayer.setCurrPos(changedPos);
//			playView.printMessage("There is a Ladder!!"+currentPlayer.getName()+" moves from "+currPos+" to "+(changedPos));
//			return changedPos;
//		}
//	}
//}
//return 0;
//}