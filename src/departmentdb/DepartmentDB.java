/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentdb;

import model.Department;
import model.DepartmentTable;
import model.Employee;
import model.EmployeeTable;

/**
 *
 * @author Akiparn
 */
public class DepartmentDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Department dp1 = new Department(1, "IT");
        Department dp2 = new Department(2, "HR");

        Employee emp1 = new Employee(1, "John", "Network Admin", 56789, dp1);
        Employee emp2 = new Employee(2, "Marry", "HR Manager", 46789, dp2);
        Employee emp3 = new Employee(3, "Henry", "Programmer", 67890, dp1);
        Employee emp4 = new Employee(4, "Clark", "HR recruiter", 36789, dp2);
        
        DepartmentTable.InsertDepartment(dp1);
        DepartmentTable.InsertDepartment(dp2);
        
        EmployeeTable.InsertEmployee(emp1);
        EmployeeTable.InsertEmployee(emp2);
        EmployeeTable.InsertEmployee(emp3);
        EmployeeTable.InsertEmployee(emp4);
    }
    
}
