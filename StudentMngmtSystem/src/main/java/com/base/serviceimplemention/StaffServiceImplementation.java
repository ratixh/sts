package com.base.serviceimplemention;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.base.entity.StaffEntity;
import com.base.repository.StaffRepository;
import com.base.service.StaffService;


@Service
public class StaffServiceImplementation implements StaffService
{
	@Autowired
    private  StaffRepository staffRepository; 

	@Override
	public void addstaff(StaffEntity staff) {
		staffRepository.save(staff);
		
	}

	@Override
	public StaffEntity findByStaffMailAndStaffPassword(String staffMail, String staffPassword) {		
			 StaffEntity staffEntity=  staffRepository.findByStaffMailAndStaffPassword(staffMail, 
					 staffPassword);
			return staffEntity;
		}

	@Override
	public List<StaffEntity> displayAllStaffList() {
		return   staffRepository.findAll();
	}

	@Override
	public StaffEntity findByStaffId(int id) {
		// TODO Auto-generated method stub
		return  staffRepository.findById(id).get();
	}

	@Override
	public void deleteByStaffId(int id) {
		// TODO Auto-generated method stub
	     staffRepository.deleteById(id);
	}

	
}
