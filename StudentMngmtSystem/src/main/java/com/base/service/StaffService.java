package com.base.service;

import java.util.List;
import com.base.entity.StaffEntity;

public interface StaffService {
	
	public void addstaff(StaffEntity staff);

	public StaffEntity findByStaffMailAndStaffPassword(String staffMail, String staffPassword);

	public List<StaffEntity> displayAllStaffList();
	
	public StaffEntity findByStaffId(int id);
	
	
	public void deleteByStaffId(int id);
	
	
}
