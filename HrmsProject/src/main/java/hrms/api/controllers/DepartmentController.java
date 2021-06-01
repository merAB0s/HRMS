package hrms.api.controllers;

import hrms.business.abstracts.DepartmentService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deparment")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<Department>> getAll() {
        return this.departmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Department department) {
        return this.departmentService.add(department);
    }




}
