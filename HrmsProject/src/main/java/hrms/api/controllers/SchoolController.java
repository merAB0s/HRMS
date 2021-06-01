package hrms.api.controllers;

import hrms.business.abstracts.SchoolService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @GetMapping("/getall")
    public DataResult<List<School>> getAll() {
        return this.schoolService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody School school) {
        return this.schoolService.add(school);
    }


}
