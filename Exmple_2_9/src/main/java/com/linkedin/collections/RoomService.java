package com.linkedin.collections;

import java.util.*;

public class RoomService {

	// 1. Declare a Collection to store Room Inventory
	//private Collection<Room> rooms = new ArrayList<Room>(); // not the right practice , assigning
	//or initializing should be done in constructors and HashSet is good to make rooms unique
	private Collection<Room> rooms;


	public RoomService() {
		
	// 2. Initialize Collection and assign it to the Room Inventory
//		rooms.add(new Room("Cambridge", "Premiere Room", 4, 175.00));
//		rooms.add(new Room("Manchester", "Suite", 5, 250.00));
//		rooms.add(new Room("Piccadilly", "Guest Room", 3, 125.00));
//		rooms.add(new Room("Oxford", "Suite", 5, 225.0));
//		rooms.add(new Room("Victoria", "Suite", 5, 225.00));
		//WRONG this is adding not initalziing , now room is empty
		rooms = new HashSet<>();
		
	
	}

	public Collection<Room> getInventory(){
		
	// 3. Return the Room Inventory
		
		//return this.rooms; << this is unsafe as this will lead to change in the service so 
		//create copy better like this :
		return new HashSet<Room>(this.rooms);
	}
	
	public void createRoom(String name, String type, int capacity, double rate) {
	
	// 4. Add a new Room to the Room Inventory using the provided parameters
		this.rooms.add(new Room(name, type, capacity, rate));

	}

	public void createRooms(Room[] rooms) {
	
	// 5. Add the Rooms provided in the Array to the Room Inventory
		this.rooms.addAll(List.of(rooms));
		// this also works : this.rooms.addAll(Arrays.asList(rooms));

	}
	
	public void removeRoom(Room room) {
		
	// 6. Remove the provided Room from the Room Inventory
	
		this.rooms.remove(room);

	}

}
