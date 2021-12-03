package com.Reservation.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.Reservation.Models.Reservation;
import com.Reservation.Models.ReservationList;
import com.Reservation.Services.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;
	
	

	@GetMapping("/hello")
	public String helloMsgs() {
		return "Reservation Microservice";
	}
	
	@PostMapping("/addReservation")
	public void addReservation(@RequestBody Reservation book) 
	{
		 this.service.addReservation(book); 
	}


	@PutMapping("/updateReservation")
	public Reservation updateReservation(@RequestBody Reservation book)
	{
		return this.service.updateReservation(book); 
	}
	

	@DeleteMapping("/cancelReservation/{id}")
	public String deleteReservation(@PathVariable("id") String id) 
	{
		return this.service.deleteReservation(Long.parseLong(id));
	}
	

	@GetMapping("/ShowAllReservations")
	public ReservationList getAllReservation()
	{
		return this.service.getAllReservation();
	}
	
}