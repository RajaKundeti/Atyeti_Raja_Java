package organizationprocessing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Employee> getEmployeesData(String filePath) {
        List<Employee> employees = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String[] data = null;
            String line = null;
            while((line = br.readLine()) != null){
                data = line.split(",");
                Employee e = new Employee();
               e.setEmployee_id(Integer.parseInt(data[0]));
               e.setEmployee_name(data[1]);
               try{
                   int mid = Integer.parseInt(data[2]);
                   e.setManager_id(mid);
               }catch (Exception ex){
                  e.setManager_id(null);
               }
               e.setDepartment(data[3]);
               e.setSalary(Double.parseDouble(data[4]));
               employees.add(e);
            }
        }catch (IOException e){
            e.getStackTrace();
        }
        return employees;
    }
}
