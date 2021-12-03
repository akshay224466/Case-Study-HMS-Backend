package com.Reservation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Reservation.Models.Reservation;

import com.Reservation.Repo.ReservationRepo;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepo repos;

	@Override
	public List<Reservation> findAll() {
		return repos.findAll();
	}

	@Override
	public void addReservation(Reservation book) {
		repos.insert(book);
	}

	@Override
	public Object updateReservation(Reservation book) {
	
		return repos.save(book);
	}

	@Override
	public String deleteReservation(long parseLong) {
		repos.deleteById(parseLong);
		return "Reservartion Cancelled";
		
	}

	@Override
	public List<Reservation> getAllReservation() {
		
		return repos.findAll();
	}

		
	}
