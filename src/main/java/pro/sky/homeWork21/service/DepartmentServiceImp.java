package pro.sky.homeWork21.service;

import org.springframework.stereotype.Service;
import pro.sky.homeWork21.domain.Employee;
import pro.sky.homeWork21.exceptions.EmployeeStorageIsEmptyException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

@Service
public class DepartmentServiceImp implements DepartmentService{
    private final EmployeeService employeeService;

    public DepartmentServiceImp(EmployeeService employeeService) {this.employeeService = employeeService;}

    @Override
    public Employee maxEmployeeSalary(int department) {
        if (employeeService.findAll().size() >= 2) {
            Optional<Employee> result = employeeService
                    .findAll()
                    .stream()
                    .filter(e -> e.getDepartment() == department)
                    .max(comparingInt(Employee::getSalary));

            return result.get();
        }
        else {
            throw new EmployeeStorageIsEmptyException();
        }
    }

    @Override
    public Employee minEmployeeSalary(int department) {
        if (employeeService.findAll().size() >= 2) {
            Optional<Employee> result = employeeService
                    .findAll()
                    .stream()
                    .filter(e -> e.getDepartment() == department)
                    .min(comparingInt(Employee::getSalary));

            return result.get();
        }
        else {
            throw new EmployeeStorageIsEmptyException();
        }
    }

    @Override
    public List<Employee> allEmployeesByDepartments(int department) {
        if (!(employeeService.findAll().isEmpty())) {
            List<Employee> result = employeeService
                    .findAll()
                    .stream()
                    .filter(e -> e.getDepartment() == department)
                    .collect(Collectors.toList());

            return result;
        }
        else {
            throw new EmployeeStorageIsEmptyException();
        }
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesByDepartments() {
        if (!(employeeService.findAll().isEmpty())) {
            Map<Integer, List<Employee>> result = employeeService
                    .findAll()
                    .stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));

            return result;
        }
        else {
            throw new EmployeeStorageIsEmptyException();
        }
    }
}
