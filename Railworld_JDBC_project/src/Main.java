import Dao.GuestDAO;
import Models.Guest;
import Service.HotelService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private HotelService hotelService;
    private Scanner scanner;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main() {
        hotelService = new HotelService();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine().trim());

            try {
                switch (choice) {
                    case 1:
                        addGuest();
                        break;
                    case 2:
                        viewAllGuest();
                        break;
                    case 3:
                        updateGuest();
                        break;
                    case 4:
                        deleteGuest();
                        break;
                    case 5:
                        viewGuestById();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter a number.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n Hotel Management System");
        System.out.println("1. Add Guest");
        System.out.println("2. View All Guest");
        System.out.println("3. Update Guest");
        System.out.println("4. Delete Guest");
        System.out.println("5. View Guest by ID");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addGuest() throws SQLException {
        System.out.print("Enter First name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter Last name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine().trim(); // Read input as String

        System.out.print("Enter Room Number: ");
        int room_no = Integer.parseInt(scanner.nextLine().trim());

        Guest guest = new Guest();
        guest.setFirstName(firstName);
        guest.setLastName(lastName);
        guest.setEmail(email);
        guest.setContact(contact);  // Set contact as String
        guest.getRoom_no(room_no);

        hotelService.addGuest(guest);
        System.out.println("Guest added successfully!");
    }

    private void viewAllGuest() throws SQLException {
        List<Guest> guests = hotelService.getAllGuest();
        System.out.println("Current Reservations:");
        System.out.println("+----------------+-----------------+---------------+---------------------------------------------------------------+-----------------------------+----------------------|");
        System.out.println("|  ID            | First Name      | Last Name     |            Email                                              |     Contact                  |       Room_no        |");
        System.out.println("+----------------+-----------------+---------------+---------------------------------------------------------------+-----------------------------+----------------------|");

        for (Guest guest : guests) {
            int room_no = 0;
            System.out.printf("| %-14d | %-15s | %-15s | %-16s | %-14s | %-22d |\n",
                    guest.getGuestId(), guest.getFirstName(), guest.getLastName(),
                    guest.getEmail(), guest.getContact(), guest.getRoom_no(room_no));
        }

        System.out.println("+----------------+-----------------+---------------+---------------------------------------------------------------+-----------------------------+----------------------|");
    }

    private void updateGuest() throws SQLException {
        System.out.print("Enter Guest ID to update: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter new first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter new last name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Enter new Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter new contact: ");
        String contact = scanner.nextLine().trim();  // Change to String

        Guest guest = new Guest();
        guest.setGuestId(id);
        guest.setFirstName(firstName);
        guest.setLastName(lastName);
        guest.setEmail(email);
        guest.setContact(contact);  // Set contact as String

        hotelService.updateGuest(guest);
        System.out.println("Guest updated successfully!");
    }

    private void deleteGuest() throws SQLException {
        System.out.print("Enter Guest ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        hotelService.deleteGuest(id);
        System.out.println("Guest deleted successfully!");
    }

    private void viewGuestById() throws SQLException {
        System.out.print("Enter Guest ID to view: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        List<Guest> guests = GuestDAO.getGuestsById(id);  // Retrieve the guest list by ID
        if (guests != null && !guests.isEmpty()) {
            System.out.println("Current Reservations:");
            System.out.println("+----------------+-----------------+---------------+---------------------------------------------------------------+-----------------------------+----------------------|");
            System.out.println("|  ID            | First Name      | Last Name     |            Email                                              |     Contact                  |       Room_no        |");
            System.out.println("+----------------+-----------------+---------------+---------------------------------------------------------------+-----------------------------+----------------------|");

            for (Guest guest : guests) {
                int room_no=0;
                System.out.printf("| %-14d | %-15s | %-15s | %-16s | %-14s | %-22d |\n",
                        guest.getGuestId(), guest.getFirstName(), guest.getLastName(),
                        guest.getEmail(), guest.getContact(), guest.getRoom_no(room_no));
            }

            System.out.println("+----------------+-----------------+---------------+---------------------------------------------------------------+-----------------------------+----------------------|");

        } else {
            System.out.println("Guest with ID " + id + " not found.");
        }
    }
}
