package vehiclemonitoring;

import java.sql.Timestamp;

public class Vehicle {

    private String vehicle_id;
    private String vehicle_type;
    private String location;
    private Timestamp entry_time;
    private Timestamp exit_time;

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(Timestamp entry_time) {
        this.entry_time = entry_time;
    }

    public Timestamp getExit_time() {
        return exit_time;
    }

    public void setExit_time(Timestamp exit_time) {
        this.exit_time = exit_time;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_id='" + vehicle_id + '\'' +
                ", vehicle_type='" + vehicle_type + '\'' +
                ", location='" + location + '\'' +
                ", entry_time=" + entry_time +
                ", exit_time=" + exit_time +
                "}\n";
    }
}
