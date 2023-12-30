package com.subramanians.rolehierarchy.ceo;

import java.util.HashMap;
import java.util.Map;

import com.subramanians.rolehierarchy.dto.Root;
import com.subramanians.rolehierarchy.dto.Staff;
import com.subramanians.rolehierarchy.repo.RoleHierarchyRepo;

public class CeoViewModel {
	CeoView ceoView;
	RoleHierarchyRepo repo;
	Root rootUser;
	Map<Integer,Staff> reportingStaffs;
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
			reportingStaffs=new HashMap<>();
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
			reportingStaffs=new HashMap<>();
		}else {
			ceoView.showMessage("Error In creating Ceo");
		}
	}

	public boolean validateReportingTo(String report)
	{
		if(reportingStaffs.isEmpty() || rootUser.getRole().equals(report))
		{
			if(rootUser.getRole().equals(report))
			{
				return false;
			}else {
				ceoView.showMessage("Enter Valid Reporting Authority");
				return true;
			}
		}else {
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
	}
	
	public void setSubRole(String subRole,String reportingTo) {
		if(reportingStaffs.isEmpty())
		{
			reportingStaffs.put(1, new Staff(subRole,reportingTo,1));
		}else {
			reportingStaffs.put(reportingStaffs.size()+1, new Staff(subRole,reportingTo,reportingStaffs.size()+1));
		}
		
	}

	public void showReportingStaffs() {
		ceoView.showMessage(rootUser.getRole());
		for(Map.Entry<Integer, Staff> staff: reportingStaffs.entrySet())
		{
			ceoView.showMessage(","+staff.getValue().getRole());
		}
		ceoView.showMessage("");
	}
}
