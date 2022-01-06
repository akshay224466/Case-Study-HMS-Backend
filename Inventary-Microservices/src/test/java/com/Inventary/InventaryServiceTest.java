package com.Inventary;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.Inventary.Models.Inventary;
import com.Inventary.Repository.InventaryRepo;
import com.Inventary.Service.InventaryserviceImpl;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class InventaryServiceTest {
	@Mock
	private InventaryRepo repo;
	private InventaryserviceImpl service;
	
	
	@BeforeEach
	void setUp() {
	this.service = new InventaryserviceImpl(this.repo);
	}
	
	

	//getAlldept
	@Test
	public void getAllInventary()  {
		
		service.getAllInventary();
		verify(repo).findAll();
		
	}
	
	
	//getbyId
		@Test
		public void getInventary() {
		
			service.getInventary(1L);
			verify(repo).findById(1L);
		
		}
		
		//Delete
		@Test
		public void deleteInventary() {
			service.deleteInventary(1L);
			assertThat(service.deleteInventary(1L).isEmpty());
		}
		
		
		//Add
		@Test
		public void addInventary() {
			Inventary inv=new Inventary();
			inv.setInventaryId(1L);
			inv.setInventaryName("Beds");
			inv.setInventaryStock(100L);
			inv.setInventaryType("Roomservice");
			assertNotNull(service.getInventary(1L));
				
		}
		
		//update
		/*
		 * @Test public void updateInventary () { Inventary inv=new
		 * Inventary(1L,"Beds",100L,"Roomservice"); repo.save(inv);
		 * inv.setInventaryType("cook");;;
		 * when(repo.save(any(Inventary.class))).thenReturn(inv);
		 * assertEquals(inv,service.updateInventary(inv)); }
		 */
		
		

	
	

}
