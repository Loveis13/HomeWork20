package skypro.employeeBook.service;

import skypro.employeeBook.dto.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee addEmployee(String firstName, String lastName, int department, double salary);

    Employee removeEmployee(String firsName, String lastName);

    Employee getEmployee(String firstName, String lastName);

    Collection<Employee> findAll();
}
