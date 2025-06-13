package vehiclemonitoring;
import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VehicleService {

    public List<String> getOverstayedVehicles(List<Vehicle> vehicles) {
        return vehicles.stream().filter(v->{
            return Duration.between(
                    v.getEntry_time().toLocalDateTime(),v.getExit_time().toLocalDateTime()
            ).toHours() >3;
        }).map(Vehicle::getVehicle_id).toList();
    }

    public Map<String, Map<String, LocalTime>> getTotalTimeSpentByLocation(List<Vehicle> vehicles) {
        return vehicles.stream()
                .collect(Collectors.groupingBy(
                        Vehicle::getLocation ,
                        Collectors.toMap(
                                Vehicle::getVehicle_id,
                                v->{
                                    long milliseconds = v.getExit_time().getTime() - v.getEntry_time().getTime();
                                    return LocalTime.ofSecondOfDay(milliseconds / 1000);
                                }
                        )
                ));
    }

    public Map<String, Long> getTopFrequentVehicles(List<Vehicle> vehicles, int i) {
        return vehicles.stream()
                .collect(Collectors.groupingBy(Vehicle::getVehicle_id,Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(i)
                .collect(LinkedHashMap::new,
                        (m, e) -> m.put(e.getKey(), e.getValue()),
                        LinkedHashMap::putAll);
    }

    public Map<String, Map<String, LocalTime>> getAverageTimeBYLocationAndVehicle(List<Vehicle> vehicles) {
        return vehicles.stream()
                .collect(Collectors.groupingBy(
                        Vehicle::getLocation ,
                        Collectors.toMap(
                                Collectors.groupingBy(Vehicle::getVehicle_type),
                                Collectors.averagingLong((Vehicle)vehicle ->
                                        Duration.between(vehicle.getEntryTime(), vehicle.getExitTime()).toMinutes()
                                )
                        )
                ));
    }
}
