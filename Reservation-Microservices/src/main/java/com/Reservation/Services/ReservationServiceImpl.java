package com.Reservation.Services;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Reservation.Models.Reservation;
import com.Reservation.Models.Room;
import com.Reservation.Repo.ReservationRepo;


//defining the business logic
@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepo repos;
	
	//Autowiring the Rest Template
	@Autowired
	private RestTemplate restTmp;

	//inserting a specific record 
	@Override
	public String addReservation(Reservation book) {
			Room room= restTmp.getForObject("http://Room-Microservice/rooms/findById/"+book.getRoomId(), Room.class);
			if(room.getRoomAvl()) {
			
				repos.insert(book);
				room.setRoomAvl(false);
				restTmp.put("http://Room-Microservice/rooms/update/"+room.getRoomId(), room);
				return "Room Number "+room.getRoomId()+" booked for Guest : ";
			}
			else {
				return "Room Already Booked";
			}
		
		
	}

	//saving a specific record by using the method save() of  MongoRepository  
	@Override
	public Reservation updateReservation(Reservation book,long id) {
		book.setBookingId(id);
			return repos.save(book);
	}
	

	
	
	
	//deleting a specific record by using the method deleteById() of MongoRepository  
	@Override
	public String deleteReservation(long parseLong) {
		// TODO Auto-generated method stub
	    repos.deleteById(parseLong);
		return "Deleted employee with ID :" + parseLong;
	}

	//getting all Reservations record by using the method findaAll() of MongoRepository  
	@Override
	public List<Reservation> getResList() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	//getting a specific record by using the method findById() of  MongoRepository  
	@Override
	public Optional<Reservation> getReservation(long parseLong) {
		// TODO Auto-generated method stub
		return repos.findById(parseLong);
	}

	

		
	}
