package organizationprocessing;

import java.util.*;
import java.util.stream.Collectors;

public class OrganizationService {


    public Map<String, List<Employee>> getOrganizationData(List<Employee> employees) {
        return employees.stream()
                .filter(e->e.getManager_id()!=null)
                .collect(Collectors
                        .groupingBy(e->getManagerName(e,employees),Collectors.toList()));
    }

    private String getManagerName(Employee e, List<Employee> employees) {
        String name = null;
        for(Employee emp: employees){
            if(emp.getEmployee_id() == e.getManager_id()) {
                name = emp.getEmployee_name();
                break;
            }
        }
        return name;
    }

    public Map<String, Double> getAverageSalaryByManager(Map<String, List<Employee>> orgData) {
        Map<String, Double> avgSalariesByManager = new HashMap<>();
        orgData.forEach((name,list)->{
            avgSalariesByManager.put(
                    name,
                    list.stream().mapToDouble(Employee::getSalary).sum()
            );
        });
        return avgSalariesByManager;
    }

    public Map<String, Double> getTopThreeDepartmentsBySalary(List<Employee> employees) {
        TreeMap<String, Double> salariesByDept = new TreeMap<>();
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((key, value) -> salariesByDept.put(key, value.stream().mapToDouble(Employee::getSalary).sum()));
        return salariesByDept;
    }
}
