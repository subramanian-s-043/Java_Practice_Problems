package com.subramanians.tablebooking.booktable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.subramanians.tablebooking.dto.Customer;
import com.subramanians.tablebooking.dto.Table;
import com.subramanians.tablebooking.repository.RestarauntBookingRepo;

class BookTableViewModel {
	BookTableView bookTableView;
	RestarauntBookingRepo repo;
	List<LocalDate> dates=new ArrayList<>();
	List<LocalTime> availableTime=new ArrayList<>();
	String restaurantChosen;
	LocalDate currentlyChosen;
	LocalTime currentlyChosenTime;
	List<Table> retrieved=new ArrayList<>();
	
	public BookTableViewModel(BookTableView bookTableView) {
		this.bookTableView=bookTableView;
		this.repo=RestarauntBookingRepo.getInstance();
	}
	public List<LocalDate> generateDates() {
		LocalDate today=LocalDate.now();
		for(LocalDate i=today;i.isEqual(today.plusDays(10))|| i.isBefore(today.plusDays(10));i=i.plusDays(1))
		{
			dates.add(i);
		}
		return dates;
	}
	public void retrieveRestaurant(int option) {
		currentlyChosen=dates.get(option-1);
		retrieved=repo.retrieveResutarant(currentlyChosen);
		bookTableView.printResutaurants(retrieved);
	}
	public void book(String name,int numberOfpeople) {
		int availability=repo.getAvailability(restaurantChosen, currentlyChosen);
		if(availability >=1)
		{
			int bookingId=repo.getBookingId();
			if(bookingId>1)
			{
				bookingId++;
			}
			repo.book(new Customer(bookingId, name, restaurantChosen, numberOfpeople, currentlyChosen, currentlyChosenTime));
			bookTableView.printSuccess(repo.getCustomer(bookingId));
		}else {
			bookTableView.showError("Sorry Booking Not Yet Opened!, Please Contact Restaurant.");
		}
	}
	public void retrieveAvailability(int option) {
		restaurantChosen=retrieved.get(option-1).getRestaurantName();
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(22, 0);
        int intervalMinutes = 30;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime currentTime;
        if(currentlyChosen.isEqual(LocalDate.now()))
        {
        	if(LocalTime.now().getMinute() >= 30)
        	{
        		int temp=LocalTime.now().getHour()+1;
        		currentTime=LocalTime.of(temp,0);
        	}else {
        		currentTime=LocalTime.of(LocalTime.now().getHour(),30);
        	}
        }else {
        	currentTime=startTime;
        }
        while (currentTime.isBefore(endTime) || currentTime.equals(endTime)) {
            String formattedTime = currentTime.format(formatter);
            availableTime.add(currentTime);
            currentTime = currentTime.plusMinutes(intervalMinutes);
        }
		for(LocalTime t:repo.retrieveAvailability(option, currentlyChosen))
		{
			availableTime.remove(t);
		}
		bookTableView.printAvailableTime(availableTime);
	}
	public void setTime(int option) {
		currentlyChosenTime=availableTime.get(option-1);
	}
	public boolean validateNumberOfPeople(int numberOfPeople) {
		if(numberOfPeople>4)
		{
			bookTableView.showError("Maximum 4 people allowed for one booking");
			return true;
		}else {
			return false;
		}
	}
	public boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
	}
}
