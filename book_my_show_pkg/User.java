package book_my_show_pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
	String name, email,password, phone;
	
	User(String name,String email,String password,String phone){
		this.name=name;
		this.email=email;
		this.password=password;
		this.phone=phone;
	}
	
	static List<User>users=new ArrayList<User>();
	
	public static void registerUser() {
		  Scanner sc=new Scanner(System.in);
		  String name = "";
	        for (int attempts = 0; attempts < 3; attempts++) {
	            System.out.println("Enter your name (firstname lastname): ");
	            name = sc.nextLine();
	            if (name.split(" ").length >= 2) {
	                break;
	            }
	            System.out.println("Invalid name. Please enter your full name [firstname + lastname].");
	            if (attempts == 2) {
	                System.out.println("Maximum attempts reached. Registration failed.");
	                return;
	            }
	        }

	        String email = "";
	        for (int attempts = 0; attempts < 3; attempts++) {
	            System.out.println("Enter your email: ");
	            email = sc.nextLine();
	            if (email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,7}$")) {
	                break;
	            }
	            System.out.println("Invalid email address. Please try again.");
	            if (attempts == 2) {
	                System.out.println("Maximum attempts reached. Registration failed.");
	                return;
	            }
	        }

	        String password = "";
	        for (int attempts = 0; attempts < 3; attempts++) {
	            System.out.println("Enter password (at least 8 characters, include an uppercase letter, a number, and a special character): ");
	            password = sc.next();
	            if (password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")) {
	                break;
	            }
	            System.out.println("Invalid password. Please try again.");
	            if (attempts == 2) {
	                System.out.println("Maximum attempts reached. Registration failed.");
	                return;
	            }
	        }

	        sc.nextLine(); // Consume leftover newline

	        String phone = "";
	        for (int attempts = 0; attempts < 3; attempts++) {
	            System.out.println("Enter your phone number (10 digits): ");
	            phone = sc.nextLine();
	            
	            if (phone.matches("\\d{10}")) {
	                break;
	            }
	            System.out.println("Invalid phone number. Please try again.");
	            if (attempts == 2) {
	                System.out.println("Maximum attempts reached. Registration failed.");
	                return;
	            }
	        }
		
		User newuser=new User(name,email,password,phone);
		users.add(newuser);
		System.out.println("User added successfully!");
	}
	
	public void displayUser() {
		System.out.println("Name: " + name + ", Email: " + email + ", Phone: " + phone);
	}
	
	public static void loginUser() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter email: ");
		String email=scan.nextLine();
		
		System.out.println("Enter password: ");
		String password=scan.nextLine();
		
		boolean userfound=false;
		for(User user:users) {
			if(user.email.equals(email) && user.password.equals(password)) {
				System.out.println("Login successful...! Welcome "+user.name);
				userfound=true;
			}
		}
		
		if(!userfound) {
			System.out.println("Invalid email or password...Please try with correct details!");
		}
	}
	
//    public static void main(String[] args) {
//    	String userChoice = null;
//    	do{
//    		System.out.println("----------Welcome to BookMyShow----------");
//    		System.out.println("Please select what you want...");
//    		System.out.println("1.Register user \n2.Login \n3.Display Users \n4.Exit");
//    		Scanner scanner=new Scanner(System.in);
//    		System.out.println("Enter your choice: ");
//    		int ch=scanner.nextInt();
//    	
//    		switch(ch) {
//    		case 1:
//    			registerUser();
//    			break;
//    	
//    		case 2:
//    			loginUser();
//    			break;
//    			
//    		case 3:
//    			if(users.isEmpty()) {
//    				System.out.println("No users registered yet...!");
//    			}
//    			else {
//    				for(User user:users) {
//    					user.displayUser();
//    				}
//    			}
//    			break;
//    		
//    		case 4:
//    			System.out.println("Exiting....");
//    			break;
//    		}
//    	
//    		System.out.println("Do you want to continue...?");
//    		userChoice=scanner.next();
//    	}
//    	while(userChoice.equalsIgnoreCase("yes"));
//    }

}
