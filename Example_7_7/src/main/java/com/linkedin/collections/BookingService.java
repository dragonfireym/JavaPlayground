package com.linkedin.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BookingService {

	private Map<Room, Guest> bookings = new HashMap<>();

	public boolean book(Room room, Guest guest) {

		/*
		 * 1. The provided Guest is placed in the bookings Map and
		 * associated with the provided room, only if no other guest
		 * is associated with the room.
		 * 
		 * Returns a boolean that indicates if the Guest was
		 * successfully placed in the room.
		 */
		
		if(this.bookings.get(room) != null) {
			return false;
		}
		this.bookings.put(room, guest);
		return true;
		
	}

	public double totalRevenue() {
		
		/*
		 * 2. Returns a double that totals the rate of each Room booked
		 * in the bookings Map.
		 */
		double total = this.bookings.entrySet().stream()
		.mapToDouble(e-> e.getKey().getRate())
		.sum();
		// it is better to just use keySet() then access keys instantly instead of getting 
		//entry then getting key
		return total;
	}
	
	public Map<Room, Guest> getBookings() {
		return bookings;
	}
}
