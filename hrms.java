import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private String email;
    private String department;
    private String designation;
    private double salary;

    public Employee(String name, int id, String email, String department, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class HRMS {
    private List<Employee> employees;

    public HRMS() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}

public class HRMSMain {
    public static void main(String[] args) {
        HRMS hrms = new HRMS();

        // Add some employees to the HRMS
        Employee emp1 = new Employee("John Doe", 1001, "john.doe@example.com", "IT", "Developer", 50000);
        Employee emp2 = new Employee("Jane Doe", 1002, "jane.doe@example.com", "Sales", "Manager", 70000);
        hrms.addEmployee(emp1);
        hrms.addEmployee(emp2);

        // Print details of an employee
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        Employee employee = hrms.getEmployeeById(id);
        if (employee != null) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Email: " + employee.getEmail());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Designation: " + employee.getDesignation());
            System.out.println("Salary: " + employee.getSalary());
        } else {
            System.out.println("Employee not found!");
        }

        // Update an employee's salary
        System.out.print("Enter employee ID: ");
        id = scanner.nextInt();
        employee = hrms.getEmployeeById(id);
        if (employee != null) {
            System.out.print("Enter new salary: ");
            double salary = scanner.nextDouble();
            employee.setSalary(salary);
            System.out.println("Salary updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }

        // List all employees in the HRMS
        System.out.println("All employees in the HRMS:");
        List<Employee> employees = hrms.getAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " - " + emp.getDepartment() + " - " + emp.getDesignation());
        }
    }
}
