package com.zsgs.interviewpanel.addcandidate;

import java.util.Scanner;

import com.zsgs.interviewpanel.dto.Candidate;

public class AddCandidate {
	private AddCandidateViewMode addCandidateViewModel;  

	public AddCandidate(){
		addCandidateViewModel = new AddCandidateViewMode(this);
	}
	
	public void getCandidateInfo() {
		//getinfo logic
		Scanner sc = new Scanner(System.in);
		Candidate candidate = new Candidate();
		candidate.setName(sc.nextLine());
		addCandidateViewModel.validate(candidate);
	}

	public void onSuccess() {
		System.out.println("Inserted Successfully");

	}

	public void showError(String errorMessage) {
		System.out.println(errorMessage);
	}
}
