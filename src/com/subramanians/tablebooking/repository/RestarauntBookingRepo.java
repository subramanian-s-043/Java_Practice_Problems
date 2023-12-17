package com.subramanians.tablebooking.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import com.subramanians.tablebooking.dto.Customer;
import com.subramanians.tablebooking.dto.Table;

public class RestarauntBookingRepo {
	private static RestarauntBookingRepo repo;
	Connection connection=null;
	String username="root";
	String password="admin";
	String url="jdbc:mysql://localhost:3306/restaurant_table_booking";
	PreparedStatement statement;
	ResultSet result;
	List<Table> retrived=new ArrayList<>();
	List<LocalTime> bookedTimes=new ArrayList<>();
	List<Customer> bookedCustomer=new ArrayList<>();
	int availableSeats;
	
	public RestarauntBookingRepo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error In Connecting With Database!,Please Import the SQL file !!");
		}
	}
	
	public static RestarauntBookingRepo getInstance()
	{
		if(repo==null)
		{
			repo=new RestarauntBookingRepo();
		}
		return repo;
	}
	
	
	
	public List<Table> retrieveResutarant(LocalDate date) {
		if(retrived.isEmpty())
		{
			try {
				statement=connection.prepareStatement("select * from restaurant_details where "+date.toString()+" <= bookingCloseDate;");
				result=statement.executeQuery();
				while(result.next())
				{
					String name=result.getString("restaurantName");
					int tables=result.getInt("totalNumberOfTables");
					int capacity=result.getInt("eachTableCapacity");
					retrived.add(new Table(name,tables,capacity));
				}
			} catch (SQLException e) {
				System.out.println("Error In DB!");
			}
		}
		return retrived;
	}
	
	
	
	public List<LocalTime> retrieveAvailability(int option,LocalDate date) {
		try {
			bookedTimes.clear();
			statement=connection.prepareStatement("select * from booked_tables where restaurantName=? and dateReservedFor=?");
			statement.setString(1, retrived.get(option-1).getRestaurantName());
			statement.setDate(2, Date.valueOf(date));
			result=statement.executeQuery();
			while(result.next())
			{
				Time temp=result.getTime("timeReservedFor");
				bookedTimes.add(LocalTime.parse(String.valueOf(temp)));
			}
		} catch (SQLException e) {
			System.out.println("Error In DB!");
		}
		return bookedTimes;
	}
	
	
	
	public Customer getCustomer(int bookingId) {
		if(bookedCustomer.isEmpty())
		{
			getCustomer();
		}
		for(Customer c:bookedCustomer) {
			if(c.getBookingId()==bookingId) {
				return c;
			}
		}
		return bookedCustomer.isEmpty() ? new Customer() : bookedCustomer.getLast();
	}
	
	
	
	public int getAvailability(String restaurantName,LocalDate date) {
		try {
			statement=connection.prepareStatement("select * from available_tables where Date=? and restaurantName=?");
			statement.setDate(1, Date.valueOf(date));
			statement.setString(2, restaurantName);
			result=statement.executeQuery();
			while(result.next())
			{
				availableSeats=result.getInt("availableTable");
			}
		} catch (SQLException e) {
			System.out.println("Error In DB!");
		}
		return availableSeats;
	}
	
	
	
	public void getCustomer() {
		try {
			statement=connection.prepareStatement("select * from booked_tables");
			result=statement.executeQuery();
			while(result.next())
			{
				String name=result.getString("customerName");
				int bookingId=result.getInt("bookingId");
				String hotelName=result.getString("restaurantName");
				int numberOfpepole=result.getInt("numberOfPeople");
				Date tempDate=result.getDate("dateReservedFor");
				Time tempTime=result.getTime("timeReservedFor");
				bookedCustomer.add(new Customer(bookingId,name,hotelName,numberOfpepole,LocalDate.parse(String.valueOf(tempDate)),LocalTime.parse(String.valueOf(tempTime))));
			}
		} catch (SQLException e) {
			System.out.println("Error In DB!");
		}
	}
	
	
	
	public int getBookingId() {
		getCustomer();
		return bookedCustomer.isEmpty() ? 1 : bookedCustomer.size();
	}
	
	
	
	public void updateAvailability(Customer c) {
		try {
			statement=connection.prepareStatement("Update available_tables Set availableTable=? where Date=? AND restaurantName=?");
			statement.setInt(1, --availableSeats);
			statement.setDate(2, Date.valueOf(c.getDate()));
			statement.setString(3, c.getbookedRestaurant());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error In DB!");
		}
	}
	
	
	
	public boolean book(Customer c) {
		bookedCustomer.add(c);
		try {
			updateAvailability(c);
			statement=connection.prepareStatement("Insert into booked_tables (bookingId,customerName,restaurantName,dateReservedFor,timeReservedFor,numberOfPeople)VALUES(?,?,?,?,?,?)");
			statement.setInt(1,c.getBookingId());
			statement.setString(2,c.getCustomerName());
			statement.setString(3, c.getbookedRestaurant());
			statement.setDate(4, Date.valueOf(c.getDate()));
			statement.setTime(5, Time.valueOf(c.getTime()));
			statement.setInt(6, c.getnumberOfPeoples());
			int rowsAffected=statement.executeUpdate();
			if(rowsAffected > 0)
			{
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Error In DB!");
		}
		return false;
	}

	
	
	public boolean cancelTable(int bookingId) {
		if(bookedCustomer.isEmpty()) {
			getCustomer();
		}
		Customer c = null;
		int availableSeats=0;
		for(Customer a:bookedCustomer) {
			if(a.getBookingId()==bookingId) {
				c=a;
				break;
			}
		}
		if(c!=null)
		{
			try {
				statement=connection.prepareStatement("Select * from available_tables where date=? and restaurantName=?");
				statement.setDate(1, Date.valueOf(c.getDate()));
				statement.setString(2, c.getbookedRestaurant());
				result=statement.executeQuery();
				while(result.next())
				{
					availableSeats=result.getInt("availableTable")+1;
				}
				statement=connection.prepareStatement("Update available_tables Set availableTable=? where date=? AND restaurantName=?");
				statement.setInt(1, availableSeats);
				statement.setDate(2, Date.valueOf(c.getDate()));
				statement.setString(3, c.getbookedRestaurant());
				int rowsAffected=statement.executeUpdate();
				statement=connection.prepareStatement("Delete from booked_tables where bookingId=?");
				statement.setInt(1, bookingId);
				rowsAffected=statement.executeUpdate();
				bookedCustomer.remove(c);
				return true;
			}catch(SQLException e) {
				System.out.println("Error In DB!");
			}
		}else {
			return false;
		}
		return false;
	}
}
