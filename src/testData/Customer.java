package testData;

public class Customer {
	
	private static String firstName;
	private static String lastName;
	private static String email;
	private static String address;
	private static String city;
	private static String country;
	private static String phone;
	
	
	public Customer(String role){
		if ( role == "validCustomer") {
			validCustomer();
		} else if (role == "invalidUser"){
			invalidCustomer();
		}
	}
	
	private static void validCustomer(){
		firstName = "Bernd";
		lastName = "Wissmeier";
		email = "no@no.com";
		address = "35, Marconi House, Walker Road";
		city = "Newcastle";
		country = "United Kingdom";
		phone = "123456";
		
	}
	private static void invalidCustomer(){

	}
	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getEmail(){
		return email;
	}
	public String getAddress(){
		return address;
	}
	public String getCity(){
		return city;
	}
	public String getCountry(){
		return country;
	}
	public String getPhone(){
		return phone;
	}

		
	
}
