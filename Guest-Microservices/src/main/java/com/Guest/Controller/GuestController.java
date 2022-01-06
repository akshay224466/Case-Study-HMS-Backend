package com.Guest.Controller;





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

import com.Guest.Models.Guest;
import com.Guest.Models.GuestList;
import com.Guest.Service.Guestservice;




@RestController
@RequestMapping("/Guest")
public class GuestController {
	
	@Autowired
	Guestservice guestService;

	@GetMapping("/message")
	public String test() {
		return "Hello I am From Microservice3";
	}
	
	@PostMapping("/addGuest")
	public Guest addGuest(@RequestBody Guest guest)
	{
		return this.guestService.addGuest(guest);
	}
	
	/*
	 * @PutMapping("/updateGuest") public Guest updateGuest(@RequestBody Guest
	 * guest) { return this.guestService.updateGuest(guest); }
	 */
	@PutMapping("/updateGuest/{id}")
	public void updateGuest(@RequestBody Guest guest, @PathVariable int id) {
	
     guestService.updateGuest(guest,id);
	}

	
	@DeleteMapping("/deleteGuest/{id}")
	public String deleteGuestById(@PathVariable("id") String id)
	{
		return this.guestService.deleteGuest(Integer.parseInt(id));
	}
	
	@GetMapping("getGuest/{id}")
	public Optional<Guest> getGuest(@PathVariable String id)
	{
		return this.guestService.getGuest(Integer.parseInt(id));
	}
	
	@GetMapping("getAllGuest")
	public GuestList getAllGuest()
	{
		GuestList list=new GuestList();
		list.setAllGuest(this.guestService.getAllGuest());
		return list;
	}

	
}