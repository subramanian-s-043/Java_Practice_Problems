package com.subramanians.interviewpanel;

import java.util.Scanner;

import com.subramanians.interviewpanel.addcandidate.AddCandidateView;
import com.subramanians.interviewpanel.viewcandidate.ViewCandidate;

public class InterviewPanel {
	public static void main(String[] args) {
		InterviewPanel interviewpanel=new InterviewPanel();
		interviewpanel.start();
	}
	private void start()
	{
		boolean run=true;
		while(run)
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println(" 1.Add Candidate\n 2.View Currently Interviewing Candidate\n 3.View Number Of Candidates In queue\n 4. Exit");
			System.out.println("===========================================================================================================");
			System.out.println("Enter Your Choice: ");
			int choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				AddCandidateView add=new AddCandidateView();
				add.getInput();
				break;
			case 2:
				ViewCandidate view=new ViewCandidate();
				view.getCurrentlyInterviewing();
				break;
			case 3:
				ViewCandidate viewTotal=new ViewCandidate();
				viewTotal.getTotalCandidate();
				break;
			case 4:
				run=false;
				scanner.close();
				break;
			}
		}
	}
}
