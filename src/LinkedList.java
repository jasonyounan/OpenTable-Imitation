// Name: Jason Younan
// Description: The LinkedList class has an instance variable first that marks the head of the list, 
// An instance variable size that serves as a counter for the current total number of 
// Reservations in the wait list, and a constructor that sets first to null .

public class LinkedList {
	Table first;
	int size;

	public LinkedList() {
		first = null;
		size = 0;
	}

	public void add(int numberOfGuests, String name) {
		Table newGuest = new Table(numberOfGuests, name);
		if (first == null) {
			first = newGuest;
		} else {
			Table pointer = first;
			while (pointer.next != null)
				pointer = pointer.next;
			pointer.next = newGuest;
		}
		size++;
	}

	// Remove first node
	public Table removeFirst() {
		// If size equals 0
		if (size == 0) {
			return new Table.EmptyTable(); // Return empty table
		}

		Table returnedTable = first; // Set returnedTable to this node
		first = first.next; // Set node to the next node
		size--; // Decrement size
		return returnedTable; // Return returnedTable
	}

	// Remove last node
	public Table removeLast() {
		Table returnedTable = new Table.EmptyTable();
		;

		// If size equals 0
		if (size == 0) {
			return returnedTable; // Return empty table
		} else if (size == 1) {
			// If size equals 1
			returnedTable = first; // Set returnedTable to this node
			first = null; // Set this node to null
			size--; // Decrement size
			return returnedTable; // Return returnedTable
		}

		Table pointer = first; // Node pointer

		// While next node is not null
		while (pointer.next != null) {
			// If next next node does not exist, this is the last node
			if (pointer.next.next == null) {
				returnedTable = pointer.next; // Set returnedTable to this node
				pointer.next = null; // Remove next node
			}
			pointer = pointer.next; // Go to the next node
		}

		size--; // Decrement size
		return returnedTable;
	}

	// Remove guest by name
	// Only used if guest is not on first node
	public Table removeMiddle(String middle) {
		Table returnedTable = new Table.EmptyTable();

		// If size equals 0
		if (size == 0) {
			return returnedTable; // Return empty table
		} else if (first.name.equals(middle)) {
			// If the first node's name equals param name, remove first node
			return removeFirst();
		}

		Table pointer = first; // Node pointer

		// While next node is not null
		while (pointer.next != null) {
			// If the next node's name equals parameter name
			if (pointer.next.name.equals(middle)) {
				returnedTable = pointer.next; // Set the next node as the return value

				// If next next node exists
				if (pointer.next.next != null) {
					pointer.next = pointer.next.next; // Set next to next next node
				} else {
					pointer.next = null; // Set next to null
				}
				size--; // Decrement size
				return returnedTable; // Return returnedTable
			}
			pointer = pointer.next; // Go to the next node
		}

		return returnedTable;
	}

	// Remove guest by name
	public Table removeGuest(String guest) {
		// If size equals 0
		if (size == 0) {
			return new Table.EmptyTable(); // Return empty table
		} else if (size == 1 && first.name.equals(guest)) {
			// If size equals 1 and first node's name equals guest name parameter, remove
			// first node
			return removeFirst();
		}

		// Search for node and remove by name
		return removeMiddle(guest);
	}

	// Get guest node position
	public int getPosition(String guest) {
		int position = -1; // Position of guest

		// If size equals 0
		if (size == 0) {
			return position; // Return -1
		}

		Table pointer = first; // Node pointer
		int counter = 0; // Temporary position of guest

		// While current node is not null
		while (pointer != null) {
			// If current node's name is the same as parameter name
			if (pointer.name.equals(guest)) {
				position = counter; // Set the position to the current counter
			}
			// If a position has not already been set, add to the counter
			if (position == -1) {
				counter++; // Add 1 to counter
			}
			pointer = pointer.next; // Go to the next node
		}

		return position;
	}

	// Get number of parties with parameter size
	public int getNumberOfParties(int size) {
		int numberOfParties = 0; // Total number of parties
		Table pointer = first; // Node pointer

		// If size equals 0, return empty table
		if (size == 0) {
			return 0;
		}

		// While current node is not null
		while (pointer != null) {
			// If current node's guest size is the same as parameter guest size
			if (pointer.guests == size) {
				numberOfParties++; // Add 1 to number of parties
			}
			pointer = pointer.next; // Go to the next node
		}

		// Return number of parties
		return numberOfParties;
	}

	// List all reservations
	public String listReservations() {
		// If size equals 0, return empty table
		if (size == 0) {
			return "No reservations in queue at this time.\n";
		}

		int numberOfReservations = 0; // Will count total number of reservations
		String combinedString = ""; // Combined string, will hold all reservation strings
		Table pointer = first; // Node pointer

		// While current node is not null
		while (pointer != null) {
			numberOfReservations++; // Add to number of reservations
			combinedString += pointer.toString(); // Add to combined string
			pointer = pointer.next; // Go to the next node
		}

		// Return combined string
		return combinedString + "\nTotal reservations: " + numberOfReservations + ".\n";
	}
}