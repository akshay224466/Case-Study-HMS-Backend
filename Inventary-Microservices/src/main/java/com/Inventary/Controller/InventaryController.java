package com.Inventary.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventary.Models.Inventary;
import com.Inventary.Models.InventaryList;
import com.Inventary.Service.Inventaryservice;






@RestController
@RequestMapping("/Inventary")
public class InventaryController {
	
	@Autowired
	Inventaryservice inventaryService;
	
	
	@PostMapping("/addInv")
	public Inventary addInventary(@RequestBody Inventary inv)
	{
		return this.inventaryService.addInventary(inv);
	}
	@GetMapping("/getAllInv")
	public InventaryList getAllInventary(){
		InventaryList list=new InventaryList();
		list.setAllstaff(this.inventaryService.getAllInventary());
		return list;
	}
	
	@GetMapping("/getByInv/{id}")
	public Optional<Inventary> getInventary(@PathVariable("id") String id)
	{
		return this.inventaryService.getInventary(Long.parseLong(id));
	}
	
	@PutMapping("/updateInv")
	public Inventary updateInventary(@RequestBody Inventary inv)
	{
		return this.inventaryService.updateInventary(inv);
	}
	
	@DeleteMapping("/deleteByInv/{id}")
	public String deleteInventary(@PathVariable("id") String id)
	{
		return this.inventaryService.deleteInventary(Long.parseLong(id));
	}
	
	
	
	
	

}
