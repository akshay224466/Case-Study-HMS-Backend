package com.Reservation.Controller;




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



import com.Reservation.Models.Reservation;
import com.Reservation.Models.ReservationList;
import com.Reservation.Services.ReservationService;

//mark class as Controller  

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/reservation")
public class ReservationController {

	//autowire the DepartmentService class  
	@Autowired
	private ReservationService service;
	
	

	@GetMapping("/hello")
	public String helloMsgs() {
		return "Reservation Microservice";
	}
	
	//creating post mapping that post the Reservation detail in the database  
	@PostMapping("/addReservation")
	public String addReservation(@RequestBody Reservation book) 
	{
		return this.service.addReservation(book);
		
	}


	
	//creating put mapping that updates the Reservation detail 
		@PutMapping("/update/{id}")
		public void Reservation(@RequestBody Reservation  book, @PathVariable long id) {
		
	     service.updateReservation(book,id);
		}

	
	
	
	
	//creating a delete mapping that deletes a specified Reservation
	@DeleteMapping("/cancelReservation/{id}")
	public String deleteReservation(@PathVariable("id") String id) 
	{
		return this.service.deleteReservation(Long.parseLong(id));
	}
	
	//creating a get mapping that retrieves all the Reservations detail from the database 
	@GetMapping("/ShowAllReservations")
	public ReservationList getResList()
	{
		ReservationList list=new ReservationList();
		list.setResList(this.service.getResList());
		return list;
	}
	
	//creating a get mapping that retrieves the detail of a specific Reservation
	@GetMapping("/getByreservation/{id}")
	public Optional<Reservation> getReservation(@PathVariable("id") String id)
	{
		return this.service.getReservation(Long.parseLong(id));
	}
	
}
