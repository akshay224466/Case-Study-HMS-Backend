package com.Department;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.Department.Models.Department;
import com.Department.Repository.DepartmentRepo;
import com.Department.Services.DepartmentserviceImpl;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class DepartmentserviceTest {
	
	@Mock
	private DepartmentRepo repo;
	private DepartmentserviceImpl service;
	
	@BeforeEach
	void setUp() {
	this.service = new DepartmentserviceImpl(this.repo);
	}


	//getAlldept
	@Test
	public void getAlldept() throws Exception {
		
		service.getAlldept();
		verify(repo).findAll();
		
	}
	
	
	//getbyId
		@Test
		public void getDepartment() {
		
			service.getDepartment(1L);
			verify(repo).findById(1L);
		
		}
		
		//Delete
		@Test
		public void deleteDepartment() {
			service.deleteDepartment(1L);
			assertThat(service.getDepartment(1L).isEmpty());
		}
		
		
		//Add
		@Test
		public void addDepartment() {
			Department dept=new Department();
			dept.setDepartmentID(1L);
			dept.setDepartmentName("serv");
			dept.setDesc("serv a food to guest");
			dept.setNo_of_Emp(20);
			
			assertNotNull(service.getDepartment(1L));
				
		}
		
		//update
		/*
		 * @Test public void updateDepartment () { Department dept = new
		 * Department(1L,"Cooking","cook a food",25); repo.save(dept);
		 * dept.setNo_of_Emp(20);
		 * when(repo.save(any(Department.class))).thenReturn(dept);
		 * assertEquals(dept,service.updateDepartment(dept)); }
		 */
		
		

}
