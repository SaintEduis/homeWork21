package pro.sky.homeWork21.service;

import pro.sky.homeWork21.domain.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxEmployeeSalary(int department);

    Employee minEmployeeSalary(int department);

    List<Employee> allEmployeesByDepartments(int department);

    Map<Integer, List<Employee>> allEmployeesByDepartments();
}
