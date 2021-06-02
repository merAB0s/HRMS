package hrms.api.controllers;

import hrms.business.abstracts.WorkplaceService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.School;
import hrms.entities.concretes.Workplaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workplaces")
public class WorkplaceController {

    private WorkplaceService workplaceService;

    @Autowired
    public WorkplaceController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    @GetMapping("/getall")
    public DataResult<List<Workplaces>> getAll() {
        return this.workplaceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Workplaces workplaces) {
        return this.workplaceService.add(workplaces);
    }




}
