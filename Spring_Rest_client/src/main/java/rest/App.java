package rest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rest.Entity.Employee;
import rest.configuration.MyConfig;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
//        List<Employee> employees = communication.getAllEmployees();
//        System.out.println(employees);
          communication.deleteEmployee(16);
//        Employee employee = new Employee("DoKep", "Black", "HR", 1234);
//        communication.saveEmployee(employee);
    }
}
