package hrms.api.controllers;

import hrms.business.abstracts.SchoolDepartmentService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schooldapartment")
public class SchoolDepartmentController {

    private SchoolDepartmentService schoolDepartmentService;

    @Autowired
    public SchoolDepartmentController(SchoolDepartmentService schoolDepartmentService) {
        this.schoolDepartmentService = schoolDepartmentService;
    }



    @GetMapping("/getall")
    public DataResult<List<SchoolDepartment>> getAll() {
        return this.schoolDepartmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolDepartment schoolDepartment) {
        return this.schoolDepartmentService.add(schoolDepartment);
    }
}
