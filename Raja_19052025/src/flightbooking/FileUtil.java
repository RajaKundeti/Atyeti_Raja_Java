package flightbooking;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Booking> getBookingsData(String filePath) {
        List<Booking> bookings = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String[] data = null;
            String line = null;
            while((line = br.readLine()) != null){
                data = line.split(",");
                Booking b = new Booking();
                b.setFlightId(data[0]);
                b.setPassengerName(data[1]);
                b.setDate(LocalDate.parse(data[2]));
                b.setFare(Double.parseDouble(data[3]));
                bookings.add(b);
            }
        }catch (IOException e){
            e.getStackTrace();
        }
        return bookings;
    }
}
