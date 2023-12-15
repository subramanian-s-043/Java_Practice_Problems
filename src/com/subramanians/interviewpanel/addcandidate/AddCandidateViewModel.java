package com.subramanians.interviewpanel.addcandidate;

import com.subramanians.interviewpanel.dto.Candidate;
import com.subramanians.interviewpanel.repo.InterviewPanelRepository;

public class AddCandidateViewModel {
	private AddCandidateView addcandidateView;
	private InterviewPanelRepository repo;
	
	public AddCandidateViewModel(AddCandidateView addCandidateView) {
		this.addcandidateView=addCandidateView;
		this.repo=InterviewPanelRepository.getInstance();
	}
	public void addCandidate(Candidate candidate){
		repo.addCandidate(candidate);
		addcandidateView.message("Candidate Added Successfully!!");
	}
	public int getNumberofCandidates() {
		return repo.numberOfCandidates();
	}
}
