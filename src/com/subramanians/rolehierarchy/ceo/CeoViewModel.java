package com.subramanians.rolehierarchy.ceo;

import com.subramanians.rolehierarchy.dto.Root;
import com.subramanians.rolehierarchy.repo.RoleHierarchyRepo;

public class CeoViewModel {
	CeoView ceoView;
	RoleHierarchyRepo repo;
	Root rootUser;
	
	public CeoViewModel(CeoView ceoView) {
		this.ceoView=ceoView;
		this.repo=RoleHierarchyRepo.getInstance();
		getCeo();
	}
	
	public void getCeo() {
		if(repo.isCeo())
		{
			ceoView.isCeo=true;
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
		}else {
			ceoView.showMessage("Error In creating Ceo");
		}
	}
}
