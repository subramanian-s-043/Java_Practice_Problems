package com.subramanians;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparator<Employee>{
	String name;
	int salary;
	
	public Employee(String name,int salary)
	{
		this.name=name;
		this.salary=salary;
	}
	public Employee() {
		
	}
	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.salary < o2.salary)
		{
			return -1;
		}else if(o1.salary > o2.salary){
			return 1;
		}
		return 0;
	}
	
}
public class RuntimePoly {
	public static void main(String[] args) {
		Employee e1 = new Employee("Mydeen",50000);
		Employee e2 =new Employee("Sanjay",45000);
		List<Employee> emp = new ArrayList<>();
		emp.add(e1);
		emp.add(e2);
		Collections.sort(emp,new Employee());
		for(Employee e: emp)
		{
			System.out.println(e.name);
		}
	}
}
