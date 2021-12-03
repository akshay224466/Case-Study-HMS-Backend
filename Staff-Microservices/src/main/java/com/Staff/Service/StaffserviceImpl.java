package com.Staff.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Staff.Models.Staff;
import com.Staff.Repository.StaffMongodbRepo;



@Service
public class StaffserviceImpl implements Staffservice{
	
	
	@Autowired
	StaffMongodbRepo staffmongodbRepo;

	@Override
	public Staff addEmp(Staff emp) {
		// TODO Auto-generated method stub
		return staffmongodbRepo.insert(emp);
	}

	@Override
	public List<Staff> getAllEmp() {
		// TODO Auto-generated method stub
		return staffmongodbRepo.findAll();
	}

	@Override
	public Optional<Staff> getEmp(long parseLong) {
		// TODO Auto-generated method stub
		return staffmongodbRepo.findById(parseLong);
	}

	@Override
	public Staff updateEmp(Staff emp) {
		// TODO Auto-generated method stub
		return staffmongodbRepo.save(emp);
	}

	@Override
	public String deleteEmp(long parseLong) {
		staffmongodbRepo.deleteById(parseLong);
		return "Deleted employee with ID :" + parseLong;
	}

}
