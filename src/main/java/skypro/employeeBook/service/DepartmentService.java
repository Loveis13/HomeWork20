package skypro.employeeBook.service;

import skypro.employeeBook.dto.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalaryEmployee(int department);
    Employee minSalaryEmployee(int department);
    Collection<Employee> getEmployeeInDepartment(int department);

    Map<Integer, List<Employee>> getAll();
}
