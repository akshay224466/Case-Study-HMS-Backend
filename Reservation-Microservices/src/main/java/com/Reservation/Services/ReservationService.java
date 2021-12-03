package com.Reservation.Services;




import com.Reservation.Models.Reservation;
import com.Reservation.Models.ReservationList;


public interface ReservationService {

	

	void addReservation(Reservation book);

	Reservation updateReservation(Reservation book);

	String deleteReservation(long parseLong);

	ReservationList getAllReservation();

	

	
}

