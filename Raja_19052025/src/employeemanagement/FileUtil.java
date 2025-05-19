package employeemanagement;
import flightbooking.Booking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Employee> getEmployeeData(String filePath) {
        List<Employee> employees = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String[] data = null;
            String line = null;
            while((line = br.readLine()) != null){
                data = line.split(",");
                Employee e = new Employee();
                e.setId(Integer.parseInt(data[0]));
                e.setName(data[1]);
                e.setDepartment(data[2]);
                e.setSalary(Double.parseDouble(data[3]));
                employees.add(e);
            }
        }catch (IOException e){
            e.getStackTrace();
        }
        return employees;
    }
}
