package com.subramanians.interviewpanel.viewcandidate;

import com.subramanians.interviewpanel.repo.InterviewPanelRepository;

public class ViewCandidateViewModel {
	private ViewCandidate viewcandidate;
	private InterviewPanelRepository repo;
	
	public ViewCandidateViewModel(ViewCandidate viewcandidate) {
		this.viewcandidate=viewcandidate;
		this.repo=InterviewPanelRepository.getInstance();
	}
	public void getCurrentlyInterviewingCandidate() {
		viewcandidate.onSuccess(repo.currentlyInterviewing());
	}
	public void getTotalCandidate() {
		viewcandidate.onSuccess("Total Number Of Candidates in Queue: "+String.valueOf(repo.numberOfCandidates()));
	}
}
