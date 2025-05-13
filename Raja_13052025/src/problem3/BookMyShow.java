package problem3;

import java.time.LocalTime;

public class BookMyShow {
    public static void main(String[] args) {
        MovieSeatBookingSystem.bookSeats(5, LocalTime.of(10,0,0), MovieSeatBookingSystem.SeatType.REGULAR);
        MovieSeatBookingSystem.bookSeats(10, LocalTime.of(14,0,0), MovieSeatBookingSystem.SeatType.REGULAR);
        MovieSeatBookingSystem.bookSeats(2, LocalTime.of(16,0,0), MovieSeatBookingSystem.SeatType.PREMIUM);
        MovieSeatBookingSystem.bookSeats(4, LocalTime.of(20,0,0), MovieSeatBookingSystem.SeatType.PREMIUM);
    }
}
