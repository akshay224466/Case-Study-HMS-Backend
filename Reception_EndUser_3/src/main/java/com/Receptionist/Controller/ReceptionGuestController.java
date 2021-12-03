package com.Receptionist.Controller;



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


import com.Receptionist.Models.Guest;
import com.Receptionist.Models.GuestList;



@RestController
@RequestMapping("/reception/guest")
public class ReceptionGuestController {
	
	@Autowired
	RestTemplate rest;
	
	@GetMapping("/message")
	public String test() {
		return "Hello";
	}
	
	@PostMapping("/addGuest")
	public Guest addGuest(@RequestBody Guest guest)
	{
		return rest.postForObject("http://Guest-Microservice/Guest/addGuest/", guest, Guest.class);
	}
	
	@PutMapping("/updateGuest")
	public Guest updateGuest(@RequestBody Guest guest)
	{
		rest.put("http://Guest-Microservice/Guest/updateGuest/",guest, Guest.class);
		return guest;
	}
	
	@DeleteMapping("/deleteGuest/{id}")
	public String deleteGuestById(@PathVariable("id") String id)
	{
		rest.delete("http://Guest-Microservice/Guest/deleteGuest/"+id);
		return "Deleted room "+id;
	}
	
	@GetMapping("getGuest/{id}")
	public Guest getGuest(@PathVariable String id)
	{
		return rest.getForObject("http://Guest-Microservice/Guest/getGuest/"+id, Guest.class);
	}
	
	@GetMapping("getAllGuest")
	public GuestList getAllGuest()
	{
		return rest.getForObject("http://Guest-Microservice/Guest/getAllGuest/", GuestList.class);
	}
	

}
