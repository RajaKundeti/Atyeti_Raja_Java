package vehiclemonitoring;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Vehicle> getVehiclesData(String filePath) {
        List<Vehicle> vehicles = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String[] data = null;
            String line = null;
            while((line = br.readLine()) != null){
                data = line.split(",");
                Vehicle v = new Vehicle();
                v.setVehicle_id(data[0]);
                v.setVehicle_type(data[1]);
                v.setLocation(data[2]);
                v.setEntry_time(Timestamp.valueOf(data[3]));
                v.setExit_time(Timestamp.valueOf(data[4]));
                vehicles.add(v);
            }
        }catch (IOException e){
            e.getStackTrace();
        }
        return vehicles;
    }
}
