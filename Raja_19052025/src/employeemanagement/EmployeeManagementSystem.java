package employeemanagement;

import java.util.List;

import static employeemanagement.FileUtil.getEmployeeData;

public class EmployeeManagementSystem {

    private static final String path = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\Atyeti_Raja_Java\\Raja_19052025\\src\\employeemanagement\\employees.csv";
    private static final EmployeeService employeeService = new EmployeeService();
    public static void main(String[] args) {

        List<Employee> employees = FileUtil.getEmployeeData(path);

        System.out.println();
        System.out.println("No Of Employees before removing duplicates: "+employees.size());
        employees = employeeService.removeDuplicateEmployees(employees);
        System.out.println("No Of Employees after removing duplicates: "+employees.size());
        System.out.println();

        System.out.println();
        System.out.println("Employees after sorting by salary: ");
        System.out.println(employeeService.sortEmployeesBySalary(employees));
        System.out.println();

        System.out.println();
        System.out.println("Employees in Department Sales: ");
        System.out.println(employeeService.findEmployeesByDepartment(employees,"Sales"));
        System.out.println();

        System.out.println();
        System.out.println("Employees Grouping by Department: ");
        System.out.println(employeeService.groupEmployeesByDepartment(employees));
        System.out.println();
    }
}
