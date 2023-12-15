package com.subramanians.tablebooking.repository;

public class RestarauntBookingRepo {
	private static RestarauntBookingRepo repo;
	
	public RestarauntBookingRepo() {

	}
	
	public static RestarauntBookingRepo getInstance()
	{
		if(repo==null)
		{
			repo=new RestarauntBookingRepo();
		}
		return repo;
	}
}
