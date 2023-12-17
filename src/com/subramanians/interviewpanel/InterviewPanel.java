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
		System.out.println("================================================");
		System.out.println(Utility.ROSECOLOR+"\t \t Interview Panel Application \t"+Utility.RESET);
		System.out.println("================================================");
		Scanner scanner=new Scanner(System.in);
		int choice=0;
		boolean run=true;
		while(run)
		{
			do {
				System.out.println(" 1.Add Candidate\n 2.View Currently Interviewing Candidate\n 3.View Number Of Candidates In queue\n 4.View Completed Candidates\n 5.Exit");
				System.out.println(Utility.CYAN+"Enter Your Choice: "+Utility.RESET);
				choice=scanner.nextInt();
			}while(validate(choice));
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
				ViewCandidate viewCompleted=new ViewCandidate();
				viewCompleted.printCompleted();
				break;
			case 5:
				run=false;
				scanner.close();
				System.exit(0);
				break;
			}
		}
	}
	private boolean validate(int choice) {
		if(choice==0 || choice>=6)
		{
			System.out.println(Utility.RED+"Enter the valid Input!!"+Utility.RESET);
			return true;	
		}else {
			return false;
		}
	}
}
