package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rest.Entity.Employee;
import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/Spring_rest_war_exploded/api/employees";

    public List<Employee> getAllEmployees(){
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
        });
        List<Employee> employees = responseEntity.getBody();
        return employees;
    }
    public Employee getEmployee(int id){
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }
    public void saveEmployee(Employee employee){
        int id = employee.getId();
        if(id == 0){
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New employee was added to database");
            System.out.println(responseEntity.getBody());
        }
        else{
            restTemplate.put(URL, employee);
            System.out.println("Employee with ID = " + id + " was added to database");
        }
    }
    public void deleteEmployee(int id){
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with ID = " + id + " was deleted from database");
    }
}
