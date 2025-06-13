package vehiclemonitoring;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class VehicleMonitoring {

    private static final String path = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\Atyeti_Raja_Java\\Raja_21052025\\src\\vehiclemonitoring\\vehicle_entries.csv";
    private static final String topPath = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\Atyeti_Raja_Java\\Raja_21052025\\src\\vehiclemonitoring\\top_vehicles_input.csv";
    private static final VehicleService vehicleService = new VehicleService();

    public static void main(String[] args) {

        List<Vehicle> vehicles = FileUtil.getVehiclesData(path);

        //  IDENTIFYING VEHICLES THAT OVERSTAYED MORE THAN 3 HOURS
        List<String> overstayedVehicles = vehicleService.getOverstayedVehicles(vehicles);
        System.out.println("Vehicles Overstayed by 3 hours: ");
        System.out.println(overstayedVehicles);

        //  CALCULATE TOTAL TIME SPENT BY EACH VEHICLE GROUPED BY LOCATION
        Map<String, Map<String, LocalTime>> totalTimeSpentByLocation = vehicleService.getTotalTimeSpentByLocation(vehicles);
        System.out.println("Vehicles total time spent by location(in Hrs): ");
        System.out.println(totalTimeSpentByLocation);

        //  DETECT THE TOP 5 MOST FREQUENT VEHICLES
        List<Vehicle> vehiclesData2 = FileUtil.getVehiclesData(topPath);
        Map<String, Long> topFrequentVehicles = vehicleService.getTopFrequentVehicles(vehiclesData2,5);
        System.out.println("Top 5 Most Frequent Vehicles:");
        System.out.println(topFrequentVehicles);

        //  FIND AVERAGE TIME SPENT BY VEHICLE TYPE PER LOCATION
        Map<String, Map<String, LocalTime>> averageTimeByVehicleAndLocation = vehicleService.getAverageTimeBYLocationAndVehicle(vehiclesData2);


    }
}
