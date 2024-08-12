import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TravelBooking {
    private String bookingId;
    private String passengerName;
    private String travelDate;
    private String destination;
    private int numPassengers;
    private double fare;

    public TravelBooking(String bookingId, String passengerName, String travelDate, String destination, int numPassengers, double fare) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.travelDate = travelDate;
        this.destination = destination;
        this.numPassengers = numPassengers;
        this.fare = fare;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public String getDestination() {
        return destination;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public double getFare() {
        return fare;
    }
}

public class TravelBookingSystem {
    private List<TravelBooking> bookings;
    private Scanner scanner;

    public TravelBookingSystem() {
        bookings = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addBooking() {
        System.out.print("Enter booking ID: ");
        String bookingId = scanner.nextLine();
        System.out.print("Enter passenger name: ");
        String passengerName = scanner.nextLine();
        System.out.print("Enter travel date (yyyy-mm-dd): ");
        String travelDate = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter number of passengers: ");
        int numPassengers = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
        System.out.print("Enter fare: ");
        double fare = scanner.nextDouble();
        scanner.nextLine(); // consume newline left-over

        TravelBooking booking = new TravelBooking(bookingId, passengerName, travelDate, destination, numPassengers, fare);
        bookings.add(booking);
        System.out.println("Booking added successfully!");
    }

    public void viewBookings() {
        System.out.println("Bookings:");
        for (TravelBooking booking : bookings) {
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Passenger Name: " + booking.getPassengerName());
            System.out.println("Travel Date: " + booking.getTravelDate());
            System.out.println("Destination: " + booking.getDestination());
            System.out.println("Number of Passengers: " + booking.getNumPassengers());
            System.out.println("Fare: " + booking.getFare());
            System.out.println();
        }
    }

    public void cancelBooking() {
        System.out.print("Enter booking ID to cancel: ");
        String bookingId = scanner.nextLine();
        for (TravelBooking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                bookings.remove(booking);
                System.out.println("Booking cancelled successfully!");
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    public void run() {
        while (true) {
            System.out.println("Travel Booking System");
            System.out.println("1. Add Booking");
            System.out.println("2. View Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (choice) {
                case 1:
                    addBooking();
                    break;
                case 2:
                    viewBookings();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        TravelBookingSystem system = new TravelBookingSystem();
        system.run();
    }
}