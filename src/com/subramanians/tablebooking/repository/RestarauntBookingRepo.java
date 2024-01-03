package com.subramanians.tablebooking.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.subramanians.tablebooking.dto.Booking;
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
	List<Booking> bookedCustomer=new ArrayList<>();
	private Customer currentCustomer;
	public String restaurantName;
	int availableSeats;
	int adminId;
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
	
	
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}

	public List<Table> retrieveResutarant(){//Change to boolean
		if(!retrived.isEmpty())
		{
			retrived.clear();
		}
			try {
				statement=connection.prepareStatement("select * from restaurant_details where isAvailable=?;");
				statement.setBoolean(1, true);
				result=statement.executeQuery();
				while(result.next())
				{
					String name=result.getString("restaurantName");
					int tables=result.getInt("totalNumberOfTables");
					int capacity=result.getInt("eachTableCapacity");
					boolean isAvailable=result.getBoolean("isAvailable");
					retrived.add(new Table(name,tables,capacity,isAvailable));
				}
			} catch (SQLException e) {
				System.out.println("Error In DB!");
			}
		return retrived;
	}
	
	public List<Table> retrieveAllResutarant(){//Change to boolean
		try {
			statement=connection.prepareStatement("select * from restaurant_details ;");
			result=statement.executeQuery();
			while(result.next())
			{
				String name=result.getString("restaurantName");
				int tables=result.getInt("totalNumberOfTables");
				int capacity=result.getInt("eachTableCapacity");
				boolean isAvailable=result.getBoolean("isAvailable");
				retrived.add(new Table(name,tables,capacity,isAvailable));
			}
		} catch (SQLException e) {
			System.out.println("Error In DB!");
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
	
	
	
	public Booking getBooking(int bookingId) {
		if(bookedCustomer.isEmpty())
		{
			getBooking();
		}
		for(Booking c:bookedCustomer) {
			if(c.getBookingId()==bookingId) {
				return c;
			}
		}
		return bookedCustomer.isEmpty() ? new Booking() : bookedCustomer.getLast();
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
	
	
	
	public void getBooking() {
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
				bookedCustomer.add(new Booking(bookingId,name,hotelName,numberOfpepole,LocalDate.parse(String.valueOf(tempDate)),LocalTime.parse(String.valueOf(tempTime))));
			}
		} catch (SQLException e) {
			System.out.println("Error In DB!");
		}
	}
	
	
	
	public int getBookingId() {
		getBooking();
		return bookedCustomer.isEmpty() ? 1 : bookedCustomer.size();
	}
	
	//Update Availablity
	
	public void updateAvailability(Booking c) {
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
	
	//Update Local
	public void addToHistory(Booking c)
	{
		List<Booking> temp=currentCustomer.getBookingHistory();
		temp.add(c);
		currentCustomer.setBookingHistory(temp);
	}
	
	//Book Table
	
	public boolean book(Booking c) {
		bookedCustomer.add(c);
		addToHistory(c);
		try {
			statement=connection.prepareStatement("Insert into booked_tables (bookingId,customerName,restaurantName,dateReservedFor,timeReservedFor,numberOfPeople,user_id)VALUES(?,?,?,?,?,?,?)");
			statement.setInt(1,c.getBookingId());
			statement.setString(2,c.getCustomerName());
			statement.setString(3, c.getbookedRestaurant());
			statement.setDate(4, Date.valueOf(c.getDate()));
			statement.setTime(5, Time.valueOf(c.getTime()));
			statement.setInt(6, c.getnumberOfPeoples());
			statement.setInt(7, currentCustomer.getId());
			int rowsAffected=statement.executeUpdate();
			if(rowsAffected > 0)
			{
				if(updateCustomer())
				{
					return true;
				}
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Error In DB!");
		}
		return false;
	}

	//Cancel Table
	
	public boolean cancelTable(int bookingId) {
		if(bookedCustomer.isEmpty()) {
			getBooking();
		}
		Booking c = null;
		int availableSeats=0;
		for(Booking a:currentCustomer.getBookingHistory()) {
			if(a.getBookingId()==bookingId) {
				c=a;
				break;
			}
		}
		if(c!=null && c.getDate().isAfter(LocalDate.now()))
		{
			try {
				statement=connection.prepareStatement("Delete from booked_tables where bookingId=?");
				statement.setInt(1, bookingId);
				int rowsAffected=statement.executeUpdate();
				currentCustomer.getBookingHistory().remove(c);
				return true;
			}catch(SQLException e) {
				System.out.println("Error In DB!");
			}
		}else if(c!=null){
			return false;
		}
		return false;
	}

	public List<Booking> getBookingHistory(int customer_id) {
		List<Booking> temp=new ArrayList<>();
		try {
			statement=connection.prepareStatement("select * from booked_tables where user_id=?");
			statement.setInt(1, customer_id);
			result=statement.executeQuery();
			while(result.next())
			{
				String name=result.getString("customerName");
				int bookingId=result.getInt("bookingId");
				String hotelName=result.getString("restaurantName");
				int numberOfpepole=result.getInt("numberOfPeople");
				Date tempDate=result.getDate("dateReservedFor");
				Time tempTime=result.getTime("timeReservedFor");
				temp.add(new Booking(bookingId,name,hotelName,numberOfpepole,LocalDate.parse(String.valueOf(tempDate)),LocalTime.parse(String.valueOf(tempTime))));
			}
			return temp;
		} catch (SQLException e) {
			System.out.println("Error In DB!");
		}
		return null;
	}
	
	public boolean isValidAdmin(String username, String password) {
		try {
			statement=connection.prepareStatement("Select * from admin_details where username=? and password=?");
			statement.setString(1, username);
			statement.setString(2, password);
			result=statement.executeQuery();
			while(result.next())
			{
				adminId=result.getInt("admin_id");
				restaurantName=result.getString("restaurant_Name");
				return true;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public Table getDetails() {
		retrived=retrieveAllResutarant();
		String restaurantName="";
		try {
			statement=connection.prepareStatement("Select * from restaurant_details where admin_id=?");
			statement.setInt(1, adminId);
			result=statement.executeQuery();
			while(result.next())
			{
				restaurantName=result.getString("restaurantName");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		for(int i=0;i<retrived.size();i++)
		{
			if(retrived.get(i).getRestaurantName().equals(restaurantName))
			{
				return retrived.get(i);
			}
		}
		return null;
		
	}

	public void updateDetails(Table current) {
		try {//Update Admin
			statement=connection.prepareStatement("Update restaurant_details set restaurantName=?,totalNumberOfTables=?,isAvailable=? where admin_id=?");
			statement.setString(1, current.getRestaurantName());
			statement.setInt(2, current.getTotalNumberOfTable());
			statement.setBoolean(3, current.getIsAvailable());
			statement.setInt(4, adminId);
			int rows=statement.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	public boolean isValidUser(String username, String password) {
		try {
			statement=connection.prepareStatement("Select * from user_details where username=? and password=?");
			statement.setString(1, username);
			statement.setString(2, password);
			result=statement.executeQuery();
			while(result.next())
			{
				int id=result.getInt("customer_id");
				String name=result.getString("customer_name");
				String userName=result.getString("username");
				String pass=result.getString("password");
				List<Booking> temp=getBookingHistory(id);
				setCurrentCustomer(new Customer(id,name,userName,pass,temp));
				return true;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean createUser(String username, String password, String name) {
		try {
			statement=connection.prepareStatement("Insert into user_details (customer_name,username,password) values(?,?,?)");
			statement.setString(1, name);
			statement.setString(2, username);
			statement.setString(3, password);
			int rows=statement.executeUpdate();
			if(rows > 0)
			{
				return true;
			}else {
				return false;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean validateUsername(String username) {
		try {
			statement=connection.prepareStatement("Select * from user_details where username=?");
			statement.setString(1, username);
			result=statement.executeQuery();
			while(result.next())
			{
				return true;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateCustomer() {
		try {
			statement=connection.prepareStatement("Update user_details Set customer_name=?,username=?,password=? where customer_id=?");
			statement.setString(1, currentCustomer.getName());
			statement.setString(2, currentCustomer.getUsername());
			statement.setString(3, currentCustomer.getPassword());
			statement.setInt(4, currentCustomer.getId());
			int rows=statement.executeUpdate();
			if(rows > 0)
			{
				return true;
			}else {
				return false;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
}
