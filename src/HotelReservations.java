import java.sql.*;
import java.util.Scanner;

public class HotelReservations {

    private static String url = "jdbc:postgresql://localhost/postgresdemo";
    private static String username = "postgres";
    private static String password = "";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            Scanner sc = new Scanner(System.in);

            while (true) {

                
                System.out.println();
                System.out.println("Welcome to HOTEL MANAGEMENT SYSTEM");
                System.out.println("1. Reserve a Room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                System.out.println("0. Exit");
                System.out.print("Chose an option : ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> reserveRoom(connection, statement, sc);
                    
                    case 2 -> veiwReservations(connection, statement, sc);
                    
                    case 3 -> getRoomNumber(connection, statement, sc);
                    
                    case 4 -> UpdateReservations(connection, statement, sc);
                    
                    case 5 -> deleteReservations(connection, statement, sc);
                    
                    case 0 -> exit();
                    
                    default -> System.out.println("Invalid choice. Please try again!!!");
                    
                }

                
            }

            

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void reserveRoom(Connection connection, Statement statement, Scanner scanner) {

        System.out.print("Enter guest name : ");
        String guestName = scanner.next();
        scanner.nextLine();

        System.out.print("Enter room number : ");
        int roomNumber = scanner.nextInt();

        System.out.print("Enter contact no : ");
        String contactNo = scanner.next();

        try {

            String query = "insert into reservations(guest_name, room_number, contact_number) values('"+guestName+"',"+roomNumber+",'"+contactNo+"')";

            int affectedRow = statement.executeUpdate(query);
            
            if(affectedRow > 0) {

                System.out.println("Reservation successful for " +guestName);
            }
            else {

                System.out.println("Reservaion failed !!!");
            }

        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
    }

    private static void veiwReservations(Connection connection, Statement statement, Scanner scanner) {

        System.out.println("");
    }

    private static void getRoomNumber(Connection connection, Statement statement, Scanner scanner) {


    }

    private static void UpdateReservations(Connection connection, Statement statement, Scanner scanner) {


    }

    private static void deleteReservations(Connection connection, Statement statement, Scanner scanner) {


    }

    private static void exit() {

    }
}