package hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("HOTEL MANAGEMENT SYSTEM");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice)
            {

                case 1:
                    AdminMenu.showAdminMenu();
                    break;
                case 2:
                    UserMenu.showUserMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
