package mvc;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;

public class Employee {
    @Size(min = 5, max = 7, message = "name must be min 5 and max 7")
    private String name;
    @NotBlank(message = "field is required")
    private String surname;
    private int salary;
    private String department;

    public HashMap<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(HashMap<String, String> departments) {
        this.departments = departments;
    }

    private HashMap<String, String> departments;
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee() {
        departments = new HashMap<>();
        departments.put("IT", "Information Technologies");
        departments.put("HR", "Human Resources");
        departments.put("Sales", "Sales");
    }
}
