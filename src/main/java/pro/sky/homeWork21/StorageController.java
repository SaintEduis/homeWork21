package pro.sky.homeWork21;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StorageController {
    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping(path = "/EmployeeBook/add")
    public String addWorker(@RequestParam("name") String name,
                            @RequestParam("department") Integer department,
                            @RequestParam("salary") Integer salary) {
        storageService.addWorker(new Employee(name, department, salary));
        return "Сотрудник успешно добавлен!";
    }

    @GetMapping(path = "/EmployeeBook/remove")
    public String removeWorker(@RequestParam("name") String name) {
        storageService.removeWorker(name);
        return "Сотрудник успешно удалён!";
    }

    @GetMapping(path = "/EmployeeBook/find")
    public Employee findWorker(@RequestParam("name") String name) {
        return storageService.findWorker(name);
    }

    @GetMapping(path = "/departments/max-salary")
    public Employee maxSalaryWorker(@RequestParam("departmentId") int department) {
        return storageService.maxSalaryWorker(department);
    }

    @GetMapping(path = "/departments/min-salary")
    public Employee minSalaryWorker(@RequestParam("departmentId") int department) {
        return storageService.minSalaryWorker(department);
    }

    @GetMapping(path = "/departments/all", params = "departmentId")
    public List<Employee> allDepartmentWorker(@RequestParam("departmentId") int department) {
        return storageService.allDepartmentWorker(department);
    }

    @GetMapping(path = "/departments/all")
    public List<Employee> allDepartmentWorker() {
        return storageService.allWorkersByDepartments();
    }
}
