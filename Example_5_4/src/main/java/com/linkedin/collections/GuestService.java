package com.linkedin.collections;

import java.util.ArrayList;
import java.util.List;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list. 
		 */
		
		List<Guest> favList = new ArrayList<>(100);
		
		guests.stream()
		.filter(g -> g.getPreferredRooms().indexOf(room) == 0)
		.forEach(favList::add);
		// .collect(Collectors.toList() can be used also to collect the resulted list and return it
		return favList; 

	}

	public void checkIn(Guest guest) {
		
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */
		int lastLoyalPosition = 0;
		for (Guest g : checkinList) {
			if(g.isLoyaltyProgramMember()) {
				lastLoyalPosition++;
			}
			else {
				break;
			}
		}
		if(guest.isLoyaltyProgramMember()) {
			this.checkinList.add(lastLoyalPosition, guest);
		}
		else {
			this.checkinList.add(guest);
		}
	
		
	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */ 
		if(!this.checkinList.contains(guest1) || !this.checkinList.contains(guest2)) {
			return;
		}
		// you can get the usage of index of as if they are not = -1 to reduce complexity
		
		int i1 = this.checkinList.indexOf(guest1) , i2 = this.checkinList.indexOf(guest2);
		this.checkinList.add(i2, guest1);
		this.checkinList.add(i1, guest2);
		this.checkinList.remove(i1+1);
		this.checkinList.remove(i2+1);
		
		// use .set to change instantly their position
		


	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
