package com.Reservation.Services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Reservation.Models.Reservation;
import com.Reservation.Repo.ReservationRepo;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepo repos;

	@Override
	public Reservation addReservation(Reservation book) {
		return repos.insert(book);
		
		
	}

	@Override
	public Reservation updateReservation(Reservation book) {
		// TODO Auto-generated method stub
		return repos.save(book);
	}

	@Override
	public String deleteReservation(long parseLong) {
		// TODO Auto-generated method stub
	    repos.deleteById(parseLong);
		return "Deleted employee with ID :" + parseLong;
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
