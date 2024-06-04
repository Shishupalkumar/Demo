package hotel;
import java.time.LocalDate;import java.time.LocalDate;
import hotel.dao.RoomDAO;
import hotel.dao.ReservationDAO;
import hotel.dao.UserDAO;

import java.util.Scanner;

import static hotel.dao.UserDAO.viewUserDetails;

public class UserMenu {
    public static void showUserMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("USER MENU");
            System.out.println("1. Add User");
           System.out.println("2. view user Details");

            System.out.println("3. view Available Rooms");
            System.out.println("4.  make Reservation ");
            System.out.println("5. view My Reservations ");
            System.out.println("6. Check Out: ");
            System.out.println("7. update user");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                     viewUserDetails();

                    break;
                case 3:
                    viewAvailableRooms();

                    break;
                case 4:
                    makeReservation();
                    break;
                case 5:
                    viewMyReservations();
                    break;
                case 6:
                    checkOut();
                   break;

                case 7:
                    updateUser();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAvailableRooms() {
        RoomDAO.viewAvailableRooms();
    }

    private static void makeReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Room ID to reserve: ");
        int roomId = scanner.nextInt();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDate = scanner.next();
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDate = scanner.next();

        // Parse the input dates
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        if (startLocalDate.isBefore(currentDate) || endLocalDate.isBefore(currentDate)) {
            System.out.println("Invalid date. Please enter a future date.");
            return;
        }

        boolean success = ReservationDAO.makeReservation(userId, roomId, startDate, endDate);
        if (success) {
            System.out.println("Reservation made successfully.");
        } else {
            System.out.println("Failed to make reservation. Please try again.");
        }
    }

    private static void viewMyReservations() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your User ID: ");
        int userId = scanner.nextInt();
        ReservationDAO.viewReservationsByUser(userId);
    }

    private static void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter contact: ");
        String contact = scanner.next();
        System.out.print("Enter role (admin/user): ");
        String role = scanner.next();

        boolean success = UserDAO.addUser(username, password, email, contact, role);
        if (success) {
            System.out.println("User added successfully.");
        } else {
            System.out.println("Failed to add user. Please try again.");
        }
    }
    private static void checkOut() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Reservation ID: ");
        int reservationId = scanner.nextInt();
        System.out.print("Enter Room ID: ");
        int roomId = scanner.nextInt();

        boolean success = ReservationDAO.checkout(reservationId, roomId);
        if (success) {
            System.out.println("Checked out successfully. Room status updated to 'available'.");
        } else {
            System.out.println("Failed to check out. Please try again.");
        }
    }

    private static void updateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter new username: ");
        String username = scanner.next();
        System.out.print("Enter new password: ");
        String password = scanner.next();
        System.out.print("Enter new email: ");
        String email = scanner.next();
        System.out.print("Enter new contact: ");
        String contact = scanner.next();
        System.out.print("Enter new role (admin/user): ");
        String role = scanner.next();

        boolean success = UserDAO.updateUser(userId, username, password, email, contact, role);
        if (success) {
            System.out.println("User updated successfully.");
        } else {
            System.out.println("Failed to update user. Please try again.");
        }
    }
}
