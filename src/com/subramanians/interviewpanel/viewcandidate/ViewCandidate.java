package com.subramanians.interviewpanel.viewcandidate;

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
	public void onSuccess(String msg) {
		System.out.println(msg);
	}
}
