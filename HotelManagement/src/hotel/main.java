package hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    public main() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
    }

    public void addRoom(int roomNumber, String type) {
        rooms.add(new Room(roomNumber, type));
        System.out.println("Room added: " + roomNumber);
    }

    public void bookRoom(Guest guest, int roomNumber, int days) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isBooked()) {
                room.bookRoom();
                bookings.add(new Booking(room, guest, days));
                System.out.println("Booked successfully for " + guest.getName() + "!");
                return;
            }
        }
        System.out.println("Room unavailable or invalid.");
    }

    public void checkOut(int roomNumber) {
        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == roomNumber) {
                booking.getRoom().vacateRoom();
                System.out.println("Checked out: " + booking);
                return;
            }
        }
        System.out.println("No booking found for room " + roomNumber);
    }

    public void displayAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println(room);
            }
        }
    }

    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings yet.");
        } else {
            System.out.println("\nCurrent Bookings:");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    public static void  main(String[] args) {
        main hotel = new main();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Hotel Management System ===");
        
        do {
            System.out.println("\n1. Add Room");
            System.out.println("2. Book Room");
            System.out.println("3. View Available Rooms");
            System.out.println("4. View Bookings");
            System.out.println("5. Check Out");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNum = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String type = scanner.nextLine();
                    hotel.addRoom(roomNum, type);
                    break;
                
                case 2:
                    scanner.nextLine();
                    System.out.print("Guest name: ");
                    String name = scanner.nextLine();
                    System.out.print("Guest contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Room number: ");
                    int bookRoomNum = scanner.nextInt();
                    System.out.print("Days to stay: ");
                    int days = scanner.nextInt();
                    hotel.bookRoom(new Guest(name, contact), bookRoomNum, days);
                    break;
                
                case 3:
                    hotel.displayAvailableRooms();
                    break;
                
                case 4:
                    hotel.displayBookings();
                    break;
                
                case 5:
                    System.out.print("Enter room number to check out: ");
                    int checkoutRoom = scanner.nextInt();
                    hotel.checkOut(checkoutRoom);
                    break;
                
                case 0:
                    System.out.println("Exiting...");
                    break;
                
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }
}
