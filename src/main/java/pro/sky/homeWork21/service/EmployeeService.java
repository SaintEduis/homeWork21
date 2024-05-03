package pro.sky.homeWork21.service;

import org.apache.coyote.BadRequestException;
import pro.sky.homeWork21.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    void addEmployee(String name, Integer department, Integer salary) throws BadRequestException;

    void removeEmployee(String name);

    Employee findEmployee(String name);

    Collection<Employee> findAll();
}