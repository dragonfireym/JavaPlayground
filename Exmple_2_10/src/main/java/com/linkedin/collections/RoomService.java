package com.linkedin.collections;

import java.util.*;

 
public class RoomService {

	private Collection<Room> inventory;

	public RoomService() {
		this.inventory = new LinkedHashSet<>(); // change to linkedhash.. to make the insertion ordered
		// no with random keys
	}
	
	public boolean hasRoom(Room room) {
		
	// 1. Returns a boolean that indicates if the Room Inventory contains a Room.
		return this.inventory.contains(room);
		
	}
	
	public Room[] asArray() {
		
	// 2. Returns all Rooms as an Array of Rooms in the **order** they were Added.
		Room[] r = new Room[this.inventory.size()];
		Iterator<Room> it = this.inventory.iterator();
		for(int i = 0 ; i<r.length; i++) {
			r[i] = it.next(); 
			System.out.print(r[i]);
		}
		System.out.println("AND");
		System.out.println(this.inventory);
		return r;
		//ANother better answer >>:
		//return this.inventory.toArray(new Room[0]);
	}
	
	public Collection<Room> getByType(String type){

	/*
	   3. Return a new Collection of Rooms where Room#type matches the provided String.
		  The original Room Inventory collection MUST NOT BE MODIFIED.
	*/
		Collection<Room> temp = new HashSet<>();
		for(Room r : this.getInventory()) {
			if(r.getType().equals(type)) {
				temp.add(r);
			}
		}
		
		
		return temp;
		//temp = this.getInventory()
		//temp.removeIf(e -> !e.getType().equals(type)); return temp;
		
//		this.getInventory().retainAll(List.of(this.getInventory().stream().forEach(e->e.getType()==)));
		
	}

	public Collection<Room> getInventory() {
		return new HashSet<>(this.inventory); 
	}

	public void createRoom(String name, String type, int capacity, double price) {
		this.inventory.add(new Room(name, type, capacity, price));
	}

	public void createRooms(Room[] rooms) {
		this.inventory.addAll(Arrays.asList(rooms));
	}

	public void removeRoom(Room room) {
		this.inventory.remove(room);
	}

}
