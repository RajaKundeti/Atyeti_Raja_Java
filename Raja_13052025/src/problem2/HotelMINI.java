package Problem2;

public class HotelMINI {

    public static void main(String[] args) {
        HotelBookingSystem.bookRoom(3,RoomType.AC,5);
        HotelBookingSystem.bookRoom(5,RoomType.NON_AC,10);
        HotelBookingSystem.bookRoom(8,RoomType.AC,6);
    }
}
