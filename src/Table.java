// Name: Jason Younan
// Description: Represents a reservation on the waitlist and has three instance variables:
// The guest name for the reservation (name), the number of guests in the party (guests), 
// And a reference to the next Table on the waitlist (next).

public class Table {
	String name;
	int guests;
	Table next;

	public Table(int n, String name) {
		this.name = name;
		guests = n;
		next = null;
	}

	public String toString() {
		return "\nReservation for " + name + ": party of " + guests + ".\n";
	}

	public static class EmptyTable extends Table {
		public EmptyTable() {
			super(-1, "");
		}
	}
}