package employeemanagement;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    public List<Employee> findEmployeesByDepartment(List<Employee> employeeList, String department){
        return employeeList.stream()
                .filter(e->e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesBySalary(List<Employee> employeeList){
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public List<Employee> removeDuplicateEmployees(List<Employee> employeeList){
        return new ArrayList<>(new HashSet<>(employeeList));
    }

    public Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employeeList){
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toList()));
    }


}
