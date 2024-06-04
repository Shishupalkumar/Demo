import Dao.ReservationDAO;
import Models.Reservation;
import Connection.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            ReservationDAO reservationDAO = new ReservationDAO();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println();
                System.out.println("HOTEL MANAGEMENT SYSTEM");
                System.out.println("1. Admin");
                System.out.println("2. User");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int roleChoice = scanner.nextInt();

                switch (roleChoice) {
                    case 1:
                        adminMenu(connection, reservationDAO, scanner);
                        break;
                    case 2:
                        userMenu(connection, reservationDAO, scanner);
                        break;
                    case 0:
                        exit();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void adminMenu(Connection connection, ReservationDAO reservationDAO, Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("ADMIN MENU");
            System.out.println("1. View Reservations");
            System.out.println("2. View Room Status");
            System.out.println("3. View User Details");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");
            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    viewReservations(connection, reservationDAO);
                    break;
                case 2:
                    viewRoomStatus(connection, reservationDAO);
                    break;
                case 3:
                    viewUserDetails(connection, reservationDAO);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void userMenu(Connection connection, ReservationDAO reservationDAO, Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("USER MENU");
            System.out.println("1. Reserve a Room");
            System.out.println("2. Update Reservation");
            System.out.println("3. Delete Reservation");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    reserveRoom(connection, reservationDAO, scanner);
                    break;
                case 2:
                    updateReservation(connection, reservationDAO, scanner);
                    break;
                case 3:
                    deleteReservation(connection, reservationDAO, scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void reserveRoom(Connection connection, ReservationDAO reservationDAO, Scanner scanner) {
        System.out.print("Enter guest name: ");
        String guestName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        System.out.print("Enter Email number: ");
        String email = scanner.next();

        Reservation reservation = new Reservation(guestName, roomNumber, email);
        if (reservationDAO.reserveRoom(connection, reservation)) {
            System.out.println("Reservation successful!");
        } else {
            System.out.println("Reservation failed.");
        }
    }

    private static void viewReservations(Connection connection, ReservationDAO reservationDAO) {
        List<Reservation> reservations = reservationDAO.viewReservations(connection);

        System.out.println("Current Reservations:");
        System.out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");
        System.out.println("| Reservation ID | Guest           | Room Number   | Contact Number      | Reservation Date        |");
        System.out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");

        for (Reservation reservation : reservations) {
            System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s   |\n",
                    reservation.getReservationId(), reservation.getGuestName(), reservation.getRoomNumber(),
                    reservation.getContactNumber(), reservation.getReservationDate());
        }

        System.out.println("+----------------+-----------------+---------------+----------------------+-------------------------+");
    }

    private static void getRoomNumber(Connection connection, ReservationDAO reservationDAO, Scanner scanner) {
        System.out.print("Enter reservation ID: ");
        int reservationId = scanner.nextInt();
        System.out.print("Enter guest name: ");
        String guestName = scanner.next();

        Integer roomNumber = reservationDAO.getRoomNumber(connection, reservationId, guestName);
        if (roomNumber != null) {
            System.out.println("Room number for Reservation ID " + reservationId + " and Guest " + guestName + " is: " + roomNumber);
        } else {
            System.out.println("Reservation not found for the given ID and guest name.");
        }
    }

    private static void updateReservation(Connection connection, ReservationDAO reservationDAO, Scanner scanner) {
        System.out.print("Enter reservation ID to update: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine();

        if (!reservationDAO.reservationExists(connection, reservationId)) {
            System.out.println("Reservation not found for the given ID.");
            return;
        }

        System.out.print("Enter new guest name: ");
        String newGuestName = scanner.nextLine();
        System.out.print("Enter new room number: ");
        int newRoomNumber = scanner.nextInt();
        System.out.print("Enter new contact number: ");
        String newContactNumber = scanner.next();

        Reservation reservation = new Reservation(newGuestName, newRoomNumber, newContactNumber);
        reservation.setReservationId(reservationId);
        if (reservationDAO.updateReservation(connection, reservation)) {
            System.out.println("Reservation updated successfully!");
        } else {
            System.out.println("Reservation update failed.");
        }
    }

    private static void deleteReservation(Connection connection, ReservationDAO reservationDAO, Scanner scanner) {
        System.out.print("Enter reservation ID to delete: ");
        int reservationId = scanner.nextInt();

        if (!reservationDAO.reservationExists(connection, reservationId)) {
            System.out.println("Reservation not found for the given ID.");
            return;
        }

        if (reservationDAO.deleteReservation(connection, reservationId)) {
            System.out.println("Reservation deleted successfully!");
        } else {
            System.out.println("Reservation deletion failed.");
        }
    }

    private static void viewRoomStatus(Connection connection, ReservationDAO reservationDAO) {
        // Implement the logic to view room status
        System.out.println("Room Status functionality is not yet implemented.");
    }

    private static void viewUserDetails(Connection connection, ReservationDAO reservationDAO) {
        // Implement the logic to view user details
        System.out.println("User Details functionality is not yet implemented.");
    }

    private static void exit() throws InterruptedException {
        System.out.print("Exiting System");
        int i = 5;
        while (i != 0) {
            System.out.print(".");
            Thread.sleep(1000);
            i--;
        }
        System.out.println();
        System.out.println("Thank You For Using Hotel Reservation System!!!");
    }
}
