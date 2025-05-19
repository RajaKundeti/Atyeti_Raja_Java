package flightbooking;

import java.time.LocalDate;
import java.util.Objects;

public class Booking {

    private String flightId;
    private String passengerName;
    private LocalDate date;
    private double fare;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(flightId, booking.flightId) && Objects.equals(passengerName, booking.passengerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, passengerName);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "flightId='" + flightId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", date=" + date +
                ", fare=" + fare +
                '}';
    }

}
