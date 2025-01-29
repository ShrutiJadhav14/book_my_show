package book_my_show_pkg;

import java.util.Scanner;

public class Book_seat {
	static int[][] seats=new int[5][5];

	public static void displaySeats() {
		System.out.println("=====Available Seats=====");
		for(int i=0;i<seats.length;i++) {
			System.out.println();
			for(int j=0;j<seats[i].length;j++) {
				if (seats[i][j] == 0) {
                    System.out.print("[A] "); 
                } else {
                    System.out.print("[B] "); 
                }
			}
		}
	}
	
	public static void bookSeat(int row, int column) {
	    System.out.println("Enter number of tickets you want to book:");
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int bookedSeats = 0;

	    // Try booking `n` tickets
	    for (int i = 0; i < n; i++) {
	        System.out.println("Enter row number (0-4) for ticket " + (i+1) + ": ");
	        row = sc.nextInt();
	        System.out.println("Enter column number (0-4) for ticket " + (i+1) + ": ");
	        column = sc.nextInt();

	        // Check if the seat is available
	        if (row >= 0 && row < seats.length && column >= 0 && column < seats[row].length) {
	            if (seats[row][column] == 0) {
	                seats[row][column] = 1; // Book the seat
	                System.out.println("Ticket " + (i+1) + " booked successfully.");
	                bookedSeats++;
	            } else {
	                System.out.println("Seat at row " + row + ", column " + column + " is already booked.");
	            }
	        } else {
	            System.out.println("Invalid seat number.");
	        }
	    }

	    if (bookedSeats == n) {
	        System.out.println(n + " tickets booked successfully.");
	    } else {
	        System.out.println("Could not book " + (n - bookedSeats) + " tickets.");
	    }
	}

	public static boolean cancelSeat(int row,int col) {
		if(row >= 0 && row < seats.length && col >= 0 && col < seats[row].length) {
			if(seats[row][col]==1) {
				seats[row][col] = 0;
				System.out.println("Your seat is cancelled successfully.");
				return true;
			}
			else {
				System.out.println("Seat was not booked...");
				return false;
			}
		}
		else {
			System.out.println("Please enter valid seat number");
			return false;
		}
	}
	
//	public static void main(String[]args) {
//		System.out.println("=====Seat Booking and Seat Availability=====");
//		String userChoice=null; 
//		
//	    do {
//	    	System.out.println("1.Display seats \n2.Book seat \n3.Cancel Booking \n4.Exit");
//		    Scanner sc=new Scanner(System.in);
//		    System.out.println("Enter your choice: ");
//		    int ch=sc.nextInt();
//		    
//		    switch(ch) {
//		    case 1:
//		    	displaySeats();
//		    	break;
//		    	
//		    case 2:
//		    	bookSeat(0,0);
//		    	break;
//		    	
//		    case 3:
//		    	System.out.println("Enter your seat row number(0-4): ");
//		    	int r=sc.nextInt();
//		    	
//		    	System.out.println("Enter column of seat(0-4): ");
//		    	int c=sc.nextInt();
//		    	
//		    	cancelSeat(r,c);
//		    	break;
//		    	
//		    case 4:
//		    	System.out.println("Exiting...");
//		    	System.exit(0);
//		    	break;
//		    
//		    }
//		    
//		    System.out.println("\nDo you want to continue(yes/no)?");
//		    userChoice=sc.next();
//		    
//	    }while(userChoice.equalsIgnoreCase("yes"));
//	}
}
