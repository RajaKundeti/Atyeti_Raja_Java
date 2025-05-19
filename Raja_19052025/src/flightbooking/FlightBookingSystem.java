package flightbooking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static flightbooking.FileUtil.getBookingsData;

public class FlightBookingSystem {

    private static final String path = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\Atyeti_Raja_Java\\Raja_19052025\\src\\flightbooking\\bookings.csv";

    public static void main(String[] args) {

        List<Booking> bookings = FileUtil.getBookingsData(path);

        bookings = BookingService.removeDuplicateBookings(bookings);

        LocalDate date = LocalDate.parse("2023-07-02");
        List<String> passengers = BookingService.filterPassengersByDate(bookings,date);
        System.out.println();
        System.out.println("Passengers on "+date+" : ");
        System.out.println(passengers);
        System.out.println();

        double totalRevenue = BookingService.findTotalRevenue(bookings);
        System.out.println("Total revenue: "+ totalRevenue);
        System.out.println();

        Map<String, Double> revenueByFlight = BookingService.findTotalRevenueByFlight(bookings);
        System.out.println("Revenue By Flight: ");
        System.out.println(revenueByFlight);
        System.out.println();

        Map<LocalDate, Double> revenueByDate = BookingService.findTotalRevenueByDate(bookings);
        System.out.println("Revenue By Date: ");
        System.out.println(revenueByDate);
    }
}
