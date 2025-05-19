package flightbooking;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingService {

    public static List<String> filterPassengersByDate(List<Booking> bookings, LocalDate date) {
        return bookings.stream()
                .filter(b->b.getDate().equals(date))
                .map(Booking::getPassengerName)
                .toList();
    }

    public static List<Booking> removeDuplicateBookings(List<Booking> bookings) {
        return bookings.stream().distinct().collect(Collectors.toList());
    }

    public static double findTotalRevenue(List<Booking> bookings) {
        return bookings.stream().mapToDouble(Booking::getFare).sum();
    }

    public static Map<String, Double> findTotalRevenueByFlight(List<Booking> bookings) {
        return bookings.stream()
                .collect(Collectors.groupingBy(Booking::getFlightId,Collectors.summingDouble(Booking::getFare)));
    }

    public static Map<LocalDate, Double> findTotalRevenueByDate(List<Booking> bookings) {
        return bookings.stream()
                .collect(Collectors.groupingBy(Booking::getDate,Collectors.summingDouble(Booking::getFare)));

    }
}
