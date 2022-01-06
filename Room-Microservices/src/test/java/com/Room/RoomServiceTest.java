package com.Room;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.Room.Models.Room;
import com.Room.Repository.RoomMongodbRepos;
import com.Room.Service.RoomserviceImpl;



@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class RoomServiceTest {



	@Mock
	private RoomMongodbRepos roomMongodbRepo;
	private RoomserviceImpl roomServiceImpl;
	
	
	
	@BeforeEach
	void setUp() {
	this.roomServiceImpl = new RoomserviceImpl(this.roomMongodbRepo);
	}


	
	@Test
	public void getAllRoom()  {
		
		roomServiceImpl.getAllRoom();
		verify(roomMongodbRepo).findAll();
		
	}
	@Test
	public void getRoom()  {
		
		roomServiceImpl.getRoom(200L);
		verify(roomMongodbRepo).findById(200L);
		
	}



	@Test
	public void addRoom() {
		Room room=new Room();
		room.setRoomId(201L);
		room.setRoomCharges(5000);
		room.setRoomDesc("Two+Two");
		room.setRoomType("Ac");
		room.setRoomAvl(true);
		
		roomServiceImpl.addRoom(room);
		assertNotNull(roomServiceImpl.getRoom(201L));
			
	}

	@Test
	public void deleteRoom() {
		roomServiceImpl.deleteRoom(101L);
		assertThat(roomServiceImpl.getRoom(101L).isEmpty());
	}


//	@Test
//	void testUpdateRoom() {
//	
//		  Room room = new Room (101L,1200,"Ac","Ac Room",false);
//		  roomMongodbRepo.save(room);
//		  room.setRoomCharges(1000);
//		  when( roomMongodbRepo.save(any(Room.class))).thenReturn(room);
//		   assertEquals(room,roomServiceImpl.updateRoom(room));
//	}
	@Test
	void testGetRoomAvl() {
		roomServiceImpl.getRoomAvl();
	
		verify(roomMongodbRepo).findAvailable();
	}



}
