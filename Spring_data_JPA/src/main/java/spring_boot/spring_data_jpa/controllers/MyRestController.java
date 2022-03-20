package spring_boot.spring_data_jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_boot.spring_data_jpa.Entity.Employee;
import spring_boot.spring_data_jpa.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmplotee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
//        if(employee == null){
//            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in database");
//        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
//        if(employee == null){
//            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in database");
//        }
        employeeService.deleteEmployee(id);
        return "Employee with ID " + id + " was deleted";
    }
    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name){
        List<Employee> employees = employeeService.findAllByName(name);
        return employees;
    }
}
