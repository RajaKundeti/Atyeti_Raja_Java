package problem3;

import java.time.LocalTime;

public class MovieSeatBookingSystem {

    private static final int[] seats = new int[200];
    public enum SeatType{ REGULAR, PREMIUM;}

    public static void bookSeats(int noOfSeats, LocalTime time, SeatType seatType){
        int seatsBooked = 0;
        switch (seatType){
            case REGULAR :
                System.out.print("Seats -> ");
                for(int i=0,j=0; i<noOfSeats && j< seats.length-20; j++){
                    if(seats[j]==0){
                        seats[j]=1;
                        System.out.print(j+" ");
                        i++;
                        seatsBooked++;
                    }
                }
                System.out.println(" are Booked!");
                break;
            case PREMIUM:
                System.out.print("Seats -> ");
                for(int i=0,j=80; i<noOfSeats && j< seats.length; j++){
                    if(seats[j]==0){
                        seats[j]=1;
                        System.out.print(j+" ");
                        i++;
                        seatsBooked++;
                    }
                }
                System.out.println(" are Booked!");
                break;
            default:
                System.out.println("Invalid SeatType!");
        }
        System.out.println("Total Booked Seats: "+seatsBooked);
    }
}
