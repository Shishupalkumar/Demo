package hotel;

import hotel.dao.ReservationDAO;
import hotel.dao.RoomDAO;
import hotel.dao.UserDAO;

import java.util.Scanner;

public class AdminMenu {
    public static void showAdminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ADMIN MENU");
            System.out.println("1. View Reservations");
            System.out.println("2. View Room Status");
            System.out.println("3. View User Details");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ReservationDAO.viewReservations();
                    break;
                case 2:
                    RoomDAO.viewRoomStatus();
                    break;
                case 3:
                    UserDAO.viewUserDetails();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
