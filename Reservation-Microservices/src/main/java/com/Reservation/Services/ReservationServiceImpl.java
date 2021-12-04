package com.Reservation.Services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Reservation.Models.Reservation;
import com.Reservation.Models.Room;
import com.Reservation.Repo.ReservationRepo;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepo repos;
	@Autowired
	private RestTemplate restTmp;

	@Override
	public String addReservation(Reservation book) {
		Room room= restTmp.getForObject("http://Room-Microservice/rooms/findById/"+book.getRoomId(), Room.class);
		if(room.getRoomAvl()) {
			repos.insert(book);
			room.setRoomAvl(false);
			restTmp.put("http://Room-Microservice/rooms/updateRoom", room);
			return "Room Number "+room.getRoomId()+" booked for Guest : ";
		}
		else {
			return "Room Already Booked";
		}
		
		
	}

	@Override
	public Reservation updateReservation(Reservation book) {
		// TODO Auto-generated method stub
		return repos.save(book);
	}

	@Override
	public String deleteReservation(long parseLong) {
		// TODO Auto-generated method stub
		Optional<Reservation> res=repos.findById(parseLong);
		Reservation res1=res.get();
		Room room= restTmp.getForObject("http://Room-Microservice/rooms/delete/"+res1.getRoomId(), Room.class);
		room.setRoomAvl(true);
		restTmp.put("http://Room-Microservice/rooms/updateRoom", room);
		repos.deleteById(parseLong);
		return "Deleted Reservation ID : "+parseLong;
	}

	@Override
	public List<Reservation> getResList() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public Optional<Reservation> getReservation(long parseLong) {
		// TODO Auto-generated method stub
		return repos.findById(parseLong);
	}

	

		
	}
