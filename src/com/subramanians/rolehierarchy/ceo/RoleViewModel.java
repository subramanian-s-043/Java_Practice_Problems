package com.subramanians.rolehierarchy.ceo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.subramanians.rolehierarchy.dto.Root;
import com.subramanians.rolehierarchy.dto.Staff;
import com.subramanians.rolehierarchy.repo.RoleHierarchyRepo;

public class RoleViewModel {
	RoleView roleView;
	RoleHierarchyRepo repo;
	Root rootUser;
	HashMap<Integer,Staff> reportingHierarchy=new HashMap<>();
	HashMap<Integer,List<String>> staffs=new HashMap<>();
	
	public RoleViewModel(RoleView ceoView) {
		this.roleView=ceoView;
		this.repo=RoleHierarchyRepo.getInstance();
		getCeo();
	}
	
	public void getCeo() {
		if(repo.isCeo())
		{
			roleView.isCeo=true;
			rootUser=new Root("CEO");
			reportingHierarchy=repo.getStaffs();
		}else {
			roleView.isCeo=false;
		}
	}
	
	public void setCeo(String ceo)
	{
		if(repo.setCeo(ceo))
		{
			rootUser=new Root(ceo);
			roleView.showMessage(ceo);
			reportingHierarchy.put(1,new Staff(ceo,"",1));
		}else {
			roleView.showMessage("Error In creating Ceo");
		}
	}

	public boolean validateReportingTo(String report)
	{
			for(Map.Entry<Integer, Staff> staff: reportingHierarchy.entrySet())
			{
				if(staff.getValue().getRole().equals(report))
				{
					return false;
				}
			}
			roleView.showMessage("Enter Valid Reporting Authority");
			return true;
	}
	
	public void setSubRole(String subRole,String reportingTo) {
		Staff temp;
		int reporting_id=1;
		for(Map.Entry<Integer, Staff> staff: reportingHierarchy.entrySet())
		{
			if(staff.getValue().getRole().equals(reportingTo))
			{
				reporting_id=staff.getKey();
				break;
			}
		}
		temp=new Staff(subRole,reportingTo,reporting_id);
		reportingHierarchy.put(reportingHierarchy.size()+1, new Staff(subRole,reportingTo,reporting_id));
		repo.addRole(temp);
		
	}

	public void showReportingStaffs() {
		reportingHierarchy=sortByValue(reportingHierarchy);
		
		for(Map.Entry<Integer, Staff> staff: reportingHierarchy.entrySet())
		{
			roleView.showMessage(staff.getValue().getRole()+",");
		}
		roleView.showMessage("");
	}

    public static HashMap<Integer, Staff> sortByValue(HashMap<Integer, Staff> hm)
    {
        List<Map.Entry<Integer, Staff> > list =
               new LinkedList<Map.Entry<Integer, Staff> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Staff> >() {
            public int compare(Map.Entry<Integer, Staff> o1, 
                               Map.Entry<Integer, Staff> o2)
            {
                return ((Integer)o1.getValue().getId()).compareTo((Integer) o2.getValue().getId());
            }
        });
        HashMap<Integer, Staff> temp = new LinkedHashMap<Integer, Staff>();
        for (Map.Entry<Integer, Staff> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
	
	public void deleteRole(String role,String transfer) {
		int replaceId=0;
		String reporting_to="";
		int id=0;
		for(Map.Entry<Integer, Staff> staff: reportingHierarchy.entrySet())
		{
			if(staff.getValue().getRole().equals(role))
			{
				id=staff.getKey();
			}else if(staff.getValue().getRole().equals(transfer))
			{
				replaceId=staff.getKey();
				reporting_to=staff.getValue().getRole();
			}
		}
		for(Map.Entry<Integer, Staff> staff: reportingHierarchy.entrySet())
		{
			if(staff.getValue().getId()==id)
			{
				staff.getValue().setId(replaceId);
			}
		}
		repo.updateReporting(id,reporting_to,role);
		reportingHierarchy.remove(id);
	}

	public void createUser(String username, String role) {
		int role_id=0;
		int staff_id=staffs.size();
		for(Map.Entry<Integer, Staff> staff: reportingHierarchy.entrySet())
		{
			if(staff.getValue().getRole().equals(role))
			{
				role_id=staff.getKey();
				break;
			}
		}
		if(staffs.isEmpty())
		{
			staffs.put(role_id, Arrays.asList(username));
		}else if(staffs.containsKey(role_id))
		{
			List<String> prev=staffs.get(role_id);
			prev.add(username);
			staffs.put(role_id, prev);
		}
		repo.addStaff(staff_id+1,username,role,role_id);
	}
	
	public void viewUser() {
		for(Map.Entry<Integer, List<String>> element: staffs.entrySet())
		{
			if(reportingHierarchy.containsKey(element.getKey()))
			{
				roleView.showMessage("Role: "+reportingHierarchy.get(element.getKey()).getRole());
				for(int i=0;i<element.getValue().size();i++)
				{
					roleView.showMessage("Username: "+element.getValue().get(i)+",");
				}
			}
		}
	}
	
}
