package com.subramanians.interviewpanel.viewcandidate;

import java.util.List;

import com.subramanians.interviewpanel.Utility;
import com.subramanians.interviewpanel.dto.Candidate;
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
	public List<Candidate> completed(){
		if(repo.getCompleted().isEmpty())
		{
			viewcandidate.onSuccess(Utility.RED+"Interview Not Started!!"+Utility.RESET);
		}
		return repo.getCompleted();
	}
}
