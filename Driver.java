package codingchallenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Driver {
	public static void main(String[] args) throws FileNotFoundException {

		String filename = "src/resources/Five9.txt";
		String file2 = "src/resources/assign.json";

		// Scanner scanner = new Scanner(new File(filename));

		ArrayList<Person> list = new ArrayList<>();
		JSONObject json = new JSONObject();
		JSONArray person = new JSONArray();
		JSONObject finalJson = new JSONObject();
		
		
		

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String next = br.readLine();
			String firstName = "";
			String lastName = "";
			String middleName = "";
			String phoneNumber = "";
			String ssn = "";
			String dob = "";

			String[] personInfo;
			int i = 0;

			while (next != null) {
				personInfo = next.split(" ");

//				if (personInfo[5] != null) {

					firstName = personInfo[0];
					lastName = personInfo[1];
					middleName = personInfo[2];
					phoneNumber = personInfo[3];
					ssn = personInfo[4];
					dob = personInfo[5];

//					System.out.println("The firstname is: " + firstName);
//					System.out.println("The lastname is: " + lastName);
//					System.out.println("The middlename is: " + middleName);
//					System.out.println("The phone is: " + phoneNumber);
//					System.out.println("The ssn is: " + ssn);
//					System.out.println("The dob is: " + dob);
//				} 

				list.add(new Person(firstName, lastName, middleName, phoneNumber, ssn, dob));

				next = br.readLine();
				json.put("First Name ", list.get(i).getFirstName());
				json.put("Last Name", list.get(i).getLastName());
				json.put("Middle Name", list.get(i).getMiddleName());
				json.put("Phone Number", list.get(i).getPhoneNumber());
				json.put("SSN", list.get(i).getSsn());
				json.put("DOB", list.get(i).getDob());
				
				
				person.put(json);
				
				finalJson.put("Person", person);
				
				FileWriter file = new FileWriter(file2);
//				file.write(person.toJSONObject(person));
				
				// person is an object, json is an array
				//JSONObject newJson = (JSONObject)finalJson;
				//file.write(newJson.toJSONString());
				
				i++;
				
			
			}
			
			System.out.println("json " + finalJson);
			
			

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.println("The person list is: " + list);
		System.out.println("JSON: " + person);
		

	}

}
