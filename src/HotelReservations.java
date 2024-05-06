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

            System.out.println();
            System.out.println("Welcome to HOTEL MANAGEMENT SYSTEM");

            while (true) {

                System.out.println();
                System.out.println("1. Reserve a Room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Room Number");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                System.out.println("0. Exit");
                System.out.println();
                System.out.print("Chose an option : ");
                int choice = sc.nextInt();
                System.out.println();

                switch (choice) {
                    case 1 -> reserveRoom(connection, statement, sc);
                    
                    case 2 -> viewReservations(statement, sc);
                    
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

    private static void viewReservations(Statement statement, Scanner scanner) {

        try {
            
            String query = "select * from reservations";

            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Current Reservations:");
            System.out.println("+----------------+-----------------+---------------+---------------------+----------------------------+");
            System.out.println("| Reservation ID | Guest           | Room Number   | Contact Number      | Reservation Date           |");
            System.out.println("+----------------+-----------------+---------------+---------------------+----------------------------+");

            while (resultSet.next()) {
                
                int reservation_id = resultSet.getInt(1);
                String guest_name = resultSet.getString(2);
                int room_number = resultSet.getInt("room_number");
                String contact_number = resultSet.getString(4);
                String reservation_date = resultSet.getString(5).toString();

                System.out.printf("| %-14d | %-15s | %-13d | %-19s | %-19s |\n",reservation_id, guest_name, room_number, contact_number, reservation_date);

            }

            System.out.println("+----------------+-----------------+---------------+---------------------+----------------------------+");

        } catch (SQLException e) {

            e.printStackTrace();
            
        }
    }

    private static void getRoomNumber(Connection connection, Statement statement, Scanner scanner) {

        System.out.print("Enter reservation id : ");
        int guestId = scanner.nextInt();

        String query = "select room_number from reservations where reservation_id = " +guestId;

        try {

            ResultSet resultSet = statement.executeQuery(query);

            if(resultSet.next()) {

                int roomNumber = resultSet.getInt("room_number");

                System.out.println("Room number for reservation id " +guestId+ " : " +roomNumber);
            }
            else {

                System.out.println("Room number for reservation id " +guestId+ " is not found");
            }


        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    private static void UpdateReservations(Connection connection, Statement statement, Scanner scanner) {


    }

    private static void deleteReservations(Connection connection, Statement statement, Scanner scanner) {


    }

    private static void exit() {

    }
}