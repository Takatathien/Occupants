import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Create a class called OccupantMain.
 * The class inputs a text file containing the details of the occupants.
 * Scans each line of the text file and put them into an object of Occupant.
 * Then puts all of the Occupant into a HashMap.
 * 
 * The class then prints out the address then the number of occupants.
 * Then prints out the first name, last name, addresses, and ages of each occupant older than 18.
 * The occupants are sorted by last name, then first name.
 */
public class OccupantMain {
	public static void main(String[] args) throws FileNotFoundException {
		// Tests for Occupant objects.
		/*
		Occupant test1 = new Occupant("Dave","Smith","123 main st.","seattle","wa",43);
		Occupant test2 = new Occupant("Alice","Smith","123 Main St.","Seattle","WA",45);
		Occupant test3 = new Occupant("Bob","Williams","234 2nd Ave.","Tacoma","WA",26);
		Occupant test4 = new Occupant("Dave","Smith","123 main st.","seattle","wa",43);
		
		System.out.println(test1.getAddress());
		System.out.println(test2.toString());
		System.out.println(test1.compareTo(test2));
		System.out.println(test1.compareTo(test3));
		System.out.println(test1.compareTo(test4));
		*/
		
		// Create a HashMap to store all Occupant.
		// The key is the address and the value is List of the Occupant shared that address.
		HashMap<String, List<Occupant>> occupantMap = new HashMap<>();
		
		// Create a object of Scanner to input the text file.
		Scanner input = new Scanner(new File("List of Occupants.txt"));
		
		while (input.hasNextLine()) {
			String people = input.nextLine();
			
			// Replaces the "" with empty space.
			people = people.replace("\"", " ");
			// Tests for people.
		    // System.out.println(people);
		    
			String[] occupantArray = people.split(" ,");
			
			// Tests for occupantArray.
			/*
			for (int i = 0; i < occupantArray.length; i++) {
				System.out.println(i + occupantArray[i]);
			}
			*/
			
			String firstName = occupantArray[0].trim();
			String lastName = occupantArray[1].trim();
			// replaces the , and . in some street names.
			String street = occupantArray[2].replace(",", "").trim();
			street = street.replace(".", "").trim();
			String city = occupantArray[3].trim();
			String state = occupantArray[4].trim();
			int age = Integer.parseInt(occupantArray[5].trim());
			
			Occupant occupant = new Occupant(firstName, lastName, street, city, state, age);
			// Tests for occupant.
			// System.out.println(occupant.toString());	
			
			// Check if occupantMap already contains the address.
			if (occupantMap.containsKey(occupant.getAddress())) {
				// If yes, adds the new occupant to the list of occupant with this address key.
				occupantMap.get(occupant.getAddress()).add(occupant);
			} else {
				// If no, creates a new list of occupant, adds the occupant into the list, adds the list into the map of occupant with the new address key. 
				List<Occupant> occupantList = new ArrayList<Occupant>();
			    occupantList.add(occupant);
			    occupantMap.put(occupant.getAddress(), occupantList);
			}
		}
		// Tests for occupantMap.
		// System.out.println(occupantMap);

		// Iterates through the entire occupantMap.
		for(Map.Entry<String, List<Occupant>> entry : occupantMap.entrySet()) {
			// Prints out the address and number of occupants at this address.
			System.out.println(entry.getKey() + ". Number of occupants: " + entry.getValue().size());
			
			List<Occupant> occupantList = entry.getValue();
			// Sorts the list in alphabetical order.
			Collections.sort(occupantList);
			
			// Keep tracks of whether there are occupant over 18 years old.
			boolean overAge = false;
			
			// Iterates through the entire occupantList.
			for (int i = 0; i < occupantList.size(); i++) {
				// If there are occupants over 18.
				if (occupantList.get(i).getAge() > 18) {
					overAge = true;
					System.out.println(occupantList.get(i));
				}
			}
			
			// If there are no occupants over 18.
			if (!overAge) {
				System.out.println ("There are no occupants over 18 years old.");
			}
		}
	}
}
