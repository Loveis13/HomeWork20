package skypro.employeeBook.controller;

import org.springframework.web.bind.annotation.*;
import skypro.employeeBook.dto.Employee;
import skypro.employeeBook.service.EmployeeService;
import skypro.employeeBook.util.EmployeeNameValidator;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam int department,double salary) {
        EmployeeNameValidator.validateIsAlpha(firstName,lastName);
        return employeeService.addEmployee(firstName, lastName,department,salary);

    }

    @GetMapping("/remove")
    public Employee remoteEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        EmployeeNameValidator.validateIsAlpha(firstName,lastName);
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee getEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        EmployeeNameValidator.validateIsAlpha(firstName,lastName);
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee>getAll(){
        return employeeService.findAll();
    }
    private String generateKey(String firstName,String lastName){
        return firstName + lastName;
    }


}
