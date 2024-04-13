package pro.sky.homeWork21.service;

import org.springframework.stereotype.Service;
import pro.sky.homeWork21.domain.Employee;
import pro.sky.homeWork21.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeWork21.exceptions.EmployeeNotFoundException;
import pro.sky.homeWork21.exceptions.EmployeeStorageIsEmptyException;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private Map<String, Employee> employees;

    public EmployeeServiceImp() {employees = new HashMap<>();}

    @Override
    public void addEmployee(String name, Employee newEmployee) {
        if (!(employees.containsKey(name))) {
            employees.put(name, newEmployee);
        }
        else {
            throw new EmployeeAlreadyAddedException();
        }
    }

    @Override
    public void removeEmployee(String name) {
        if (employees.containsKey(name)) {
            employees.remove(name);
        }
        else{
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String name) {
        if (employees.containsKey(name)) {
            return employees.get(name);
        }
        else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> findAll() {
        if (!(employees.isEmpty())) {
            return Collections.unmodifiableCollection(employees.values());
        }
        else {
            throw new EmployeeStorageIsEmptyException();
        }
    }
}