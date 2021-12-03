package com.Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Manager.Models.Inventary;
import com.Manager.Models.InventaryList;

@RestController
@RequestMapping("/manager/inventary")
public class ManagerInventaryController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getAllInv")
	public InventaryList getInventary() 
	{
		return restTemplate.getForObject("http://Inventary-Microservice/Inventary/getAllInv/", InventaryList.class);
	}
	
	@GetMapping("/getByInv/{id}")
	public Inventary getInventary(@PathVariable("id") String id) 
	{
		return restTemplate.getForObject("http://Inventary-Microservice/Inventary/getByInv/"+id, Inventary.class);
	}
	
	
	@PostMapping("/addInv")
	public Inventary addInventary(@RequestBody Inventary inv) {
		return restTemplate.postForObject("http://Inventary-Microservice/Inventary/addInv/", inv, Inventary.class);
	}
	
	
	@PutMapping("/updateInv")
	public Inventary updateInventary(@RequestBody Inventary inv) {
	 restTemplate.put("http://Inventary-Microservice/Inventary/updateInv/",inv, Inventary.class);
	 return inv;
	}
	
	@DeleteMapping("/deleteByInv/{id}")
	public String deleteInventary(@PathVariable("id") String id) {
		 restTemplate.delete("http://Inventary-Microservice/Inventary/deleteByInv/"+id);
		return "Deleted room "+id;
	}
	
	
	

}
