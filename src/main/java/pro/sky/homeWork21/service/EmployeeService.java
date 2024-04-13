package pro.sky.homeWork21.service;

import pro.sky.homeWork21.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    void addEmployee(String name, Employee newWorker);

    void removeEmployee(String name);

    Employee findEmployee(String name);

    Collection<Employee> findAll();
}