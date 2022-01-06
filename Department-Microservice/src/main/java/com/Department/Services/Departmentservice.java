package com.Department.Services;



import java.util.List;
import java.util.Optional;



import com.Department.Models.Department;







public interface Departmentservice {


	Department addDepartment(Department dept);

	List<Department> getAlldept();

	Optional<Department> getDepartment(long parseLong);

	Department updateDepartment(Department dept,long id);

	String deleteDepartment(long parseLong);

	

	
	
	

	
	
	

}
