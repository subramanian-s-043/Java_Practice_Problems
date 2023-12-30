package com.subramanians.rolehierarchy.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.subramanians.rolehierarchy.dto.Staff;

public class RoleHierarchyRepo {
	static RoleHierarchyRepo repo;
	Connection connection=null;
	String url="jdbc:mysql://localhost:3306/role_hierarchy";
	String username="root";
	String password="admin";
	PreparedStatement statement;
	ResultSet result;
	
	public RoleHierarchyRepo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error In Connecting With Database!,Please Import the SQL file !!");
		}	
	}
	
	public static RoleHierarchyRepo getInstance()
	{
		if(repo==null)
		{
			repo=new RoleHierarchyRepo();
		}
		return repo;
	}
	
	public boolean isCeo() {
		try {
			statement=connection.prepareStatement("Select * from roles where role_name=?");	
			statement.setString(1, "CEO");
			result=statement.executeQuery();
			if(result.next())
			{
				if(result.getBoolean("available"))
					return true;
				else
					return false;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}

	public boolean setCeo(String ceo) {
		try {
			statement=connection.prepareStatement("Update roles Set available=? where role_name=?");	
			statement.setBoolean(1, true);
			statement.setString(2, "CEO");
			int rows=statement.executeUpdate();
			if(rows > 0)
			{
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addRole(Staff temp) {
		try {
			statement=connection.prepareStatement("Insert into staffs(role_name,reporting_to,reporting_id) values (?,?,?)");
			statement.setString(1, temp.getRole());
			statement.setString(2, temp.getReportingTo());
			statement.setInt(3, temp.getId());
			int rows=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Map<Integer, Staff> getStaffs() {
		Map<Integer,Staff> temp=new HashMap<>();
		try {
			statement=connection.prepareStatement("Select * from staffs");
			result=statement.executeQuery();
			while(result.next())
			{
				temp.put(result.getInt("reporting_id"),new Staff(result.getString("role_name"),result.getString("reporting_to"),result.getInt("reporting_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
}
