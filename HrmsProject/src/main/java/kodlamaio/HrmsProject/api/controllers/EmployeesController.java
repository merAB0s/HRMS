package kodlamaio.HrmsProject.api.controllers;
import kodlamaio.HrmsProject.business.abstracts.EmployeeService;
import kodlamaio.HrmsProject.core.utilities.results.DataResult;
import kodlamaio.HrmsProject.core.utilities.results.Result;
import kodlamaio.HrmsProject.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeesController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/getallemployee")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

    @PostMapping("/addemployee")
    public Result add(@Valid @RequestBody Employee employee) {
        return this.employeeService.add(employee);
    }

    @PostMapping("/updateemployee")
    public Result update(@RequestBody Employee employee) {
        return this.employeeService.update(employee);
    }

    @PostMapping("/deleteemployee")
    public Result delete(@RequestBody Employee employee) {
        return this.employeeService.delete(employee);
    }
}
