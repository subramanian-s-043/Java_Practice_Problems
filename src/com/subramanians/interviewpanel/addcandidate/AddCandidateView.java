package com.subramanians.interviewpanel.addcandidate;

import java.util.Scanner;

import com.subramanians.interviewpanel.dto.Candidate;

public class AddCandidateView {
	private AddCandidateViewModel addcandidateViewModel;
	
	public AddCandidateView() {
		addcandidateViewModel=new AddCandidateViewModel(this);
	}
	
	public void getInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("-----Enter Candidate Details----");
		System.out.println("Enter Candidate Name: ");
		String name=scanner.next();
		System.out.println("Enter Candidate Qualification: ");
		String qualification=scanner.next();
		System.out.println("Enter Candidate Age: ");
		int age=scanner.nextInt();
		System.out.println("Enter Candidate Expreience: ");
		int exp=scanner.nextInt();
		int s_no=addcandidateViewModel.getNumberofCandidates();
		Candidate candidate=new Candidate(++s_no,name,age,qualification,exp);
		addcandidateViewModel.addCandidate(candidate);
	}
	public void message(String msg) {
		System.out.println(msg);
	}
}
