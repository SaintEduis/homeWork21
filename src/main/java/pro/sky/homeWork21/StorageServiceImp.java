package pro.sky.homeWork21;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StorageServiceImp implements StorageService{
    private List<Employee> storageOfWorkers = new ArrayList<>();

    @Override
    public void addWorker(Employee newWorker) {
        storageOfWorkers.add(newWorker);
    }

    @Override
    public void removeWorker(String name) {
        storageOfWorkers.remove(name);
    }

    @Override
    public Employee findWorker(String name) {
        final Optional<Employee> worker = storageOfWorkers.stream()
                .filter(e -> e.getFullNameOfWorker().equals(name))
                .findAny();
        return worker.get();
    }

    @Override
    public Employee maxSalaryWorker(int department) {
        final Integer salary = storageOfWorkers.stream()
                .filter(e -> e.getDepartment() == department)
                .map(e -> e.getSalary())
                .max(Integer::compare).get();

        final Optional<Employee> worker = storageOfWorkers.stream()
                .filter(e -> e.getSalary() == salary)
                .findAny();

        return worker.get();
    }

    @Override
    public Employee minSalaryWorker(int department) {
        final Integer salary = storageOfWorkers.stream()
                .filter(e -> e.getDepartment() == department)
                .map(e -> e.getSalary())
                .min(Integer::compare).get();

        final Optional<Employee> worker = storageOfWorkers.stream()
                .filter(e -> e.getSalary() == salary)
                .findAny();

        return worker.get();
    }

    @Override
    public List<Employee> allDepartmentWorker(int department) {
        final List<Employee> workers = storageOfWorkers.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());

        return workers;
    }

    @Override
    public List<Employee> allWorkersByDepartments() {
        List<Employee> employeeByDepartments = new ArrayList<>();

        final List<Integer> departments = storageOfWorkers.stream()
                .map(e -> e.getDepartment())
                .collect(Collectors.toSet())
                .stream()
                .collect(Collectors.toList());

        departments.stream()
                .collect(Collectors.toList())
                .forEach(e -> allDepartmentWorker(e).stream().forEach(p -> employeeByDepartments.add(p)));

        return employeeByDepartments;
    }
}