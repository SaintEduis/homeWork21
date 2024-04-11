package pro.sky.homeWork21;

import java.util.List;

public interface StorageService {
    void addWorker(Employee newWorker);

    void removeWorker(String name);

    Employee findWorker(String name);

    Employee maxSalaryWorker(int department);

    Employee minSalaryWorker(int department);

    List<Employee> allDepartmentWorker(int department);

    List<Employee> allWorkersByDepartments();
}