package book_my_show_pkg;
import java.util.*;

public class Movies_plays {
    String[] city;
    String[][] movies; 
    String[][] plays;
    
    public Movies_plays() {
        city = new String[] {"Mumbai", "Delhi", "Pune"};
        movies = new String[city.length][];
        plays = new String[city.length][];
        
        movies[0] = new String[] {"Dhoom", "Kabir Singh"};
        plays[0] = new String[] {"Natraj"};
        
        movies[1] = new String[] {"Dilwale"};
        plays[1] = new String[] {"The Lion King"};
        
        movies[2] = new String[] {"KGF", "Rocky"};
        plays[2] = new String[] {"Pushpa"};
    }
    
    void displayCity(String selectedCity, String choice) {
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < city.length; i++) {
            if (city[i].equalsIgnoreCase(selectedCity)) {
                System.out.println("City name: " + city[i]);
                found = true;
                
                if (choice.equalsIgnoreCase("Movies")) {
                    System.out.println("Movies available for " + city[i] + ":");
                    for (int j = 0; j < movies[i].length; j++) {
                        System.out.println((j + 1) + ". " + movies[i][j]);
                    }
                    
                    System.out.println("Select a movie by entering the number: ");
                    int movieChoice = sc.nextInt();
                    
                    if (movieChoice > 0 && movieChoice <= movies[i].length) {
                        String selectedMovie = movies[i][movieChoice - 1];
                        System.out.println("You selected: " + selectedMovie);
                        Book_seat.displaySeats();
                        Book_seat.bookSeat(0, 0);
                        System.out.println("Ticket booked for " + selectedMovie + " successfully!");
                    } else {
                        System.out.println("Invalid selection.");
                    }
                    
                } else if (choice.equalsIgnoreCase("Plays")) {
                    System.out.println("Plays available for " + city[i] + ":");
                    for (int j = 0; j < plays[i].length; j++) {
                        System.out.println((j + 1) + ". " + plays[i][j]);
                    }
                    
                } else {
                    System.out.println("Invalid choice! Please choose either 'Movies' or 'Plays'.");
                }
                break;
            }
        }
        
        if (!found) {
            System.out.println("City not found. Please try again with a valid city name.");
        }
    }
    
//    public static void main(String[] args) {
//        Movies_plays m = new Movies_plays();
//        Scanner sc = new Scanner(System.in);
//        
//        // Ask user to select a city
//        System.out.println("Enter the city you want to choose (Mumbai, Delhi, Pune):");
//        String city = sc.nextLine();
//        
//        // Ask user whether they want to see Movies or Plays
//        System.out.println("Do you want to see Movies or Plays for " + city + "?");
//        String choice = sc.nextLine();
//        
//        // Display the selected information for that city
//        m.displayCity(city, choice);
//        
//        sc.close();
//    }
}
