package hrms.api.controllers;

import hrms.business.abstracts.SchoolDepartmentService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.schoolDepartmentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody SchoolDepartment schoolDepartment){
        return ResponseEntity.ok(this.schoolDepartmentService.add(schoolDepartment));
    }
}
