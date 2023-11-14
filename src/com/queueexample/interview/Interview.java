package com.queueexample.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Interview {
	private Queue<Candidate> candidates = new LinkedList<Candidate>();
	int s_no=0;
	Timer timer=new Timer();
	public static class Candidate{
		private int S_No;
		private String Name;
		private int Age;
		private String Qualification;
		private String Role;
		private int Experience;
		Candidate(int s_no,String name,int age,String qualification,String role,int exp)
		{
			this.S_No=s_no;
			this.Name=name;
			this.Age=age;
			this.Qualification=qualification;
			this.Role=role;
			this.Experience=exp;
		}
		public int getS_No() {
			return S_No;
		}
		public void setS_No(int s_No) {
			S_No = s_No;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public int getAge() {
			return Age;
		}
		public void setAge(int age) {
			Age = age;
		}
		public String getQualification() {
			return Qualification;
		}
		public void setQualification(String qualification) {
			Qualification = qualification;
		}
		public String getRole() {
			return Role;
		}
		public void setRole(String role) {
			Role = role;
		}
		public int getExperience() {
			return Experience;
		}
		public void setExperience(int experience) {
			Experience = experience;
		}
		
	}
	public static void main(String[] args) {
		Interview queueExample=new Interview();
		queueExample.begin();
	}
	private void begin()
	{
		boolean isMember=true;
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("==============================================================");
		System.out.println("\t INTERVIEW SCHEDULING \t");
		System.out.println("==============================================================");
		do {
			System.out.println("1.Enroll the Name for interview.");
			System.out.println("2.View Currently Interviewing Candidate.");
			System.out.println("3.View Number Of Candidate in Queue");
			System.out.println("0.Exit the Interview");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Enter your Name:");
					String name=sc.next();
					System.out.println("Enter your Qualification:");
					String qualfication=sc.next();
					System.out.println("Enter the Role Applying for:");
					String role=sc.next();
					System.out.println("Enter your Age:");
					int age=sc.nextInt();
					System.out.println("Enter years of Experience:");
					int exp=sc.nextInt();
					candidates.add(new Candidate(++s_no, name, age, qualfication, role, exp));
					System.out.println("Candidate Added Successfull!!");
					System.out.println("==============================================================");
					break;
				case 2:
					System.out.println("==============================================================");
					if(!candidates.isEmpty())
					{
						System.out.println("Currently Interviewing Candidate: "+candidates.peek().getName());
					}else {
						System.out.println("No One is in the Queue!!");
					}
					System.out.println("==============================================================");
					break;
				case 3:
					System.out.println("==============================================================");
					System.out.println("Total Number Of Candidates Enrolled: "+candidates.size());
					System.out.println("==============================================================");
					break;
				case 0:
					choice=0;
					break;
			}
			if(isMember && !candidates.isEmpty())
			{
				isMember=false;
				invite();
			}else if(candidates.isEmpty())
			{
				isMember=false;
				timer.cancel();
			}
		}while(choice!=0);
		System.out.println("Thank You For Your Participation!!");
	}
	private void invite()
	{
		TimerTask remove=new TimerTask() {
			public void run()
			{
				if(!candidates.isEmpty())
				{
					candidates.poll();
				}
			}
		};
		timer.schedule(remove, 30000,30000);
	}
}
