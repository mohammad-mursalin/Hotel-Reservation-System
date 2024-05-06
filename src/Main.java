import java.sql.*;
import java.util.Scanner;

public class HotelReservations {

    private static String url = "jdbc:postgresql://localhost/postgresdemo";
    private static String username = "postgres";
    private static String password = "";

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(url, username, password);
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
                    case 1 -> reserveRoom(con,sc);
                    break;
                    case 2 -> veiwReservations(con,sc);
                    break;
                    case 3 -> getRoomNumber(con,sc);
                    break;
                    case 4 -> UpdateReservations(con,sc);
                    break;
                    case 5 -> deleteReservations(con,sc);
                    break;
                    case 0 -> exit();
                    break;
                    default -> System.out.println("Invalid choice. Please try again!!!");
                }
            }

            sc.close();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }
}