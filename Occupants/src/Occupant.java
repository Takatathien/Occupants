/* 
 * Create a Class called Occupant.
 * Contains information such as:
 * First Name, Last Name, Street, City, State and Age of occupant.
 *
 * Implements methods to return, compare, and print those information from Occupant. 
 */

// Occupant needs to implement Comparable for future comparison.
public class Occupant implements Comparable<Occupant>{
	// private Attributes of Occupant. No need to be modifiable from OccupantMain.
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private int age;
	
	// Constructor for Occupant.
	public Occupant (String firstName, String lastName, String street, String city, String state, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.age = age;
	}
	
	// Return the first name of Occupant.
	public String getFirstName() {
		return firstName;
	}
	
	// Return the last name of Occupant.
	public String getLastName() {
		return lastName;
	}
	
	// Return the street address of Occupant.
	public String getStreet() {
		return street;
	}
	
	// Return the city address of Occupant.
	public String getCity() {
		return city;
	}
	
	// return the state address of Occupant.
	public String getState() {
		return state;
	}
	
	// Return the age of Occupant.
	public int getAge() {
		return age;
	}
	
	// Return the full address of Occupant in the form of Street, City, State in lower case.
	public String getAddress() {
		return street.toLowerCase() + ", " + city.toLowerCase() + ", " + state.toLowerCase();
	}

	@Override
	// Return all information of Occupant in the form of fist name, last name, street, city, state, age.
	public String toString() {
		return firstName + ", " + lastName + ", " + street + ", " + city + ", " + state + ", " + age;
	}
	
	@Override
	// Compare Occupants' last names.
	// If last names are the same, compare first names.
	// Return 0 if the same
	public int compareTo(Occupant o) {
		// If the last names are the same, check first names.
		if(this.lastName.compareToIgnoreCase(o.getLastName())== 0) {
			return this.firstName.compareToIgnoreCase(o.getFirstName());
			
		}
		// If last names are different. return non-zero.
		return this.lastName.compareToIgnoreCase(o.getLastName());
	}
}
