/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departmentdb;

import java.util.Collection;
import java.util.List;
import model.Department;
import model.DepartmentTable;
import model.Employee;
import model.EmployeeTable;

/**
 *
 * @author Akiparn
 */
public class DepartmentReport {
    public static void main(String[] args) {
    
        List<Employee> empListByID = EmployeeTable.findAllEmployee();
        System.out.println("All employees (by ID)");
        System.out.println("---------------------------");
        for (Employee employee : empListByID) {
            System.out.println("ID: " + employee.getEmployeeid());
            System.out.println("Name: " + employee.getName());
            System.out.println("Job: " + employee.getJob());
            System.out.println("Salary: " + employee.getSalary());
            System.out.println("Department: " + employee.getDepartmentid().getName());
            System.out.println("---------------------------");
    }
        
        List<Department> dpList = DepartmentTable.findAllDepartment();
        System.out.println("All employees (by Department)");
        System.out.println("---------------------------");
        for (Department department : dpList) {
            System.out.println("Department ID: " + department.getDepartmentid());
            System.out.println("Department Name: " + department.getName());
            System.out.println("---------------------------");
            Collection<Employee> empCollection = department.getEmployeeCollection();
            for(Employee emp : empCollection){
                System.out.println("ID: " + emp.getEmployeeid());
                System.out.println("Name: " + emp.getName());
                System.out.println("Job: " + emp.getJob());
                System.out.println("Salary: " + emp.getSalary());
                System.out.println("---------------------------");
            }
        }
        
    }
}
