package com.subramanians.interviewpanel.repo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import com.subramanians.interviewpanel.dto.Candidate;

public class InterviewPanelRepository {
	private static InterviewPanelRepository repo;
	private Queue<Candidate> candidatesInQueue=new LinkedList<>();
	private List<Candidate> completedcandidates=new ArrayList<>();
	Timer timer=new Timer();
	boolean start=true;
	public static InterviewPanelRepository getInstance() {
		if(repo==null)
		{
			repo=new InterviewPanelRepository();
		}
		return repo;
	}
	public void addCandidate(Candidate candidate) {
		candidatesInQueue.add(candidate);
		if(start)
		{
			start=false;
			invite();
		}
	}
	public int numberOfCandidates() {
		return candidatesInQueue.size();
	}
	public String currentlyInterviewing() {
		return !candidatesInQueue.isEmpty() ? candidatesInQueue.peek().getName() : "No One In Queue!!";
	}
	public List<Candidate> getCompleted(){
		return completedcandidates;
	}
	private void invite()
	{
		TimerTask remove=new TimerTask() {
			public void run()
			{
				if(!candidatesInQueue.isEmpty())
				{
					completedcandidates.add(candidatesInQueue.poll());
				}else {
					start=true;
					timer.cancel();
				}
			}
		};
		timer.schedule(remove, 30000,30000);
	}
	
}
