package com.Staff.Service;

import java.util.List;
import java.util.Optional;

import com.Staff.Models.Staff;



public interface Staffservice {

	Staff addEmp(Staff emp);

	List<Staff> getAllEmp();

	Optional<Staff> getEmp(long parseLong);

	

	String deleteEmp(long parseLong);

	Staff updateEmp(Staff emp, long id);

}
