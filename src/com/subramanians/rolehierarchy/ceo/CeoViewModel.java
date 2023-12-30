package com.subramanians.rolehierarchy.ceo;

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

public class CeoViewModel {
	CeoView ceoView;
	RoleHierarchyRepo repo;
	Root rootUser;
	HashMap<Integer,Staff> reportingStaffs=new HashMap<>();
	
	public CeoViewModel(CeoView ceoView) {
		this.ceoView=ceoView;
		this.repo=RoleHierarchyRepo.getInstance();
		getCeo();
	}
	
	public void getCeo() {
		if(repo.isCeo())
		{
			ceoView.isCeo=true;
			rootUser=new Root("CEO");
			reportingStaffs=repo.getStaffs();
		}else {
			ceoView.isCeo=false;
		}
	}
	
	public void setCeo(String ceo)
	{
		if(repo.setCeo(ceo))
		{
			rootUser=new Root(ceo);
			ceoView.showMessage(ceo);
			reportingStaffs.put(1,new Staff(ceo,"",1));
		}else {
			ceoView.showMessage("Error In creating Ceo");
		}
	}

	public boolean validateReportingTo(String report)
	{
			for(Map.Entry<Integer, Staff> staff: reportingStaffs.entrySet())
			{
				if(staff.getValue().getRole().equals(report))
				{
					return false;
				}
			}
			ceoView.showMessage("Enter Valid Reporting Authority");
			return true;
	}
	
	public void setSubRole(String subRole,String reportingTo) {
		Staff temp;
		int reporting_id=1;
		for(Map.Entry<Integer, Staff> staff: reportingStaffs.entrySet())
		{
			if(staff.getValue().getRole().equals(reportingTo))
			{
				reporting_id=staff.getKey();
				break;
			}
		}
		temp=new Staff(subRole,reportingTo,reporting_id);
		reportingStaffs.put(reportingStaffs.size()+1, new Staff(subRole,reportingTo,reporting_id));
		repo.addRole(temp);
		
	}

	public void showReportingStaffs() {
		reportingStaffs=sortByValue(reportingStaffs);
		
		for(Map.Entry<Integer, Staff> staff: reportingStaffs.entrySet())
		{
			ceoView.showMessage(staff.getValue().getRole()+",");
		}
		ceoView.showMessage("");
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
		for(Map.Entry<Integer, Staff> staff: reportingStaffs.entrySet())
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
		for(Map.Entry<Integer, Staff> staff: reportingStaffs.entrySet())
		{
			if(staff.getValue().getId()==id)
			{
				staff.getValue().setId(replaceId);
			}
		}
		repo.updateReporting(id,reporting_to,role);
		reportingStaffs.remove(id);
	}
}
