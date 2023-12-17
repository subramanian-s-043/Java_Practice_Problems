package com.subramanians.interviewpanel.viewcandidate;

import com.subramanians.interviewpanel.dto.Candidate;

public class ViewCandidate {
	ViewCandidateViewModel viewcandidateViewModel;
	public ViewCandidate() {
		viewcandidateViewModel=new ViewCandidateViewModel(this);
	}
	public void getCurrentlyInterviewing() {
		viewcandidateViewModel.getCurrentlyInterviewingCandidate();
	}
	public void getTotalCandidate() {
		viewcandidateViewModel.getTotalCandidate();
	}
	public void printCompleted() {
		for(Candidate c:viewcandidateViewModel.completed())
		{
			System.out.println("Candidate Id: "+c.getS_No());
			System.out.println("Candidate Name: "+c.getName());
			System.out.println("Candidate Age: "+c.getAge());
			System.out.println("Candidate Experience: "+c.getExperience());
		}
	}
	public void onSuccess(String msg) {
		System.out.println(msg);
	}
}
