package com.Room.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Room.Models.Room;
import com.Room.Models.RoomList;
import com.Room.Repository.RoomMongodbRepos;



@Service
public class RoomserviceImpl implements Roomservice{
	
	@Autowired
	RoomMongodbRepos  roomMongodbRepo;

	public RoomserviceImpl(RoomMongodbRepos roomMongodbRepos) {
		
		this.roomMongodbRepo=roomMongodbRepos;
		// TODO Auto-generated constructor stub
	}



	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		return roomMongodbRepo.insert(room);
	}

	

	@Override
	public Optional<Room> getRoom(long parseLong) {
		// TODO Auto-generated method stub
		return roomMongodbRepo.findById(parseLong);
	}

	/*
	 * @Override public Room updateRoom(Room room) { // TODO Auto-generated method
	 * stub return roomMongodbRepo.save(room); }
	 */
	@Override
	public Room updateRoom(Room room,long id) {
		room.setRoomId(id);
			return roomMongodbRepo.save(room);
	}

	@Override
	public String deleteRoom(long parseLong) {
		roomMongodbRepo.deleteById(parseLong);
		return "Room Number "+parseLong+" Deleted";
	}

	@Override
	public List<Room> getAllRoom() {
		// TODO Auto-generated method stub
		return roomMongodbRepo.findAll();
	}



	@Override
	public RoomList getRoomAvl() {
		// TODO Auto-generated method stub
		RoomList list=new RoomList();
		list.setAllRoom(roomMongodbRepo.findAvailable());;
		return list;
	}

}
