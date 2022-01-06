package com.Department.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Department.Models.Department;
import com.Department.Repository.DepartmentRepo;

@Service
public class DepartmentserviceImpl implements Departmentservice {

	@Autowired
	private DepartmentRepo repo;
	
	
	 

	public DepartmentserviceImpl(DepartmentRepo repo2) {
		this.repo=repo2;
	}

	//inserting a specific record 
	@Override
	public Department addDepartment(Department dept) {
		return repo.insert(dept);
	}

	//deleting a specific record by using the method deleteById() of MongoRepository  
	@Override
	public String deleteDepartment(long id) {
		repo.deleteById(id);
		return "Department Deleted";
	}

	//saving a specific record by using the method save() of  MongoRepository  
	@Override
	public Department updateDepartment(Department dept,long id) {
		dept.setDepartmentID(id);
			return repo.save(dept);
	}

	//getting a specific record by using the method findById() of  MongoRepository  
	@Override
	public Optional<Department> getDepartment(long id) {
		return repo.findById(id);
	}

	//getting all departments record by using the method findaAll() of MongoRepository  
	@Override
	public List<Department> getAlldept() {
		return repo.findAll();
	}
	
}

	
	
	
	

