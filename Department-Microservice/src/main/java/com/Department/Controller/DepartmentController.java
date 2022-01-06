package com.Department.Controller;



import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Department.Models.Department;
import com.Department.Models.DepartmentList;
import com.Department.Services.Departmentservice;

// Class Work as a Controller.  

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	
	
	@Autowired //Autowire the DepartmentService class  
	private Departmentservice service;

	@GetMapping("/hello")
	public String test() {
		return "Hello I am From Department MicroService";
	}
	
	//creating post mapping that post the department detail in the database  
	@PostMapping("/add")
	public Department addDept(@RequestBody Department dept) {
		return this.service.addDepartment(dept);
	}
	
	//creating a get mapping that retrieves all the department detail from the database   
	@GetMapping("/findAll")
	public DepartmentList getDepartment(){
		DepartmentList departmentList = new DepartmentList();
		departmentList.setAlldept(this.service.getAlldept());
	return  departmentList;
	
	}
	
	//creating a get mapping that retrieves the detail of a specific department
	@GetMapping("/findById/{id}")
	public Optional<Department> getDepartment(@PathVariable("id") String id){
		
		return this.service.getDepartment(Long.parseLong(id));
	}
	
	//creating put mapping that updates the department detail   
//	@PutMapping("/update/{id}")
//	public Department updateDepartment(@RequestBody Department dept){
//		return this.service.updateDepartment(dept);
//	}
	
	
	
	@PutMapping("/update/{id}")
	public void updateDepartment(@RequestBody Department dept, @PathVariable long id) {
	
     service.updateDepartment(dept,id);
	}


	
	
	
	//creating a delete mapping that deletes a specified department
	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") String id) 
	{
		return this.service.deleteDepartment(Long.parseLong(id));
	}
	
	

}
