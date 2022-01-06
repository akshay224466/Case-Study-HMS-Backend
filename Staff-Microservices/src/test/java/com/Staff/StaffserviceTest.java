package com.Staff;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.Staff.Models.Staff;
import com.Staff.Repository.StaffMongodbRepo;

import com.Staff.Service.StaffserviceImpl;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StaffserviceTest {
	
	@Mock
	private StaffMongodbRepo repo;

	private StaffserviceImpl staffImpl;
	
	
	@BeforeEach
	void setUp() {
	this.staffImpl = new StaffserviceImpl(this.repo);
	}
	
	//getAllemp
	@Test
	public void getAllEmployee() {
	
		staffImpl.getAllEmp();
		verify(repo).findAll();
	
	}
	
	//getbyId
	@Test
	public void getEmp() {
	
		staffImpl.getEmp(1L);
		verify(repo).findById(1L);
	
	}
	
	//Delete
	@Test
	public void deleteEmp() {
		staffImpl.deleteEmp(1L);
		assertThat(staffImpl.getEmp(1L).isEmpty());
	}
	
	
	//Add
	@Test
	public void addEmp() {
		Staff staff=new Staff();
		staff.setEmpId(1L);
		staff.setEmpDeptId(1001L);
		staff.setEmpDeptName("Akshay");
		staff.setEmpDeptName("Cooking");
		staff.setEmail("akshay@gmail.com");
		staff.setEmpSalary(25000);
		staffImpl.addEmp(staff);
		assertNotNull(staffImpl.getEmp(1L));
			
	}
	/*
	 * //update
	 * 
	 * @Test public void updateEmp () { Staff staff = new
	 * Staff(1L,1001L,"Akshay","Cooking","akshay@gmail.com",25000);
	 * repo.save(staff); staff.setEmpSalary(20000);
	 * when(repo.save(any(Staff.class))).thenReturn(staff);
	 * assertEquals(staff,staffImpl.updateEmp(staff)); }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}
