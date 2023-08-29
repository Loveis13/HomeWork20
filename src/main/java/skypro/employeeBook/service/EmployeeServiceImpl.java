package skypro.employeeBook.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import skypro.employeeBook.dto.Employee;
import skypro.employeeBook.exception.EmployeeAlreadyAddedException;
import skypro.employeeBook.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees;

    private static final int EMPLOYEES_SIZE = 3;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        return null ;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(StringUtils.capitalize(firstName),StringUtils.capitalize(lastName));

        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firsName, String lastName) {
        Employee employee = new Employee(firsName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
           return employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
