package spring_boot.spring_data_jpa.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot.spring_data_jpa.Entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByName(String name);
}
