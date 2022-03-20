package spring_boot.boot.DAO;

//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring_boot.boot.Entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        return session.createQuery("from Employee", Employee.class)
//                .getResultList();
        Query query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());

    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        return session.get(Employee.class, id);
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query query = session.createQuery("delete from Employee where id =:employeeId");
//        query.setParameter("employeeId", id);
//        query.executeUpdate();
        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
