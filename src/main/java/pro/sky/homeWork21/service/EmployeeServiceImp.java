package pro.sky.homeWork21.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homeWork21.domain.Employee;
import pro.sky.homeWork21.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeWork21.exceptions.EmployeeNotFoundException;
import pro.sky.homeWork21.exceptions.EmployeeStorageIsEmptyException;
import pro.sky.homeWork21.exceptions.BadRequestException;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private Map<String, Employee> employees;

    public EmployeeServiceImp() {employees = new HashMap<>();}

    @Override
    public void addEmployee(String name, Integer department, Integer salary) {
        if (!(employees.containsKey(name))) {
            if (!(StringUtils.containsAny(name, "1234567890-+=_!@#$%^&*()\\|/\"'?.,<>;:`~") || name.isEmpty())) {
                String newName = StringUtils.capitalize(name.toLowerCase());
                employees.put(newName, new Employee(newName, department, salary));
            }
            else {
                throw new BadRequestException();
            }
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