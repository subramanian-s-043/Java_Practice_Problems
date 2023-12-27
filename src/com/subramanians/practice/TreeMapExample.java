package com.subramanians.practice;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapExample {
	Scanner scanner=new Scanner(System.in);
	Map<LocalTime,String> scheduler=new TreeMap<>();
	List<LocalTime> availableTimes=new ArrayList<>();
	String prev="";
	public TreeMapExample(){
		if(availableTimes.isEmpty()) {
			for(int i=4;i<24;i++)
			{
				availableTimes.add(LocalTime.of(i, 0));
				availableTimes.add(LocalTime.of(i, 30));
			}
		}
	}
	
	public static void main(String[] args) {
		TreeMapExample application=new TreeMapExample();
		application.start();
	}
	
	private void start() {
		boolean run=true;
		while(run)
		{
			showMessage("+--------------------------------------------+");
			showMessage("|\t  Daily Event Scheduler        \t|");
			showMessage("+--------------------------------------------+");
			showMessage(" 1.Add Event \n 2.View Today's Plan \n 3.Cancel Event \n 4.Exit");
			showMessage("Enter Your Choice: ");
			int choice=scanner.nextInt();
			switch(choice) {
			case 1:
				addEvent();
				break;
			case 2:
				viewEvent();
				break;
			case 3:
				cancelEvent();
				break;
			case 4:
				run=false;
				break;
			}	
		}
		
	}
	
	private void cancelEvent() {
		viewEvent();
		showMessage("Enter the Time to Cancel: ");
		String time=scanner.nextLine();
		scheduler.remove(LocalTime.parse(time));
		showMessage("Sucessfully Event Removed!!");
	}

	private void viewEvent() {
		showMessage("Today Planned Events!!");
		showMessage("+-------------------------------------------+");
		if(scheduler.isEmpty()) {
			showMessage("No Events Planned!!");
			showMessage("+-------------------------------------------+");
			return;
		}else {
			for(Map.Entry<LocalTime, String> temp: scheduler.entrySet())
			{
				showMessage(temp.getKey()+" => "+temp.getValue());
			}	
		}
		showMessage("+-------------------------------------------+");
	}

	private void addEvent() {
		showTimings();
		int option=scanner.nextInt();
		scanner.nextLine();
		if(isAvailable(option)) 
		{
			showMessage("Enter the Event To Add: ");
			String event=scanner.nextLine();
			if(prev.equals(""))
			{
				scheduler.put(availableTimes.get(option-1), event);
			}else {
				scheduler.put(availableTimes.get(option-1), prev+"\n"+event);
				prev="";
			}
		}
	}

	private void showTimings() {
		showMessage("+-------------------------------------------+");
		int option=1;
		for(int i=0;i<availableTimes.size();i++) {
			showMessage((option++) +"->"+String.valueOf(availableTimes.get(i)));
		}
		showMessage("+-------------------------------------------+");
		showMessage("Enter the Time to create: ");
	}

	private boolean isAvailable(int option) {
		if(scheduler.containsKey(availableTimes.get(option-1)))
		{
			showMessage(scheduler.get(availableTimes.get(option-1))+" Event Scheduled!");
			showMessage("To Replace the event press Y, To add more Event press M, To abort N");
			char choice=scanner.next().charAt(0);
			if(choice=='Y') {
				return true;
			}else if(choice=='M') {
				if(prev.equals("")) {
					prev=scheduler.get(availableTimes.get(option-1));
				}
				return true;
			}else {
				return false;
			}
		}else {
			return true;
		}
	}
	
	private void showMessage(String msg) {
		System.out.println(msg);
	}
	
}
