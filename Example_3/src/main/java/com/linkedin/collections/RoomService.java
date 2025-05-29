package com.linkedin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RoomService {

	private Collection<Room> inventory;

	public RoomService() {
		this.inventory = new LinkedHashSet<>();
	}
	
	public void applyDiscount(final double discount) {
		
		//Reduces the rate of each room by the provided discount
		System.out.println("before:" + this.inventory);
		this.inventory.stream().forEach(r -> r.setRate(r.getRate() - discount*r.getRate()));
		System.out.println("after:" + this.inventory);
	}

	public Collection<Room> getRoomsByCapacity(final int requiredCapacity) {
		
		//Returns a new collection of rooms that meet or exceed the provided capacity
		Collection<Room> newC = new HashSet<>();
		this.inventory.stream()
				.filter(r -> r.getCapacity()>= requiredCapacity )
				.forEach(r -> newC.add(r));
	
		return newC;
		
	}
	
	public Collection<Room> getRoomByRateAndType(final double rate, final String type){
	
		//Returns a new collection of rooms with a rate below the provided rate and that match the provided type
		Collection<Room> newC = new HashSet<>();
		this.inventory.stream()
				.filter(r -> (r.getRate()< rate))
				.filter(r -> (r.getType().equals(type)))
				.forEach(r -> newC.add(r));
		System.out.println("here:" + newC);
		return newC;
//		return this.inventory.stream()
//				.filter(r -> (r.getRate()< rate))
//				.filter(r -> (r.getType().equals(type)))
//				.collect(Collectors.toList());
		//the above collect to list instantly to return it without instantiated if wanted

		
	}
	
	public boolean hasRoom(Room room) {
		
		return this.inventory.contains(room); 
	}
	
	public Room[] asArray() {
		
		return this.inventory.toArray(new Room[0]);
	}
	
	public Collection<Room> getByType(String type){

		Collection<Room> copy = new HashSet<>(this.inventory);
		copy.removeIf(r -> !r.getType().equals(type));
		return copy;
		
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
